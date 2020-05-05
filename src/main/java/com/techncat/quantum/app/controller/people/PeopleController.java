package com.techncat.quantum.app.controller.people;

import com.alibaba.fastjson.JSONObject;
import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.annotation.ROLE;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.people.FamilyInfo;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.service.people.*;
import com.techncat.quantum.app.vos.people.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/people")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class PeopleController {

    @Autowired
    private PeopleShowService showService;
    @Autowired
    private PeopleCreateService createService;
    @Autowired
    private PeopleUpdateService updateService;
    @Autowired
    private PeopleDeleteService deleteService;
    @Autowired
    private PeopleFamilyService familyService;
    @Autowired
    private VOEnhanceUtil voEnhanceUtil;

    // show
    @GetMapping("/{people_id}/base")
    public ResponseEntity<PeopleVO> showBase(@PathVariable("people_id") Long id) throws PeopleShowService.PeopleNotFoundException {
        return ResponseEntity.ok(showService.showBase(id));
    }

    @GetMapping("/{people_id}/base/structure")
    public ResponseEntity<Map> baseStructureInfo(@PathVariable("people_id") Long peopleId) throws PeopleShowService.PeopleNotFoundException, IllegalAccessException {
        PeopleVO peopleVO = showService.showBase(peopleId);
        Map result = voEnhanceUtil.enhance("data", peopleVO);
        result.put("index", "people.basic_info");
        result.put("key", "base");
        result.put("priority", "1");
//        result.put("post_url", "/api/people/" + peopleVO.getType().name());
        if (peopleVO.getType() != null)
            result.put("update_url", "/api/people/" + peopleId + "/" + peopleVO.getType().name());
        else
            result.put("update_url", "/api/people/" + peopleId + "/base");
        result.put("delete_url", "/api/people/" + peopleId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{people_id}/extra")
    public ResponseEntity<?> showExtra(@PathVariable("people_id") Long id) throws PeopleShowService.PeopleNotFoundException {
        People people = showService.fetchBase(id);
        return ResponseEntity.ok(showService.showExtra(people, people.getType()));
    }

    @GetMapping("/{people_id}/extra/structure")
    public ResponseEntity<Map> extraStructureInfo(@PathVariable("people_id") Long peopleId) throws PeopleShowService.PeopleNotFoundException, IllegalAccessException {
        People people = showService.fetchBase(peopleId);
        Object data = showService.showExtra(people, people.getType());
        Map result = voEnhanceUtil.enhance("data", data);
        result.put("index", "people.other_info");
        result.put("key", "extra");
        result.put("priority", "2");
//        result.put("post_url", "/api/people/" + people.getType().name());
        result.put("update_url", "/api/people/" + peopleId + "/" + people.getType().name());
        result.put("delete_url", "/api/people/" + peopleId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{people_id}/families")
    public ResponseEntity<?> showFamilies(@PathVariable("people_id") Long id) throws PeopleShowService.PeopleNotFoundException {
        People people = showService.fetchBase(id);
        return ResponseEntity.ok(familyService.list(people));
    }

    @GetMapping("/{people_id}/families/structure")
    public ResponseEntity<?> familiesStructure(@PathVariable("people_id") Long peopleId) throws IllegalAccessException, PeopleFamilyService.FamilyInfoNotFoundException {
        Map result = voEnhanceUtil.enhance("data", new FamilyInfoVO());
        result.put("index", "people.family_info");
        result.put("post_url", "/api/people/" + peopleId + "/families");
        result.put("delete_url", "/api/people/" + peopleId + "/families");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{people_id}/families/{family_id}")
    public ResponseEntity<?> showFamily(@PathVariable("people_id") Long id, @PathVariable("family_id") Long familyId) throws PeopleFamilyService.FamilyInfoNotFoundException {
        return ResponseEntity.ok(familyService.fetch(familyId));
    }

    @GetMapping("/{people_id}/families/{family_id}/structure")
    public ResponseEntity<?> familyStructure(@PathVariable("people_id") Long peopleId, @PathVariable("family_id") Long familyId) throws IllegalAccessException, PeopleFamilyService.FamilyInfoNotFoundException {
        Map result = voEnhanceUtil.enhance("data", familyService.fetch(familyId));
        result.put("post_url", "/api/people/" + peopleId + "/families");
        result.put("update_url", "/api/people/" + peopleId + "/families/" + familyId);
        result.put("delete_url", "/api/people/" + peopleId + "/families" + familyId);
        result.put("index", "people.family_info");
        return ResponseEntity.ok(result);
    }

    // create

    @PostMapping("/base")
    public ResponseEntity<People> createBase(@ForkiAser(requiredRoles = {ROLE.edit_people}) Aser aser,
                                             @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        PeopleVO peopleVO = requestBody.getJSONObject("base").toJavaObject(PeopleVO.class);
        return ResponseEntity.status(201).body(createService.create(peopleVO));
    }

    @PostMapping("/administration")
    public ResponseEntity<People> createAdmin(@ForkiAser(requiredRoles = {ROLE.edit_people, ROLE.edit_people_administration}) Aser aser,
                                              @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        PeopleVO peopleVO = requestBody.getJSONObject("base").toJavaObject(PeopleVO.class);
        PeopleAdminVO adminVO = requestBody.getJSONObject("extra").toJavaObject(PeopleAdminVO.class);
        return ResponseEntity.status(201).body(createService.create(peopleVO, adminVO));
    }

    @PostMapping("/postdoctoral")
    public ResponseEntity<People> createPostdoctoral(@ForkiAser(requiredRoles = {ROLE.edit_people, ROLE.edit_people_postdoctoral}) Aser aser,
                                                     @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        PeopleVO peopleVO = requestBody.getJSONObject("base").toJavaObject(PeopleVO.class);
        PeoplePostdoctoralVO extraVO = requestBody.getJSONObject("extra").toJavaObject(PeoplePostdoctoralVO.class);
        return ResponseEntity.status(201).body(createService.create(peopleVO, extraVO));
    }

    @PostMapping("/researcher")
    public ResponseEntity<People> createResearcher(@ForkiAser(requiredRoles = {ROLE.edit_people, ROLE.edit_people_researcher}) Aser aser,
                                                   @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        PeopleVO peopleVO = requestBody.getJSONObject("base").toJavaObject(PeopleVO.class);
        PeopleResearcherVO extraVO = requestBody.getJSONObject("extra").toJavaObject(PeopleResearcherVO.class);
        return ResponseEntity.status(201).body(createService.create(peopleVO, extraVO));
    }

    @PostMapping("/student")
    public ResponseEntity<People> createStudent(@ForkiAser(requiredRoles = {ROLE.edit_people, ROLE.edit_people_student}) Aser aser,
                                                @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        PeopleVO peopleVO = requestBody.getJSONObject("base").toJavaObject(PeopleVO.class);
        PeopleStudentVO extraVO = requestBody.getJSONObject("extra").toJavaObject(PeopleStudentVO.class);
        return ResponseEntity.status(201).body(createService.create(peopleVO, extraVO));
    }

    @PostMapping("/teacher")
    public ResponseEntity<People> createTeacher(@ForkiAser(requiredRoles = {ROLE.edit_people, ROLE.edit_people_teacher}) Aser aser,
                                                @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        PeopleVO peopleVO = requestBody.getJSONObject("base").toJavaObject(PeopleVO.class);
        PeopleTeacherVO extraVO = requestBody.getJSONObject("extra").toJavaObject(PeopleTeacherVO.class);
        return ResponseEntity.status(201).body(createService.create(peopleVO, extraVO));
    }

    @PostMapping("/visitor")
    public ResponseEntity<People> createVisitor(@ForkiAser(requiredRoles = {ROLE.edit_people, ROLE.edit_people_visitor}) Aser aser,
                                                @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        PeopleVO peopleVO = requestBody.getJSONObject("base").toJavaObject(PeopleVO.class);
        PeopleVisitorVO extraVO = requestBody.getJSONObject("extra").toJavaObject(PeopleVisitorVO.class);
        return ResponseEntity.status(201).body(createService.create(peopleVO, extraVO));
    }

    @PostMapping("/{people_id}/families")
    public ResponseEntity<FamilyInfo> create(@ForkiAser(requiredRoles = {ROLE.edit_people}) Aser aser,
                                             @PathVariable("people_id") Long peopleId,
                                             @RequestBody FamilyInfo familyInfo) throws PeopleShowService.PeopleNotFoundException {
        return ResponseEntity.status(201).body(familyService.create(peopleId, familyInfo));
    }


    // update

    @PutMapping("/{people_id}/base")
    public ResponseEntity<People> updateBase(@ForkiAser(requiredRoles = {ROLE.edit_people}) Aser aser,
                                             @PathVariable("people_id") Long id,
                                             @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        PeopleVO peopleVO = requestBody.getJSONObject("base").toJavaObject(PeopleVO.class);
        return ResponseEntity.status(200).body(updateService.update(id, peopleVO));
    }

    @PutMapping("/{people_id}/administration")
    public ResponseEntity<People> updateAdmin(@ForkiAser(requiredRoles = {ROLE.edit_people, ROLE.edit_people_administration}) Aser aser,
                                              @PathVariable("people_id") Long id,
                                              @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        PeopleVO peopleVO = requestBody.getJSONObject("base").toJavaObject(PeopleVO.class);
        PeopleAdminVO adminVO = requestBody.getJSONObject("extra").toJavaObject(PeopleAdminVO.class);
        return ResponseEntity.status(200).body(updateService.update(id, peopleVO, adminVO));
    }

    @PutMapping("/{people_id}/postdoctoral")
    public ResponseEntity<People> updatePostdoctoral(@ForkiAser(requiredRoles = {ROLE.edit_people, ROLE.edit_people_postdoctoral}) Aser aser,
                                                     @PathVariable("people_id") Long id,
                                                     @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        PeopleVO peopleVO = requestBody.getJSONObject("base").toJavaObject(PeopleVO.class);
        PeoplePostdoctoralVO extraVO = requestBody.getJSONObject("extra").toJavaObject(PeoplePostdoctoralVO.class);
        return ResponseEntity.status(200).body(updateService.update(id, peopleVO, extraVO));
    }

    @PutMapping("/{people_id}/researcher")
    public ResponseEntity<People> updateResearcher(@ForkiAser(requiredRoles = {ROLE.edit_people, ROLE.edit_people_researcher}) Aser aser,
                                                   @PathVariable("people_id") Long id,
                                                   @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        PeopleVO peopleVO = requestBody.getJSONObject("base").toJavaObject(PeopleVO.class);
        PeopleResearcherVO extraVO = requestBody.getJSONObject("extra").toJavaObject(PeopleResearcherVO.class);
        return ResponseEntity.status(200).body(updateService.update(id, peopleVO, extraVO));
    }

    @PutMapping("/{people_id}/student")
    public ResponseEntity<People> updateStudent(@ForkiAser(requiredRoles = {ROLE.edit_people, ROLE.edit_people_student}) Aser aser,
                                                @PathVariable("people_id") Long id,
                                                @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        PeopleVO peopleVO = requestBody.getJSONObject("base").toJavaObject(PeopleVO.class);
        PeopleStudentVO extraVO = requestBody.getJSONObject("extra").toJavaObject(PeopleStudentVO.class);
        return ResponseEntity.status(200).body(updateService.update(id, peopleVO, extraVO));
    }

    @PutMapping("/{people_id}/teacher")
    public ResponseEntity<People> updateTeacher(@ForkiAser(requiredRoles = {ROLE.edit_people, ROLE.edit_people_teacher}) Aser aser,
                                                @PathVariable("people_id") Long id,
                                                @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        PeopleVO peopleVO = requestBody.getJSONObject("base").toJavaObject(PeopleVO.class);
        PeopleTeacherVO extraVO = requestBody.getJSONObject("extra").toJavaObject(PeopleTeacherVO.class);
        return ResponseEntity.status(200).body(updateService.update(id, peopleVO, extraVO));
    }

    @PutMapping("/{people_id}/visitor")
    public ResponseEntity<People> updateVisitor(@ForkiAser(requiredRoles = {ROLE.edit_people, ROLE.edit_people_visitor}) Aser aser,
                                                @PathVariable("people_id") Long id,
                                                @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        PeopleVO peopleVO = requestBody.getJSONObject("base").toJavaObject(PeopleVO.class);
        PeopleVisitorVO extraVO = requestBody.getJSONObject("extra").toJavaObject(PeopleVisitorVO.class);
        return ResponseEntity.status(200).body(updateService.update(id, peopleVO, extraVO));
    }

    @PutMapping("/{people_id}/families/{family_id}")
    public ResponseEntity<FamilyInfo> update(@ForkiAser(requiredRoles = {ROLE.edit_people}) Aser aser,
                                             @PathVariable("people_id") Long peopleId,
                                             @PathVariable("family_id") Long familyId, @RequestBody FamilyInfo familyInfo) throws PeopleShowService.PeopleNotFoundException, PeopleFamilyService.FamilyInfoNotFoundException {
        return ResponseEntity.status(200).body(familyService.update(peopleId, familyId, familyInfo));
    }

    // delete

    @DeleteMapping("/{people_id}")
    public ResponseEntity delete(@ForkiAser(requiredRoles = {ROLE.delete_people}) Aser aser,
                                 @PathVariable("people_id") Long peopleId) throws PeopleShowService.PeopleNotFoundException {
        deleteService.delete(peopleId);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{people_id}/families")
    public ResponseEntity deleteFamilies(@ForkiAser(requiredRoles = {ROLE.delete_people}) Aser aser,
                                         @PathVariable("people_id") Long peopleId) throws PeopleShowService.PeopleNotFoundException {
        familyService.delete(peopleId);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{people_id}/families/{family_id}")
    public ResponseEntity deleteFamily(@ForkiAser(requiredRoles = {ROLE.delete_people}) Aser aser,
                                       @PathVariable("people_id") Long peopleId,
                                       @PathVariable("family_id") Long familyId) throws PeopleShowService.PeopleNotFoundException {
        familyService.delete(peopleId, familyId);
        return ResponseEntity.status(204).build();
    }
}

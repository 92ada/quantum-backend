package com.techncat.quantum.app.controller.my;

import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.attachment.Attachment;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.service.attachment.AttachmentService;
import com.techncat.quantum.app.service.people.PeopleShowService;
import com.techncat.quantum.app.vos.people.PeopleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/my")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class MyController {
    @Autowired
    private VOEnhanceUtil voEnhanceUtil;
    @Autowired
    private VOUtils voUtils;
    @Autowired
    private PeopleShowService showService;
    @Autowired
    private AttachmentService attachmentService;


    @GetMapping("/base/structure")
    public ResponseEntity<Map> baseStructureInfo(@ForkiAser(requiredRoles = {}) Aser aser) throws PeopleShowService.PeopleNotFoundException, IllegalAccessException {
        String sid = aser.getSid();
        People people = showService.fetchBySid(sid);
        String peopleId = people.getId().toString();
        PeopleVO peopleVO = voUtils.copy(people, PeopleVO.class);
        Map result = voEnhanceUtil.enhance("data", peopleVO);
        result.put("index", "people.basic_info");
        result.put("key", "base");
        result.put("priority", "1");
        if (peopleVO.getType() != null)
            result.put("update_url", "/api/people/" + peopleId + "/" + peopleVO.getType().name());
        else
            result.put("update_url", "/api/people/" + peopleId + "/base");
        result.put("delete_url", "/api/people/" + peopleId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/extra/structure")
    public ResponseEntity<Map> extraStructureInfo(@ForkiAser(requiredRoles = {}) Aser aser) throws PeopleShowService.PeopleNotFoundException, IllegalAccessException {
        String sid = aser.getSid();
        People people = showService.fetchBySid(sid);
        String peopleId = people.getId().toString();
        Object data = showService.showExtra(people, people.getType());
        Map result = voEnhanceUtil.enhance("data", data);
        result.put("index", "people.other_info");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("update_url", "/api/people/" + peopleId + "/" + people.getType().name());
        result.put("delete_url", "/api/people/" + peopleId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/attachment")
    public List<Attachment> listMyAttachment(@ForkiAser(requiredRoles = {}) Aser aser) {
        String sid = aser.getSid();
        Long peopleId = showService.fetchBySid(sid).getId();
        return attachmentService.listPeopleAttachment(peopleId);
    }

    @GetMapping("/info")
    public ResponseEntity<PeopleVO> info(@ForkiAser(requiredRoles = {}) Aser aser) {
        String sid = aser.getSid();
        People people = showService.fetchBySid(sid);
        PeopleVO peopleVO = voUtils.copy(people, PeopleVO.class);
        return ResponseEntity.ok(peopleVO);
    }
}

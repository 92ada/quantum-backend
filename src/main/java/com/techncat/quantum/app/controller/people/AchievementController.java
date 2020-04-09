package com.techncat.quantum.app.controller.people;


import com.techncat.quantum.app.model.people.Achievement;
import com.techncat.quantum.app.service.people.StudentAchievementService;
import com.techncat.quantum.app.service.research.ResearchShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class AchievementController {
    @Autowired
    private StudentAchievementService achievementService;

   
    /* Student Achievement */

    @GetMapping("/{people_id}/achievement")
    public List listAchievement(@PathVariable("people_id") Long peopleId) throws ResearchShowService.ProjectNotFoundException {
        try {
            return achievementService.list(peopleId);
        } catch (StudentAchievementService.IsNotStudentException e) {
            return null;
        }
    }

    @PostMapping("/{people_id}/achievement")
    public Achievement addAchievement(@PathVariable("people_id") Long peopleId, @RequestBody Achievement data) throws ResearchShowService.ProjectNotFoundException {
        return achievementService.create(peopleId, data);
    }

    @PutMapping("/{people_id}/achievement/{achievement_id}")
    public Achievement updateAchievement(@PathVariable("people_id") Long peopleId, @PathVariable("achievement_id") Long achievementId, @RequestBody Achievement data) throws StudentAchievementService.StudentAchievementNotFoundException, ResearchShowService.ProjectNotFoundException {
        return achievementService.update(peopleId, achievementId, data);
    }

    @DeleteMapping("/{people_id}/achievement/{achievement_id}")
    public ResponseEntity removeAchievement(@PathVariable("people_id") Long peopleId, @PathVariable("achievement_id") Long achievementId) throws ResearchShowService.ProjectNotFoundException {
        achievementService.delete(peopleId, achievementId);
        return ResponseEntity.status(204).build();
    }
}

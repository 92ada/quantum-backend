package com.techncat.quantum.app.controller.research;

import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.model.research.Paper;
import com.techncat.quantum.app.model.research.Patent;
import com.techncat.quantum.app.model.research.Project;
import com.techncat.quantum.app.model.research.Reward;
import com.techncat.quantum.app.service.research.ResearchSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/research")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class ResearchSearcher {
    @Autowired
    private ResearchSearchService researchSearchService;

    @GetMapping("/paper")
    public Page<Paper> searchPaper(@ForkiAser Aser aser,
                                   @RequestParam(value = "word", defaultValue = "") String word,
                                   @RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "limit", defaultValue = "10") Integer size,
                                   @RequestParam(value = "order", defaultValue = "desc") String order,
                                   @RequestParam(value = "by", defaultValue = "createdAt") String byProp) {
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(page - 1, size, sort);
        return researchSearchService.searchPaper(aser, word, request);
    }

    @GetMapping("/patent")
    public Page<Patent> searchPatent(@ForkiAser Aser aser,
                                     @RequestParam(value = "word", defaultValue = "") String word,
                                     @RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "limit", defaultValue = "10") Integer size,
                                     @RequestParam(value = "order", defaultValue = "desc") String order,
                                     @RequestParam(value = "by", defaultValue = "createdAt") String byProp) {
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(page - 1, size, sort);
        return researchSearchService.searchPatent(aser, word, request);
    }

    @GetMapping("/project")
    public Page<Project> searchProject(@ForkiAser Aser aser,
                                       @RequestParam(value = "word", defaultValue = "") String word,
                                       @RequestParam(value = "page", defaultValue = "1") Integer page,
                                       @RequestParam(value = "limit", defaultValue = "10") Integer size,
                                       @RequestParam(value = "order", defaultValue = "desc") String order,
                                       @RequestParam(value = "by", defaultValue = "createdAt") String byProp) {
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(page - 1, size, sort);
        return researchSearchService.searchProject(aser, word, request);
    }

    @GetMapping("/reward")
    public Page<Reward> searchReward(@ForkiAser Aser aser,
                                     @RequestParam(value = "word", defaultValue = "") String word,
                                     @RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "limit", defaultValue = "10") Integer size,
                                     @RequestParam(value = "order", defaultValue = "desc") String order,
                                     @RequestParam(value = "by", defaultValue = "createdAt") String byProp) {
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(page - 1, size, sort);
        return researchSearchService.searchReward(aser, word, request);
    }
}

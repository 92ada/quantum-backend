package com.techncat.quantum.app.controller.people;

import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.service.people.People_SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
public class PeopleSearcher {

    @Autowired
    private People_SearchService people_searchService;

    @GetMapping
    public Page<People> search(@ForkiAser Aser aser,
                               @RequestParam(value = "word", required = false) String word,
                               @RequestParam(value = "type", required = false) People.Type type,
                               @RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "limit", defaultValue = "10") Integer size,
                               @RequestParam(value = "order", defaultValue = "desc") String order,
                               @RequestParam(value = "by", defaultValue = "createdAt") String byProp) {
        // sort
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(page - 1, size, sort);
        // find in ids

        boolean isRoot = aser.getRoles().contains("root") || aser.getRoles().contains("people");

        if (type == null && !isRoot) {
            return people_searchService.search(word, aser.getSid(), request);
        }
        if (type == null && isRoot) {
            return people_searchService.search(word, request);
        }
        if (type != null && !isRoot) {
            return people_searchService.search(word, type, aser.getSid(), request);
        }
        if (type != null && isRoot) {
            return people_searchService.search(word, type, request);
        }
        return null;
    }

    @GetMapping("/options")
    public List<People> search(@RequestParam(value = "word", required = false) String word) {
        return people_searchService.search(word);
    }
}

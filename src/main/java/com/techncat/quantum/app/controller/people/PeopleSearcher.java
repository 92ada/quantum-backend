package com.techncat.quantum.app.controller.people;

import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.service.people.People_SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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
    public Page<People> search(@RequestParam(value = "word", required = false) String word,
                               @RequestParam(value = "type", required = false) People.Type type,
                               @RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size,
                               @RequestParam(value = "order", defaultValue = "desc") String order,
                               @RequestParam(value = "by", defaultValue = "createdAt") String byProp) {
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(page, size, sort);
        if (type == null) {
            return people_searchService.search(word, request);
        } else {
            return people_searchService.search(word, type, request);
        }
    }
}
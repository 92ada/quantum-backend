package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.people.People_Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class People_SearchService {

    @Resource
    private People_Repository peopleRepository;

    public Page<People> search(String word, PageRequest pageRequest) {
        if (word == null) {
            return peopleRepository.findAll(pageRequest);
        }
        String wordLike = "%" + word + "%";
        return peopleRepository.findAllByNameLikeOrSidLikeOrEmailLike(wordLike, wordLike, wordLike, pageRequest);
    }

    public Page<People> search(String word, People.Type type, PageRequest pageRequest) {
        if (word == null) {
            return peopleRepository.findAllByType(type, pageRequest);
        }
        String wordLike = "%" + word + "%";
        return peopleRepository.findAllByTypeAndNameLikeOrSidLikeOrEmailLike(type, wordLike, wordLike, wordLike, pageRequest);
    }

    public List<People> search(String word) {
        String wordLike = "%" + word + "%";
        return peopleRepository.findAllByNameLike(wordLike);
    }
}

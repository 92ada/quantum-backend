package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.model.people.Lab;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.people.LabRepository;
import com.techncat.quantum.app.repository.people.People_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class People_SearchService {

    @Resource
    private People_Repository peopleRepository;
    @Autowired
    private LabRunner runner;

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
        return peopleRepository.findAllByTypeAndNameLikeOrTypeAndSidLikeOrTypeAndEmailLike(type, wordLike, type, wordLike, type, wordLike, pageRequest);
    }

    public Page<People> search(String word, String sid, PageRequest pageRequest) {
        List<Long> ids = runner.fixUserIds(sid);
        if (word == null) {
            return peopleRepository.findAllByIdIn(ids, pageRequest);
        }
        String wordLike = "%" + word + "%";
        return peopleRepository.findAllByNameLikeAndIdInOrSidLikeAndIdInOrEmailLikeAndIdIn(wordLike, ids, wordLike, ids, wordLike, ids, pageRequest);
    }

    public Page<People> search(String word, People.Type type, String sid, PageRequest pageRequest) {
        List<Long> ids = runner.fixUserIds(sid);
        if (word == null) {
            return peopleRepository.findAllByTypeAndIdIn(type, ids, pageRequest);
        }
        String wordLike = "%" + word + "%";
        return peopleRepository.findAllByTypeAndNameLikeAndIdInOrTypeAndSidLikeAndIdInOrTypeAndEmailLikeAndIdIn(type, wordLike, ids, type, wordLike, ids, type, wordLike, ids, pageRequest);
    }


    public List<People> search(String word) {
        if (word == null) return peopleRepository.findAll();
        String wordLike = "%" + word + "%";
        return peopleRepository.findAllByNameLike(wordLike);
    }
}

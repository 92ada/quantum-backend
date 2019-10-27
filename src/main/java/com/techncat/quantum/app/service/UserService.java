package com.techncat.quantum.app.service;

import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.UserRepository;
import com.techncat.quantum.app.vos.PeopleHomePageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<PeopleHomePageVO> list() {
        List<People> list = userRepository.findAll();
        return toVO(list);
    }

    public List<PeopleHomePageVO> list(String status, String type) {
        List<People> list = userRepository.findAllByStatusAndType(status, type);
        return toVO(list);
    }

    public PeopleHomePageVO fetch(Long id) throws PeopleNotFoundException {
        People people = userRepository.getOne(id);
        if (null == people) throw new PeopleNotFoundException(id);
        return toVO(people);
    }

    public PeopleHomePageVO create(PeopleHomePageVO vo) {
        People people = fromVO(vo);
        People record = userRepository.save(people);
        return toVO(record);
    }

    public PeopleHomePageVO update(Long userId, PeopleHomePageVO attr) throws PeopleNotFoundException {
        PeopleHomePageVO vo = fetch(userId);
        People people = fromVO(vo);
        BeanUtils.copyProperties(attr, people);
        People record = userRepository.save(people);
        return toVO(record);
    }

    public void delete(Long id) throws PeopleNotFoundException {
        PeopleHomePageVO vo = fetch(id);
        userRepository.delete(fromVO(vo));
    }

    private List<PeopleHomePageVO> toVO(List<People> peopleList) {
        if (peopleList.isEmpty()) return new ArrayList<>();
        List<PeopleHomePageVO> vos = new ArrayList<>();
        for (People people: peopleList) {
            vos.add(toVO(people));
        }
        return vos;
    }

    private PeopleHomePageVO toVO(People people) {
        PeopleHomePageVO vo = new PeopleHomePageVO();
        BeanUtils.copyProperties(people, vo);
        return vo;
    }

    private People fromVO(PeopleHomePageVO vo) {
        People people = new People();
        BeanUtils.copyProperties(vo, people);
        return people;
    }

    public static class PeopleNotFoundException extends Exception {
        PeopleNotFoundException(Long userId) {
            super("People Id=[" + (userId == null ? -1 : userId) + "] Not Found");
        }
    }
}

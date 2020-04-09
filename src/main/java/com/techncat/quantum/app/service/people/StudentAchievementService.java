package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.people.Achievement;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.people.PeopleAchievementRepository;
import com.techncat.quantum.app.vos.people.AchievementVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class StudentAchievementService {
    @Autowired
    private VOUtils voUtils;
    @Autowired
    private PeopleShowService showService;
    @Autowired
    private PeopleAchievementRepository studentAchievementRepository;

    public List<Achievement> list(People people) throws IsNotStudentException {
        if (people.getType() == People.Type.student)
            return studentAchievementRepository.findAllByPeople(people);
        throw new IsNotStudentException(people.getId());
    }

    public List<Achievement> list(Long peopleId) throws PeopleShowService.PeopleNotFoundException, IsNotStudentException {
        return list(showService.fetchBase(peopleId));
    }

    public AchievementVO fetch(Long id) throws StudentAchievementNotFoundException {
        Achievement info = fetchDO(id);
        return voUtils.copy(info, AchievementVO.class);
    }

    public Achievement fetchDO(Long fundId) throws StudentAchievementNotFoundException {
        Achievement info = studentAchievementRepository.findFirstById(fundId);
        if (info != null)
            return info;
        throw new StudentAchievementNotFoundException(fundId);
    }

    public Achievement create(Long peopleId, Achievement info) throws PeopleShowService.PeopleNotFoundException {
        People people = showService.fetchBase(peopleId);
        info.setPeople(people);
        info.setUpdateAt(new Date());
        info.setCreatedAt(new Date());
        return studentAchievementRepository.save(info);
    }

    public Achievement update(Long peopleId, Long fundId, Achievement info) throws PeopleShowService.PeopleNotFoundException, StudentAchievementNotFoundException {
        Achievement record = this.fetchDO(fundId);
        People people = showService.fetchBase(peopleId);
        info.setId(record.getId());
        info.setPeople(people);
        info.setUpdateAt(new Date());
        return studentAchievementRepository.save(info);
    }

    @Transactional
    public void delete(Long peopleId) throws PeopleShowService.PeopleNotFoundException {
        People people = showService.fetchBase(peopleId);
        studentAchievementRepository.deleteAllByPeople(people);
    }

    @Transactional
    public void delete(Long peopleId, Long fundId) throws PeopleShowService.PeopleNotFoundException {
        People people = showService.fetchBase(peopleId);
        studentAchievementRepository.deleteAllByPeopleAndId(people, fundId);
    }

    public static class StudentAchievementNotFoundException extends Exception {
        StudentAchievementNotFoundException(Long id) {
            super("StudentAchievement id[" + id + "] is not found");
        }
    }

    public static class IsNotStudentException extends Exception {
        IsNotStudentException(Long id) {
            super("People id[" + id + "] is not student");
        }
    }
}

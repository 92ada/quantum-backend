package com.techncat.quantum.app.service.user;

import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.user.User;
import com.techncat.quantum.app.model.user.UserRoleGroup;
import com.techncat.quantum.app.model.user.UserRoleItem;
import com.techncat.quantum.app.repository.user.UserRoleGroupRepository;
import com.techncat.quantum.app.service.people.PeopleShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleService {
    @Resource
    private UserRoleGroupRepository roleGroupRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PeopleShowService peopleShowService;

    public List<UserRoleGroup> fetchRoleStatus(Long id) {
        // roles for user:
        People people = peopleShowService.fetchBase(id);
        User user = userService.fetch(people.getSid());
        List<String> roleKeys = user.getRoles();
        // role for total:
        List<UserRoleGroup> roles = roleGroupRepository.findAll();
        for (UserRoleGroup group : roles) {
            if (group == null) continue;
            if (group.getAuths() == null) continue;
            for (UserRoleItem item : group.getAuths()) {
                String currentKey = item.getKey();
                item.setHasAuth(contains(roleKeys, currentKey));
            }
        }
        return roles;
    }

    private boolean contains(List<String> a, String b) {
        for (String s: a) {
            if (s.equals(b)) return true;
        }
        return false;
    }
}

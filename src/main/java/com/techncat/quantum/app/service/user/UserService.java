package com.techncat.quantum.app.service.user;

import com.techncat.quantum.app.model.user.User;
import com.techncat.quantum.app.model.user.UserRoleItem;
import com.techncat.quantum.app.repository.user.UserRepository;
import com.techncat.quantum.app.repository.user.UserRoleItemRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserRoleItemRepository roleItemRepository;

    public User create(String sid) {
        User user = new User();
        user.setSid(sid);
        user.setRoles(this.defaultRoles());
        return userRepository.save(user);
    }

    // 如果不存在则创建一个
    public User fetch(String sid) {
        User user = userRepository.findFirstBySid(sid);
        if (user == null) {
            return create(sid);
        }
        return user;
    }

    public void resetRoles(String sid, List<String> roleNames) {
        for (String roleName : roleNames) {
            UserRoleItem item = roleItemRepository.findFirstByKey(roleName);
            if (item == null) throw new RoleNotFoundException(roleName);
        }
        // reset all
        User user = this.fetch(sid);
        if (user.getRoles().contains("root") && !roleNames.contains("root")) { // root 角色不可被删除
            roleNames.add("root");
        }
        user.setRoles(roleNames);
        userRepository.save(user);
    }

    private List<String> defaultRoles() {
        List<String> roles = new ArrayList<>();
//        roles.add("xx");
        return roles;
    }

    public class RoleNotFoundException extends RuntimeException {
        RoleNotFoundException(String roleName) {
            super("Not such role: " + roleName);
        }
    }
}

package com.techncat.quantum.app.common.auth;

import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.service.people.LabRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthUtil {
    @Autowired
    private AuthHandler authHandler;
    @Autowired
    private LabRunner runner;

//    public <T> T process(@ForkiAser Aser aser, T data) throws IllegalAccessException {
//        Visible.ROLE[] roles = aser.getRoles().stream().map(Visible.ROLE::valueOf).toArray(Visible.ROLE[]::new);
//        return authHandler.preload(roles, data);
//    }
    // 没写好

    // 根据实验室范围，判断目标人员的id是否有访问权限
    public Boolean hasAuth(Aser aser, Long targetId) {
        List<String> roles = aser.getRoles();
        if (roles.contains("root") || roles.contains("people") || roles.contains("delete_people") || roles.contains("edit_people")) {
            return true;
        }
        List<Long> ids = runner.fixUserIds(aser.getSid());
        return ids.contains(targetId);
    }

    public Boolean hasAuth(Aser aser, List<Long> targetIds) {
        if (targetIds.size() == 0)
            return true;

        for (Long id : targetIds) {
            if (hasAuth(aser, id)) return true; // 有访问一个人的权限即可有权限
        }
        return false;
    }

    public Boolean hasAuthToLab(Aser aser, Long labId) {
        return runner.findVisitableLabIds(aser.getSid()).contains(labId);
    }

    public static Boolean isRoot(Aser aser){
        List<String> roles = aser.getRoles();
        return roles.contains("root") || roles.contains("people");
    }
}

package com.techncat.quantum.app.common.repo;

import com.techncat.quantum.app.common.voutils.VOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RepoUtils {

    @Autowired
    private VOUtils voUtils;

    // for all
    public <T> T create(JpaRepository repository, Object data, Class<T> modelClass, Process process) throws VOUtils.BeanCopyException {
        Object model = voUtils.copy(data, modelClass);
        if (process != null) {
            model = process.process(model);
        }
        return (T) repository.save(model);
    }

    public interface Process {
        // 中间处理策略
        Object process(Object model);
    }
}

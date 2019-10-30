package com.techncat.quantum.app.common.repo;

import com.techncat.quantum.app.common.voutils.VOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RepoUtils {

    @Autowired
    private VOUtils voUtils;

    public <T> T create(JpaRepository repository, Object data, Class<T> modelClass, ProcessMid processMid) throws VOUtils.BeanCopyException {
        Object model = voUtils.copy(data, modelClass);
        if (processMid != null) {
            model = processMid.process(model);
        }
        return (T) repository.save(model);
    }
    // for all
    public <T, P> P create(Object baseData, Object extraData, Class<T> modelClassMid, ProcessMid<T> processMid, Class<P> modelClassPost, ProcessPost<T, P> processPost) throws VOUtils.BeanCopyException {
        T modelMid = voUtils.copy(extraData, modelClassMid);
        P modelPost = voUtils.copy(extraData, modelClassPost);
        if (processMid != null) {
            modelMid = processMid.process(modelMid);
        }
        if (processPost != null) {
            return processPost.process(modelMid, modelPost);
        }
        return null;
    }

    public interface ProcessMid<T> {
        // 中间处理策略
        T process(T preData1);
    }
    public interface ProcessPost<T, P> {
        // 中间处理策略
        P process(T postData1, P preData2);
    }
}

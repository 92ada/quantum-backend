package com.techncat.quantum.app.service.people.lab;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.people.Lab;
import com.techncat.quantum.app.repository.people.LabRepository;
import com.techncat.quantum.app.vos.people.LabVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class LabService {
    @Resource
    private LabRepository repository;

    @Autowired
    private VOUtils voUtils;

    public Lab fetch(Long id) {
        Lab fund = repository.findFirstById(id);
        if (fund == null) throw new LabNotFoundException(id);
        return fund;
    }

    public Lab create(LabVO vo) {
        Lab data = voUtils.copy(vo, Lab.class);
        data.setId(null);
        data.setCreatedAt(new Date());
        data.setUpdateAt(new Date());
        return repository.save(data);
    }

    public Lab update(Long id, LabVO vo) {
        Lab data = voUtils.copy(vo, Lab.class);
        data.setId(id);
        data.setUpdateAt(new Date());
        return repository.save(data);
    }

    public void delete(Long id) {
        Lab fund = fetch(id);
        repository.delete(fund);
    }

    public static class LabNotFoundException extends RuntimeException {
        LabNotFoundException(Long id) {
            super("Lab not found, id=[" + id + "]");
        }
    }
}

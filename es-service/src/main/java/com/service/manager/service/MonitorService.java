package com.service.manager.service;

import com.service.manager.bo.MonitorBaseBo;
import com.service.manager.repository.MonitorBaseEsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorService<B extends MonitorBaseBo> {

    private MonitorBaseEsRepository monitorBaseEsRepository;

    @Autowired
    public void setMonitorBaseEsRepository(MonitorBaseEsRepository monitorBaseEsRepository) {
        this.monitorBaseEsRepository = monitorBaseEsRepository;
    }

    public Object save(B bo)  {
         return monitorBaseEsRepository.save(bo);
    }

    public void delete(B bo) {
        monitorBaseEsRepository.delete(bo);
    }
}
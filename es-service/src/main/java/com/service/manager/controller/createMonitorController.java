package com.service.manager.controller;

import com.service.manager.bo.InstanceMonitorBo;
import com.service.manager.repository.InstanceMonitorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Druid on 2018/3/25.
 *
 */
@RestController
public class createMonitorController {

    private static Logger logger = LoggerFactory.getLogger(createMonitorController.class);

    private InstanceMonitorRepository instanceMonitorRepository;

    @Autowired
    public void setMonitorBaseEsRepository(InstanceMonitorRepository instanceMonitorRepository) {
        this.instanceMonitorRepository = instanceMonitorRepository;
    }

    @RequestMapping(value = "monitor", method = RequestMethod.POST)
    @ResponseBody
    public String createMonitor(@RequestBody Object monitorVo) {

        logger.info("Create monitorvo: ", monitorVo.toString());

        InstanceMonitorBo instanceMonitorBo = (InstanceMonitorBo)instanceMonitorRepository.save(
                new InstanceMonitorBo("123456", 10f, 20f, new Date()));

        logger.info(instanceMonitorBo.toString());

        return "ok";
    }
}

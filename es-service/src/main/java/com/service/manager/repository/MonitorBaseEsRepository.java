package com.service.manager.repository;

import com.service.manager.bo.InstanceMonitorBo;
import com.service.manager.bo.MonitorBaseBo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * Created by Druid on 2018/3/25.
 *
 */
@NoRepositoryBean
public interface MonitorBaseEsRepository<B extends MonitorBaseBo> extends ElasticsearchRepository<B, String> {
    List<InstanceMonitorBo> findByMonitorTime(Long monitorTime, Pageable pageable);
}

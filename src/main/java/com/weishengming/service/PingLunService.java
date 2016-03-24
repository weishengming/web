package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.PingLunDO;
import com.weishengming.dao.mapper.PingLunMapper;
import com.weishengming.dao.param.PingLunParam;
import com.weishengming.dao.query.PingLunQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class PingLunService {

    @Resource
    private PingLunMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<PingLunDO> findPage(PingLunQuery query) {
        validationService.validate(query);
        PingLunParam param = new PingLunParam();
        BeanUtils.copyProperties(query, param);
        List<PingLunDO> list = mapper.findList(param);

        return new ResultPage<PingLunDO>(list, query);
    }

    public List<PingLunDO> findAll() {
        return mapper.findAll();
    }

    public PingLunDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(PingLunDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(PingLunDO entity) {
        validationService.validate(entity);
        PingLunDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(PingLunDO source,PingLunDO target){
    	//TODO 
    }
}

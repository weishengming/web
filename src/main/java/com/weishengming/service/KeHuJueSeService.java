package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.KeHuJueSeDO;
import com.weishengming.dao.mapper.KeHuJueSeMapper;
import com.weishengming.dao.param.KeHuJueSeParam;
import com.weishengming.dao.query.KeHuJueSeQuery;
import com.weishengming.service.query.ResultPage;

@Service
public class KeHuJueSeService {

    @Resource
    private KeHuJueSeMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<KeHuJueSeDO> findPage(KeHuJueSeQuery query) {
        validationService.validate(query);
        KeHuJueSeParam param = new KeHuJueSeParam();
        BeanUtils.copyProperties(query, param);
        List<KeHuJueSeDO> list = mapper.findList(param);

        return new ResultPage<KeHuJueSeDO>(list, query);
    }

    public List<KeHuJueSeDO> findAll() {
        return mapper.findAll();
    }

    public KeHuJueSeDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(KeHuJueSeDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(KeHuJueSeDO entity) {
        validationService.validate(entity);
        KeHuJueSeDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(KeHuJueSeDO source,KeHuJueSeDO target){
    	//TODO 
    }
}

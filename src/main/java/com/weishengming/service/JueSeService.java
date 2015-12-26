package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.JueSeDO;
import com.weishengming.dao.mapper.JueSeMapper;
import com.weishengming.dao.param.JueSeParam;
import com.weishengming.dao.query.JueSeQuery;
import com.weishengming.service.query.ResultPage;

@Service
public class JueSeService {

    @Resource
    private JueSeMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<JueSeDO> findPage(JueSeQuery query) {
        validationService.validate(query);
        JueSeParam param = new JueSeParam();
        BeanUtils.copyProperties(query, param);
        List<JueSeDO> list = mapper.findList(param);

        return new ResultPage<JueSeDO>(list, query);
    }

    public List<JueSeDO> findAll() {
        return mapper.findAll();
    }

    public JueSeDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(JueSeDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(JueSeDO entity) {
        validationService.validate(entity);
        JueSeDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(JueSeDO source,JueSeDO target){
    	//TODO 
    }
}

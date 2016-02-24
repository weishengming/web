package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.JTDXZMDO;
import com.weishengming.dao.mapper.JTDXZMMapper;
import com.weishengming.dao.param.JTDXZMParam;
import com.weishengming.dao.query.JTDXZMQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class JTDXZMService {

    @Resource
    private JTDXZMMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<JTDXZMDO> findPage(JTDXZMQuery query) {
        validationService.validate(query);
        JTDXZMParam param = new JTDXZMParam();
        BeanUtils.copyProperties(query, param);
        List<JTDXZMDO> list = mapper.findList(param);

        return new ResultPage<JTDXZMDO>(list, query);
    }

    public List<JTDXZMDO> findAll() {
        return mapper.findAll();
    }

    public JTDXZMDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(JTDXZMDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(JTDXZMDO entity) {
        validationService.validate(entity);
        JTDXZMDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(JTDXZMDO source,JTDXZMDO target){
    	//TODO 
    }
}

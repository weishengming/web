package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.QQDO;
import com.weishengming.dao.mapper.QQMapper;
import com.weishengming.dao.param.QQParam;
import com.weishengming.dao.query.QQQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class QQService {

    @Resource
    private QQMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<QQDO> findPage(QQQuery query) {
        validationService.validate(query);
        QQParam param = new QQParam();
        BeanUtils.copyProperties(query, param);
        List<QQDO> list = mapper.findList(param);

        return new ResultPage<QQDO>(list, query);
    }

    public List<QQDO> findAll() {
        return mapper.findAll();
    }

    public QQDO findOne(Long id) {
        return mapper.findOne(id);
    }
    public QQDO findOpenID(String openID){
    	return mapper.findOpenID(openID);
    }

    public void create(QQDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(QQDO entity) {
        validationService.validate(entity);
        QQDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(QQDO source,QQDO target){
    	//TODO 
    }
}

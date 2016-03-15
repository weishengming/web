package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.QMZXDO;
import com.weishengming.dao.entity.SJZLDO;
import com.weishengming.dao.mapper.SJZLMapper;
import com.weishengming.dao.param.SJZLParam;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.SJZLQuery;

@Service
public class SJZLService {

    @Resource
    private SJZLMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<SJZLDO> findPage(SJZLQuery query) {
        validationService.validate(query);
        SJZLParam param = new SJZLParam();
        BeanUtils.copyProperties(query, param);
        List<SJZLDO> list = mapper.findList(param);

        return new ResultPage<SJZLDO>(list, query);
    }

    public List<SJZLDO> findAll() {
        return mapper.findAll();
    }

    public SJZLDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(SJZLDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(SJZLDO entity) {
        validationService.validate(entity);
        SJZLDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }
    public List<SJZLDO> findListByFubiaoti(String fubiaoti){
    	return mapper.findListByFubiaoti(fubiaoti);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(SJZLDO source,SJZLDO target){
    	//TODO 
    }
}

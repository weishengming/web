package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.QuanXianDO;
import com.weishengming.dao.mapper.QuanXianMapper;
import com.weishengming.dao.param.QuanXianParam;
import com.weishengming.dao.query.QuanXianQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class QuanXianService {

    @Resource
    private QuanXianMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<QuanXianDO> findPage(QuanXianQuery query) {
        validationService.validate(query);
        QuanXianParam param = new QuanXianParam();
        BeanUtils.copyProperties(query, param);
        List<QuanXianDO> list = mapper.findList(param);

        return new ResultPage<QuanXianDO>(list, query);
    }

    public List<QuanXianDO> findAll() {
        return mapper.findAll();
    }

    public QuanXianDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(QuanXianDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(QuanXianDO entity) {
        validationService.validate(entity);
        QuanXianDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(QuanXianDO source,QuanXianDO target){
    	//TODO 
    }
}

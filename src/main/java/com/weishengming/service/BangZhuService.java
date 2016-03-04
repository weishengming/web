package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.BangZhuDO;
import com.weishengming.dao.mapper.BangZhuMapper;
import com.weishengming.dao.param.BangZhuParam;
import com.weishengming.dao.query.BangZhuQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class BangZhuService {

    @Resource
    private BangZhuMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<BangZhuDO> findPage(BangZhuQuery query) {
        validationService.validate(query);
        BangZhuParam param = new BangZhuParam();
        BeanUtils.copyProperties(query, param);
        List<BangZhuDO> list = mapper.findList(param);

        return new ResultPage<BangZhuDO>(list, query);
    }

    public List<BangZhuDO> findAll() {
        return mapper.findAll();
    }

    public BangZhuDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(BangZhuDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(BangZhuDO entity) {
        validationService.validate(entity);
        BangZhuDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(BangZhuDO source,BangZhuDO target){
    	//TODO 
    }
}

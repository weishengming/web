package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.GeiDO;
import com.weishengming.dao.mapper.GeiMapper;
import com.weishengming.dao.param.GeiParam;
import com.weishengming.dao.query.GeiQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class GeiService {

    @Resource
    private GeiMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<GeiDO> findPage(GeiQuery query) {
        validationService.validate(query);
        GeiParam param = new GeiParam();
        BeanUtils.copyProperties(query, param);
        List<GeiDO> list = mapper.findList(param);

        return new ResultPage<GeiDO>(list, query);
    }

    public List<GeiDO> findAll() {
        return mapper.findAll();
    }

    public GeiDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(GeiDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(GeiDO entity) {
        validationService.validate(entity);
        GeiDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(GeiDO source,GeiDO target){
    	//TODO 
    }
}

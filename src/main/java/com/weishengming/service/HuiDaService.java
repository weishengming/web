package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.HuiDaDO;
import com.weishengming.dao.mapper.HuiDaMapper;
import com.weishengming.dao.param.HuiDaParam;
import com.weishengming.dao.query.HuiDaQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class HuiDaService {

    @Resource
    private HuiDaMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<HuiDaDO> findPage(HuiDaQuery query) {
        validationService.validate(query);
        HuiDaParam param = new HuiDaParam();
        BeanUtils.copyProperties(query, param);
        List<HuiDaDO> list = mapper.findList(param);

        return new ResultPage<HuiDaDO>(list, query);
    }

    public List<HuiDaDO> findAll() {
        return mapper.findAll();
    }

    public HuiDaDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(HuiDaDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(HuiDaDO entity) {
        validationService.validate(entity);
        HuiDaDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(HuiDaDO source,HuiDaDO target){
    	//TODO 
    }
}

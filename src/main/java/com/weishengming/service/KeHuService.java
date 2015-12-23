package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.dao.entity.KeHuDO;
import com.weishengming.dao.mapper.KeHuMapper;
import com.weishengming.dao.param.KeHuParam;
import com.weishengming.dao.query.KeHuQuery;
import com.weishengming.service.query.ResultPage;

@Service
public class KeHuService {

    @Resource
    private KeHuMapper mapper;
//    @Resource
//    private ValidationService validationService;

    public ResultPage<KeHuDO> findPage(KeHuQuery query) {
//        validationService.validate(query);
        KeHuParam param = new KeHuParam();
        BeanUtils.copyProperties(query, param);
        List<KeHuDO> list = mapper.findList(param);

        return new ResultPage<KeHuDO>(list, query);
    }

    public List<KeHuDO> findAll() {
        return mapper.findAll();
    }

    public KeHuDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(KeHuDO entity) {
//        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(KeHuDO entity) {
//        validationService.validate(entity);
        KeHuDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(KeHuDO source,KeHuDO target){
    	//TODO 
    }
}

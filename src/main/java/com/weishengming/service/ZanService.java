package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.ZanDO;
import com.weishengming.dao.mapper.ZanMapper;
import com.weishengming.dao.param.ZanParam;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.ZanQuery;

@Service
public class ZanService {

    @Resource
    private ZanMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<ZanDO> findPage(ZanQuery query) {
        validationService.validate(query);
        ZanParam param = new ZanParam();
        BeanUtils.copyProperties(query, param);
        List<ZanDO> list = mapper.findList(param);

        return new ResultPage<ZanDO>(list, query);
    }

    public List<ZanDO> findAll() {
        return mapper.findAll();
    }

    public ZanDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(ZanDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(ZanDO entity) {
        validationService.validate(entity);
        ZanDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(ZanDO source,ZanDO target){
    	//TODO 
    }
}

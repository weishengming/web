package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.ShouCangDO;
import com.weishengming.dao.mapper.ShouCangMapper;
import com.weishengming.dao.param.ShouCangParam;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.ShouCangQuery;

@Service
public class ShouCangService {

    @Resource
    private ShouCangMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<ShouCangDO> findPage(ShouCangQuery query) {
        validationService.validate(query);
        ShouCangParam param = new ShouCangParam();
        BeanUtils.copyProperties(query, param);
        List<ShouCangDO> list = mapper.findList(param);

        return new ResultPage<ShouCangDO>(list, query);
    }

    public List<ShouCangDO> findAll() {
        return mapper.findAll();
    }

    public ShouCangDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(ShouCangDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(ShouCangDO entity) {
        validationService.validate(entity);
        ShouCangDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(ShouCangDO source,ShouCangDO target){
    	//TODO 
    }
}

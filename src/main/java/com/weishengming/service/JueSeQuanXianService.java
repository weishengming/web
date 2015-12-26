package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.commom.validate.ValidationService;
import com.weishengming.dao.entity.JueSeQuanXianDO;
import com.weishengming.dao.mapper.JueSeQuanXianMapper;
import com.weishengming.dao.param.JueSeQuanXianParam;
import com.weishengming.dao.query.JueSeQuanXianQuery;
import com.weishengming.service.query.ResultPage;

@Service
public class JueSeQuanXianService {

    @Resource
    private JueSeQuanXianMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<JueSeQuanXianDO> findPage(JueSeQuanXianQuery query) {
        validationService.validate(query);
        JueSeQuanXianParam param = new JueSeQuanXianParam();
        BeanUtils.copyProperties(query, param);
        List<JueSeQuanXianDO> list = mapper.findList(param);

        return new ResultPage<JueSeQuanXianDO>(list, query);
    }

    public List<JueSeQuanXianDO> findAll() {
        return mapper.findAll();
    }

    public JueSeQuanXianDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(JueSeQuanXianDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(JueSeQuanXianDO entity) {
        validationService.validate(entity);
        JueSeQuanXianDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(JueSeQuanXianDO source,JueSeQuanXianDO target){
    	//TODO 
    }
}

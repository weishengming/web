package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.DiXiongZiMeiDO;
import com.weishengming.dao.mapper.DiXiongZiMeiMapper;
import com.weishengming.dao.param.DiXiongZiMeiParam;
import com.weishengming.dao.query.DiXiongZiMeiQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class DiXiongZiMeiService {

    @Resource
    private DiXiongZiMeiMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<DiXiongZiMeiDO> findPage(DiXiongZiMeiQuery query) {
        validationService.validate(query);
        DiXiongZiMeiParam param = new DiXiongZiMeiParam();
        BeanUtils.copyProperties(query, param);
        List<DiXiongZiMeiDO> list = mapper.findList(param);

        return new ResultPage<DiXiongZiMeiDO>(list, query);
    }

    public List<DiXiongZiMeiDO> findAll() {
        return mapper.findAll();
    }

    public DiXiongZiMeiDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(DiXiongZiMeiDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(DiXiongZiMeiDO entity) {
        validationService.validate(entity);
        DiXiongZiMeiDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(DiXiongZiMeiDO source,DiXiongZiMeiDO target){
    	//TODO 
    }
}

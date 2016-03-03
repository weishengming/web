package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.JiaoHuiDiZhiDO;
import com.weishengming.dao.mapper.JiaoHuiDiZhiMapper;
import com.weishengming.dao.param.JiaoHuiDiZhiParam;
import com.weishengming.dao.query.JiaoHuiDiZhiQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class JiaoHuiDiZhiService {

    @Resource
    private JiaoHuiDiZhiMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<JiaoHuiDiZhiDO> findPage(JiaoHuiDiZhiQuery query) {
        validationService.validate(query);
        JiaoHuiDiZhiParam param = new JiaoHuiDiZhiParam();
        BeanUtils.copyProperties(query, param);
        List<JiaoHuiDiZhiDO> list = mapper.findList(param);

        return new ResultPage<JiaoHuiDiZhiDO>(list, query);
    }

    public List<JiaoHuiDiZhiDO> findAll() {
        return mapper.findAll();
    }

    public JiaoHuiDiZhiDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(JiaoHuiDiZhiDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(JiaoHuiDiZhiDO entity) {
        validationService.validate(entity);
        JiaoHuiDiZhiDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(JiaoHuiDiZhiDO source,JiaoHuiDiZhiDO target){
    	//TODO 
    }
}

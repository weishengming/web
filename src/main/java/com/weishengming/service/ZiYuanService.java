package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.ZiYuanDO;
import com.weishengming.dao.mapper.ZiYuanMapper;
import com.weishengming.dao.param.ZiYuanParam;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.ZiYuanQuery;

@Service
public class ZiYuanService {

    @Resource
    private ZiYuanMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<ZiYuanDO> findPage(ZiYuanQuery query) {
        validationService.validate(query);
        ZiYuanParam param = new ZiYuanParam();
        BeanUtils.copyProperties(query, param);
        List<ZiYuanDO> list = mapper.findList(param);

        return new ResultPage<ZiYuanDO>(list, query);
    }

    public List<ZiYuanDO> findAll() {
        return mapper.findAll();
    }

    public ZiYuanDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(ZiYuanDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(ZiYuanDO entity) {
        validationService.validate(entity);
        ZiYuanDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(ZiYuanDO source,ZiYuanDO target){
    	target.setBeizhu(source.getBeizhu());
    	target.setDizhi(source.getDizhi());
    	target.setType(source.getType());
    }
}

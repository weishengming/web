package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.util.DateUtil;
import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.WenTiDO;
import com.weishengming.dao.mapper.WenTiMapper;
import com.weishengming.dao.param.WenTiParam;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.WenTiQuery;

@Service
public class WenTiService {

    @Resource
    private WenTiMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<WenTiDO> findPage(WenTiQuery query) {
        validationService.validate(query);
        WenTiParam param = new WenTiParam();
        BeanUtils.copyProperties(query, param);
        List<WenTiDO> list = mapper.findList(param);

        return new ResultPage<WenTiDO>(list, query);
    }

    public List<WenTiDO> findAll() {
        return mapper.findAll();
    }

    public WenTiDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(WenTiDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(WenTiDO entity) {
        validationService.validate(entity);
        WenTiDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }
    
    public List<WenTiDO> findListByKehuZhangHao(String kehuZhanghao){
    	return mapper.findListByKehuZhangHao(kehuZhanghao);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(WenTiDO source,WenTiDO target){
    	target.setUpdateDate(DateUtil.getCurrentDate());
    	target.setWenti(source.getWenti());
    }
}

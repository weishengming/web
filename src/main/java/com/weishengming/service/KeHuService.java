package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.weishengming.dao.entity.KeHuDO;
import com.weishengming.dao.mapper.KeHuMapper;
import com.weishengming.dao.param.KeHuParam;
import com.weishengming.dao.query.KeHuQuery;
import com.weishengming.service.query.ResultPage;
import com.weishengming.service.validate.ValidationService;
import com.weishengming.web.controller.IndexController;

@Service
public class KeHuService {
	Logger  logger = LoggerFactory.getLogger(KeHuService.class);

    @Resource
    private KeHuMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<KeHuDO> findPage(KeHuQuery query) {
        validationService.validate(query);
        KeHuParam param = new KeHuParam();
        BeanUtils.copyProperties(query, param);
        List<KeHuDO> list = mapper.findList(param);
        return new ResultPage<KeHuDO>(list, query);
    }
    
    public boolean checkZhanghaoUnique(Long id, String zhanghao) {
        if (id != null && !StringUtils.isEmpty(zhanghao)) {
        	KeHuDO kehu = mapper.findOne(id);
            if (!zhanghao.equals(kehu.getZhanghao())) {
                return false;
            } else {
                return true;
            }
        } else {
            return checkZhanghaoUnique(zhanghao);
        }
    }
    public KeHuDO findKeHuByZhangHao(String zhanghao){
    	if (!StringUtils.isEmpty(zhanghao)) {
            KeHuParam param = new KeHuParam();
            param.setZhanghao(zhanghao);
            List<KeHuDO> list = mapper.findList(param);
            if (null == list || list.size() == 0) {
            	logger.info("找不到信息");
            	return null;
            }else{
            	return list.get(0);
            }
        }
    	return null;
    }
    
    public boolean checkZhanghaoUnique(String zhanghao) {
        boolean zhanghaoUnique = false;
        if (!StringUtils.isEmpty(zhanghao)) {
            KeHuParam param = new KeHuParam();
            param.setZhanghao(zhanghao);
            List<KeHuDO> list = mapper.findList(param);
            if (null == list || list.size() == 0) {
            	zhanghaoUnique = true;
            }
        }
        return zhanghaoUnique;
    }

    public List<KeHuDO> findAll() {
        return mapper.findAll();
    }

    public KeHuDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(KeHuDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(KeHuDO entity) {
        validationService.validate(entity);
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

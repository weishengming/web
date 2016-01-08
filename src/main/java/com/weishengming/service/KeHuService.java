package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.util.DateUtil;
import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.KeHuDO;
import com.weishengming.dao.mapper.KeHuMapper;
import com.weishengming.dao.param.KeHuParam;
import com.weishengming.dao.query.KeHuQuery;
import com.weishengming.dao.query.ResultPage;

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
        ResultPage<KeHuDO> result=new ResultPage<KeHuDO>(list, query);
        Long count = this.countList(query);
        int total = count.intValue();
        int totalPage = total / result.getPageSize();
        if (totalPage != 0 && total % result.getPageSize() != 0) {
            totalPage += 1;
        }
        result.setCount(count); //设置总条数
        result.setTotal(totalPage); //谁知总页数
        
        return result;
    }
    
    
    public KeHuDO findOneByOpenID(String openID){
    	return mapper.findOneByOpenID(openID);
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
    	target.setUpdateDate(DateUtil.getCurrentDate());
    	target.setXingming(source.getXingming());//姓名
    	target.setShoujihao(source.getShoujihao());//手机号
    	target.setQq(source.getQq());  //QQ号
    	target.setWeixinhao(source.getWeixinhao()); //微信号
    }
    public Long countList(KeHuQuery query){
   	    KeHuParam partyParam = new KeHuParam();
        BeanUtils.copyProperties(query, partyParam);
        return mapper.countList(partyParam);
   	
   }
}

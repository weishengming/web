package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.util.DateUtil;
import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.QMZXDO;
import com.weishengming.dao.entity.ShiPinDO;
import com.weishengming.dao.mapper.ShiPinMapper;
import com.weishengming.dao.param.QMZXParam;
import com.weishengming.dao.param.ShiPinParam;
import com.weishengming.dao.query.QMZXQuery;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.ShiPinQuery;

@Service
public class ShiPinService {

    @Resource
    private ShiPinMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<ShiPinDO> findPage(ShiPinQuery query) {
        validationService.validate(query);
        ShiPinParam param = new ShiPinParam();
        BeanUtils.copyProperties(query, param);
        List<ShiPinDO> list = mapper.findList(param);
        
        ResultPage<ShiPinDO> result=new ResultPage<ShiPinDO>(list, query);
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

    public List<ShiPinDO> findAll() {
        return mapper.findAll();
    }

    public ShiPinDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(ShiPinDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(ShiPinDO entity) {
        validationService.validate(entity);
        ShiPinDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    public List<ShiPinDO> findListByFubiaoti(String fubiaoti){
    	return mapper.findListByFubiaoti(fubiaoti);
    }
    
    public Long countList(ShiPinQuery query){
       ShiPinParam partyParam = new ShiPinParam();
       BeanUtils.copyProperties(query, partyParam);
       return mapper.countList(partyParam);
    }
    
    private void mergeEntity(ShiPinDO source,ShiPinDO target){
    	target.setUpdateDate(DateUtil.getCurrentDate());
    	target.setDijige(source.getDijige());
    	target.setFubiaoti(source.getFubiaoti());
    	target.setBiaoti(source.getBiaoti());
    	target.setTudousrc(source.getTudousrc());
    	target.setMiaoshu(source.getMiaoshu());
    }
}

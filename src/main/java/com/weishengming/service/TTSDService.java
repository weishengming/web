package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.util.DateUtil;
import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.TTSDDO;
import com.weishengming.dao.mapper.TTSDMapper;
import com.weishengming.dao.param.TTSDParam;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.TTSDQuery;

@Service
public class TTSDService {

    @Resource
    private TTSDMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<TTSDDO> findPage(TTSDQuery query) {
        validationService.validate(query);
        TTSDParam param = new TTSDParam();
        BeanUtils.copyProperties(query, param);
        List<TTSDDO> list = mapper.findList(param);
        
        ResultPage<TTSDDO> result=new ResultPage<TTSDDO>(list, query);
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
    
    public List<TTSDDO> findListByFubiaoti(String fubiaoti){
    	return mapper.findListByFubiaoti(fubiaoti);
    }
    
    public Long countList(TTSDQuery query){
	   TTSDParam partyParam = new TTSDParam();
       BeanUtils.copyProperties(query, partyParam);
       return mapper.countList(partyParam);
      	
    }

    public List<TTSDDO> findAll() {
        return mapper.findAll();
    }

    public TTSDDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(TTSDDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(TTSDDO entity) {
        validationService.validate(entity);
        TTSDDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(TTSDDO source,TTSDDO target){
    	target.setUpdateDate(DateUtil.getCurrentDate());
    	target.setDijige(source.getDijige());
    	target.setFubiaoti(source.getFubiaoti());
    	target.setBiaoti(source.getBiaoti());
    	target.setMaoji(source.getMaoji());
    	target.setNeirong(source.getNeirong());
    }
}

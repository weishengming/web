package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.util.DateUtil;
import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.QMZXDO;
import com.weishengming.dao.entity.SJZLDO;
import com.weishengming.dao.mapper.SJZLMapper;
import com.weishengming.dao.param.QMZXParam;
import com.weishengming.dao.param.SJZLParam;
import com.weishengming.dao.query.QMZXQuery;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.SJZLQuery;

@Service
public class SJZLService {

    @Resource
    private SJZLMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<SJZLDO> findPage(SJZLQuery query) {
        validationService.validate(query);
        SJZLParam param = new SJZLParam();
        BeanUtils.copyProperties(query, param);
        List<SJZLDO> list = mapper.findList(param);
        ResultPage<SJZLDO> result=new ResultPage<SJZLDO>(list, query);
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
    public Long countList(SJZLQuery query){
    	SJZLParam param = new SJZLParam();
        BeanUtils.copyProperties(query, param);
        return mapper.countList(param);
       	
     }
    public List<SJZLDO> findAll() {
        return mapper.findAll();
    }

    public SJZLDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(SJZLDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(SJZLDO entity) {
        validationService.validate(entity);
        SJZLDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }
    public List<SJZLDO> findListByFubiaoti(String fubiaoti){
    	return mapper.findListByFubiaoti(fubiaoti);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(SJZLDO source,SJZLDO target){
    	target.setUpdateDate(DateUtil.getCurrentDate());
    	target.setDijige(source.getDijige());
    	target.setFubiaoti(source.getFubiaoti());
    	target.setBiaoti(source.getBiaoti());
    	target.setTudousrc(source.getTudousrc());
    	target.setMiaoshu(source.getMiaoshu());
    }
}

package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.util.DateUtil;
import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.QMZXDO;
import com.weishengming.dao.mapper.QMZXMapper;
import com.weishengming.dao.param.QMZXParam;
import com.weishengming.dao.query.QMZXQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class QMZXService {

    @Resource
    private QMZXMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<QMZXDO> findPage(QMZXQuery query) {
        validationService.validate(query);
        QMZXParam param = new QMZXParam();
        BeanUtils.copyProperties(query, param);
        List<QMZXDO> list = mapper.findList(param);
        
        ResultPage<QMZXDO> result=new ResultPage<QMZXDO>(list, query);
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

    public List<QMZXDO> findAll() {
        return mapper.findAll();
    }

    public QMZXDO findOne(Long id) {
        return mapper.findOne(id);
    }
    
    public List<QMZXDO> findListByFubiaoti(String fubiaoti){
    	return mapper.findListByFubiaoti(fubiaoti);
    }

    public void create(QMZXDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(QMZXDO entity) {
        validationService.validate(entity);
        QMZXDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    public Long countList(QMZXQuery query){
       QMZXParam param = new QMZXParam();
       BeanUtils.copyProperties(query, param);
       return mapper.countList(param);
      	
    }
    
    private void mergeEntity(QMZXDO source,QMZXDO target){
    	target.setUpdateDate(DateUtil.getCurrentDate());
    	target.setDijige(source.getDijige());
    	target.setFubiaoti(source.getFubiaoti());
    	target.setBiaoti(source.getBiaoti());
    	target.setTudousrc(source.getTudousrc());
    	target.setMiaoshu(source.getMiaoshu());
    }
}

package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.QiuDO;
import com.weishengming.dao.mapper.QiuMapper;
import com.weishengming.dao.param.QiuParam;
import com.weishengming.dao.query.QiuQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class QiuService {

    @Resource
    private QiuMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<QiuDO> findPage(QiuQuery query) {
        validationService.validate(query);
        QiuParam param = new QiuParam();
        BeanUtils.copyProperties(query, param);
        List<QiuDO> list = mapper.findList(param);
        
        ResultPage<QiuDO> result=new ResultPage<QiuDO>(list, query);
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
    
    public Long countList(QiuQuery query){
    	QiuParam param = new QiuParam();
        BeanUtils.copyProperties(query, param);
        return mapper.countList(param);
    }

    public List<QiuDO> findAll() {
        return mapper.findAll();
    }

    public QiuDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(QiuDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(QiuDO entity) {
        validationService.validate(entity);
        QiuDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(QiuDO source,QiuDO target){
    	//TODO 
    }
}

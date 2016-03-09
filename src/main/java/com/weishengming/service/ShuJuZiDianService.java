package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.ShuJuZiDianDO;
import com.weishengming.dao.mapper.ShuJuZiDianMapper;
import com.weishengming.dao.param.ShuJuZiDianParam;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.ShuJuZiDianQuery;

@Service
public class ShuJuZiDianService {

    @Resource
    private ShuJuZiDianMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<ShuJuZiDianDO> findPage(ShuJuZiDianQuery query) {
        validationService.validate(query);
        ShuJuZiDianParam param = new ShuJuZiDianParam();
        BeanUtils.copyProperties(query, param);
        List<ShuJuZiDianDO> list = mapper.findList(param);
        ResultPage<ShuJuZiDianDO> result=new ResultPage<ShuJuZiDianDO>(list, query);
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
    
    public Long countList(ShuJuZiDianQuery query){
    	ShuJuZiDianParam param = new ShuJuZiDianParam();
        BeanUtils.copyProperties(query, param);
        return mapper.countList(param);
     }

    public List<ShuJuZiDianDO> findAll() {
        return mapper.findAll();
    }
    
    public List<ShuJuZiDianDO> findListByFuId(Long id){
    	return mapper.findListByFuId(id);
    }

    public ShuJuZiDianDO findOne(Long id) {
        return mapper.findOne(id);
    }
    

    public void create(ShuJuZiDianDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(ShuJuZiDianDO entity) {
        validationService.validate(entity);
        ShuJuZiDianDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(ShuJuZiDianDO source,ShuJuZiDianDO target){
    	target.setNeirong(source.getNeirong());
    	target.setPaixu(source.getPaixu());
    }
}

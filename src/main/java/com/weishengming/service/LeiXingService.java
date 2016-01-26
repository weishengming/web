package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.JiaoTangDO;
import com.weishengming.dao.entity.LeiXingDO;
import com.weishengming.dao.mapper.LeiXingMapper;
import com.weishengming.dao.param.JiaoTangParam;
import com.weishengming.dao.param.LeiXingParam;
import com.weishengming.dao.query.JiaoTangQuery;
import com.weishengming.dao.query.LeiXingQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class LeiXingService {

    @Resource
    private LeiXingMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<LeiXingDO> findPage(LeiXingQuery query) {
        validationService.validate(query);
        LeiXingParam param = new LeiXingParam();
        BeanUtils.copyProperties(query, param);
        List<LeiXingDO> list = mapper.findList(param);
        
        ResultPage<LeiXingDO> result=new ResultPage<LeiXingDO>(list, query);
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

    public List<LeiXingDO> findAll() {
        return mapper.findAll();
    }

    public LeiXingDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(LeiXingDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(LeiXingDO entity) {
        validationService.validate(entity);
        LeiXingDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }
    public Long countList(LeiXingQuery query){
    	LeiXingParam param = new LeiXingParam();
        BeanUtils.copyProperties(query, param);
        return mapper.countList(param);
     }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(LeiXingDO source,LeiXingDO target){
    	 target.setFuid(source.getFuid());
    	 target.setFumingcheng(source.getFumingcheng());
    	 target.setJibie(source.getJibie());
    	 target.setMingcheng(source.getMingcheng());
    	 target.setShifouqiyong(source.getShifouqiyong());
    	 target.setPaixu(source.getPaixu());
    	 
    }
}

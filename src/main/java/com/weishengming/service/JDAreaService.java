package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.JDAreaDO;
import com.weishengming.dao.mapper.JDAreaMapper;
import com.weishengming.dao.param.JDAreaParam;
import com.weishengming.dao.query.AreaQuery;
import com.weishengming.dao.query.JDAreaQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class JDAreaService {

    @Resource
    private JDAreaMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<JDAreaDO> findPage(JDAreaQuery query) {
        validationService.validate(query);
        JDAreaParam param = new JDAreaParam();
        BeanUtils.copyProperties(query, param);
        List<JDAreaDO> list = mapper.findList(param);

        return new ResultPage<JDAreaDO>(list, query);
    }

    public List<JDAreaDO> findAll() {
        return mapper.findAll();
    }

    public JDAreaDO findOne(Long id) {
        return mapper.findOne(id);
    }
    public JDAreaDO findOneByAreaId(String areaId){
    	return mapper.findOneByAreaId(areaId);
    }

    public void create(JDAreaDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(JDAreaDO entity) {
        validationService.validate(entity);
        JDAreaDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(JDAreaDO source,JDAreaDO target){
    	//TODO 
    }
    
    
	public List<JDAreaDO> findByParentId(String parentId) {
		JDAreaQuery query = new JDAreaQuery();
		query.setParentId(parentId);
		query.setOrderOperator(AreaQuery.ORDER_TYPE_ASC);
		query.setPageNumber(1);
        query.setPageSize(Integer.MAX_VALUE);
        ResultPage<JDAreaDO> resultPage = findPage(query);
        List<JDAreaDO> result = resultPage.getResult();
		if(resultPage==null || result==null || result.size()==0){
        	return null;
        }
		return result;
	}
    
    
    
    
    
    
    
    
    
    
    
}

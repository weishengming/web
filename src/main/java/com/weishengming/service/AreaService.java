package com.weishengming.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.AreaDO;
import com.weishengming.dao.mapper.AreaMapper;
import com.weishengming.dao.param.AreaParam;
import com.weishengming.dao.query.AreaQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class AreaService {

    @Resource
    private AreaMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<AreaDO> findPage(AreaQuery query) {
        validationService.validate(query);
        AreaParam param = new AreaParam();
        BeanUtils.copyProperties(query, param);
        List<AreaDO> list = mapper.findList(param);

        return new ResultPage<AreaDO>(list, query);
    }

    public List<AreaDO> findAll() {
        return mapper.findAll();
    }

    public AreaDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(AreaDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(AreaDO entity) {
        validationService.validate(entity);
        AreaDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(AreaDO source,AreaDO target){
    	//TODO 
    }
    
	public List<AreaDO> findByParentId(Long parentId) {
		AreaQuery query = new AreaQuery();
		query.setParentId(parentId);
		query.setOrderOperator(AreaQuery.ORDER_TYPE_ASC);
		query.setPageNumber(1);
        query.setPageSize(Integer.MAX_VALUE);
        ResultPage<AreaDO> resultPage = findPage(query);
        List<AreaDO> result = resultPage.getResult();
		if(resultPage==null || result==null || result.size()==0){
        	return null;
        }
		return result;
	}

    public List<Long> findChildIdListByParentId(long parentId) {
        List<Long> idList = new ArrayList<Long>();
        List<AreaDO> list = this.findByParentId(parentId);
        for (AreaDO areaDO : list) {
            idList.add(areaDO.getId());
        }
        return idList;
    }
}

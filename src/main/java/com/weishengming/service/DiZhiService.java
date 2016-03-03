package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.util.DateUtil;
import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.DiZhiDO;
import com.weishengming.dao.mapper.DiZhiMapper;
import com.weishengming.dao.param.DiZhiParam;
import com.weishengming.dao.query.DiZhiQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class DiZhiService {

    @Resource
    private DiZhiMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<DiZhiDO> findPage(DiZhiQuery query) {
        validationService.validate(query);
        DiZhiParam param = new DiZhiParam();
        BeanUtils.copyProperties(query, param);
        List<DiZhiDO> list = mapper.findList(param);
        return new ResultPage<DiZhiDO>(list, query);
    }
    
   
    
    public List<DiZhiDO> findListByOpenID(String openID){
    	return mapper.findListByOpenID(openID);
    }
    public List<DiZhiDO> findListByDixiongzimeiid(Long dixiongzimeiid){
    	return mapper.findListByDixiongzimeiid(dixiongzimeiid);
    }
    

    public List<DiZhiDO> findAll() {
        return mapper.findAll();
    }

    public DiZhiDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(DiZhiDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(DiZhiDO entity) {
        validationService.validate(entity);
        DiZhiDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        oldEntity.setUpdateDate(DateUtil.getCurrentDate());
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(DiZhiDO source,DiZhiDO target){
    	target.setLeixing(source.getLeixing());
    	target.setAreaId(source.getAreaId());
    	target.setArea1Id(source.getArea1Id());
    	target.setArea2Id(source.getArea2Id());
    	target.setArea3Id(source.getArea3Id());
    	target.setAreaName(source.getAreaName());
    	target.setArea1Name(source.getArea1Name());
    	target.setArea2Name(source.getArea2Name());
    	target.setArea3Name(source.getArea3Name());
    	target.setXiangxidizhi(source.getXiangxidizhi());
    	target.setDixiongzimeiid(source.getDixiongzimeiid());
    	target.setDixiongzimeixingming(source.getDixiongzimeixingming());
    	target.setOpenID(source.getOpenID());
    	target.setNickname(source.getNickname());
    	
    }
}

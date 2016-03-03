package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.DiXiongZiMeiDO;
import com.weishengming.dao.entity.JiaoTangDO;
import com.weishengming.dao.entity.KeHuDO;
import com.weishengming.dao.mapper.DiXiongZiMeiMapper;
import com.weishengming.dao.param.DiXiongZiMeiParam;
import com.weishengming.dao.param.JiaoTangParam;
import com.weishengming.dao.query.DiXiongZiMeiQuery;
import com.weishengming.dao.query.JiaoTangQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class DiXiongZiMeiService {

    @Resource
    private DiXiongZiMeiMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<DiXiongZiMeiDO> findPage(DiXiongZiMeiQuery query) {
        validationService.validate(query);
        DiXiongZiMeiParam param = new DiXiongZiMeiParam();
        BeanUtils.copyProperties(query, param);
        List<DiXiongZiMeiDO> list = mapper.findList(param);

        ResultPage<DiXiongZiMeiDO> result=new ResultPage<DiXiongZiMeiDO>(list, query);
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

    public List<DiXiongZiMeiDO> findAll() {
        return mapper.findAll();
    }
    
    public DiXiongZiMeiDO findOneByOpenID(String openID){
    	return mapper.findOneByOpenID(openID);
    }

    public DiXiongZiMeiDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(DiXiongZiMeiDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(DiXiongZiMeiDO entity) {
        validationService.validate(entity);
        DiXiongZiMeiDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }
    
    public Long countList(DiXiongZiMeiQuery query){
    	DiXiongZiMeiParam param = new DiXiongZiMeiParam();
        BeanUtils.copyProperties(query, param);
        return mapper.countList(param);
     }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(DiXiongZiMeiDO source,DiXiongZiMeiDO target){
    	target.setOpenID(source.getOpenID());
    	target.setNickname(source.getNickname());
    	target.setXingbie(source.getXingbie());
    	target.setNianling(source.getNianling());
    	target.setXingming(source.getXingming());
    	target.setQq(source.getQq());
    	target.setWeixinhao(source.getWeixinhao());
    	target.setShenfen(source.getShenfen());
    	target.setQita(source.getQita());
    	target.setSuoding(source.getSuoding());
    }
}

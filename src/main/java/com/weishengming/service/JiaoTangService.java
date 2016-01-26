package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.JiaoTangDO;
import com.weishengming.dao.mapper.JiaoTangMapper;
import com.weishengming.dao.param.JiaoTangParam;
import com.weishengming.dao.query.JiaoTangQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class JiaoTangService {

    @Resource
    private JiaoTangMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<JiaoTangDO> findPage(JiaoTangQuery query) {
        validationService.validate(query);
        JiaoTangParam param = new JiaoTangParam();
        BeanUtils.copyProperties(query, param);
        List<JiaoTangDO> list = mapper.findList(param);

        ResultPage<JiaoTangDO> result=new ResultPage<JiaoTangDO>(list, query);
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

    public List<JiaoTangDO> findAll() {
        return mapper.findAll();
    }

    public JiaoTangDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(JiaoTangDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(JiaoTangDO entity) {
        validationService.validate(entity);
        JiaoTangDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }
    
    public Long countList(JiaoTangQuery query){
    	JiaoTangParam param = new JiaoTangParam();
        BeanUtils.copyProperties(query, param);
        return mapper.countList(param);
     }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(JiaoTangDO source,JiaoTangDO target){
    	target.setLeixing(source.getLeixing());
    	target.setLeixingstring(source.getLeixingstring());
    	target.setAreaId(source.getAreaId());
    	target.setArea1Id(source.getArea1Id());
    	target.setArea2Id(source.getArea2Id());
    	target.setArea3Id(source.getArea3Id());
    	target.setAreaName(source.getAreaName());
    	target.setArea1Name(source.getArea1Name());
    	target.setArea2Name(source.getArea2Name());
    	target.setArea3Name(source.getArea3Name());
    	target.setXiangxidizhi(source.getXiangxidizhi());
    	target.setName(source.getName());
    	target.setBeizhu(source.getBeizhu());
    }
}

package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.util.DateUtil;
import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.HMGQDO;
import com.weishengming.dao.mapper.HMGQMapper;
import com.weishengming.dao.param.HMGQParam;
import com.weishengming.dao.query.HMGQQuery;
import com.weishengming.dao.query.ResultPage;

@Service
public class HMGQService {

    @Resource
    private HMGQMapper        mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<HMGQDO> findPage(HMGQQuery query) {
        validationService.validate(query);
        HMGQParam param = new HMGQParam();
        BeanUtils.copyProperties(query, param);
        List<HMGQDO> list = mapper.findList(param);

        ResultPage<HMGQDO> result = new ResultPage<HMGQDO>(list, query);
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

    public List<HMGQDO> findAll() {
        return mapper.findAll();
    }

    public HMGQDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(HMGQDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public List<HMGQDO> findListByFubiaoti(String fubiaoti) {
        return mapper.findListByFubiaoti(fubiaoti);
    }

    public void update(HMGQDO entity) {
        validationService.validate(entity);
        HMGQDO oldEntity = mapper.findOne(entity.getId());
        mergeEntity(entity, oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }

    public Long countList(HMGQQuery query) {
        HMGQParam param = new HMGQParam();
        BeanUtils.copyProperties(query, param);
        return mapper.countList(param);

    }

    private void mergeEntity(HMGQDO source, HMGQDO target) {
        target.setUpdateDate(DateUtil.getCurrentDate());
        target.setDijige(source.getDijige());
        target.setFubiaoti(source.getFubiaoti());
        target.setBiaoti(source.getBiaoti());
        target.setMaoji(source.getMaoji());
        target.setNeirong(source.getNeirong());
    }
}

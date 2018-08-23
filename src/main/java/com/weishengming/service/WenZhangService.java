package com.weishengming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.util.DateUtil;
import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.entity.WenZhangDO;
import com.weishengming.dao.mapper.WenZhangMapper;
import com.weishengming.dao.param.WenZhangParam;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.WenZhangQuery;

@Service
public class WenZhangService {

    @Resource
    private WenZhangMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<WenZhangDO> findPage(WenZhangQuery query) {
        validationService.validate(query);
        WenZhangParam param = new WenZhangParam();
        BeanUtils.copyProperties(query, param);
        List<WenZhangDO> list = mapper.findList(param);

        ResultPage<WenZhangDO> result=new ResultPage<WenZhangDO>(list, query);
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

    public List<WenZhangDO> findListByFubiaoti(String fubiaoti){
        return mapper.findListByFubiaoti(fubiaoti);
    }

    public List<WenZhangDO> findAll() {
        return mapper.findAll();
    }

    public WenZhangDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(WenZhangDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public Long countList(WenZhangQuery query){
        WenZhangParam param = new WenZhangParam();
        BeanUtils.copyProperties(query, param);
        return mapper.countList(param);

    }

    public void update(WenZhangDO entity) {
        validationService.validate(entity);
        WenZhangDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }

    private void mergeEntity(WenZhangDO source,WenZhangDO target){
        target.setFubiaoti(source.getFubiaoti());
        target.setBiaoti(source.getBiaoti());
        target.setNeirong(source.getNeirong());
        target.setGaishu(source.getGaishu());
        target.setPaixu(source.getPaixu());
        target.setZuozhe(source.getZuozhe());
        target.setLaiyuan(source.getLaiyuan());
    }
}

package com.weishengming.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.weishengming.common.validate.ValidationService;
import com.weishengming.dao.param.DiXiongZiMeiParam;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.user.dao.entity.UserDO;
import com.weishengming.user.dao.mapper.UserMapper;
import com.weishengming.user.dao.param.UserParam;
import com.weishengming.user.dao.query.UserQuery;

@Service
public class UserService {

    @Resource
    private UserMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<UserDO> findPage(UserQuery query) {
        validationService.validate(query);
        UserParam param = new UserParam();
        BeanUtils.copyProperties(query, param);
        List<UserDO> list = mapper.findList(param);
        
        ResultPage<UserDO> result=new ResultPage<UserDO>(list, query);
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
    
    public Long countList(UserQuery query){
    	UserParam param = new UserParam();
        BeanUtils.copyProperties(query, param);
        return mapper.countList(param);
     }

    public List<UserDO> findAll() {
        return mapper.findAll();
    }

    public UserDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(UserDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(UserDO entity) {
        validationService.validate(entity);
        UserDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(UserDO source,UserDO target){
    	//TODO 
    }
}

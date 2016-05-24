package com.weishengming.dao.mapper;

import java.util.List;

import com.weishengming.dao.entity.HMGQDO;

public interface HMGQMapper extends BaseMapper<HMGQDO, Long> {
    public List<HMGQDO> findListByFubiaoti(String fubiaoti);

}
package com.jd.springmvc.service;


import com.jd.springmvc.domain.mongo.document.ShopExcellentRateMongoBean;

import java.util.List;
import java.util.Map;

/**
 * Created by sunboyu on 2017/10/16.
 */
public interface ShopExcellentRateInnerService {

    void insert(ShopExcellentRateMongoBean shopExcellentRateMongoBean);

    void insertAll(List<ShopExcellentRateMongoBean> list);

    void save(ShopExcellentRateMongoBean shopExcellentRateMongoBean);

    void updateFirst(Map<String, Object> qMap, Map<String, Object> uMap);

    ShopExcellentRateMongoBean findOne(Map<String, Object> map);

    List<ShopExcellentRateMongoBean> findMuilt(Map<String, Object> map);
}

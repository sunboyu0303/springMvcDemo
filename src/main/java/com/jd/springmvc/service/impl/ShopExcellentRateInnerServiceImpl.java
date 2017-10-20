package com.jd.springmvc.service.impl;

import com.jd.springmvc.domain.mongo.document.ShopExcellentRateMongoBean;
import com.jd.springmvc.service.ShopExcellentRateInnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by sunboyu on 2017/10/16.
 */
@Service
public class ShopExcellentRateInnerServiceImpl implements ShopExcellentRateInnerService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insert(ShopExcellentRateMongoBean shopExcellentRateMongoBean) {
        mongoTemplate.insert(shopExcellentRateMongoBean);
    }

    public void insertAll(List<ShopExcellentRateMongoBean> list) {
        mongoTemplate.insertAll(list);
    }

    public void save(ShopExcellentRateMongoBean shopExcellentRateMongoBean) {
        mongoTemplate.save(shopExcellentRateMongoBean);
    }

    public void updateFirst(Map<String, Object> qMap, Map<String, Object> uMap) {
        mongoTemplate.updateFirst(getQuery(qMap), getUpdate(uMap), ShopExcellentRateMongoBean.class);
    }

    public ShopExcellentRateMongoBean findOne(Map<String, Object> map) {
        return mongoTemplate.findOne(getQuery(map), ShopExcellentRateMongoBean.class);
    }

    public List<ShopExcellentRateMongoBean> findMuilt(Map<String, Object> map) {
        return mongoTemplate.find(getQuery(map), ShopExcellentRateMongoBean.class);
    }

    private Query getQuery(Map<String, Object> map) {
        Query query = new Query();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            query.addCriteria(Criteria.where(key).is(map.get(key)));
        }
        return query;
    }

    private Update getUpdate(Map<String, Object> map) {
        Update update = new Update();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            update.set(key, map.get(key));
        }
        return update;
    }
}

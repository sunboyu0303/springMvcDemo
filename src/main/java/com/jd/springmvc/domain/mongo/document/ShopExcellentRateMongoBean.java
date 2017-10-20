package com.jd.springmvc.domain.mongo.document;

import com.jd.fastjson.JSONObject;
import com.jd.springmvc.domain.mongo.MongoBaseBean;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * Created by sunboyu on 2017/10/16.
 */
@Data
public class ShopExcellentRateMongoBean extends MongoBaseBean<JSONObject> {

    private String shareId;

    private List<Long> venderIds;

    private Set<Long> skuIds;

    private int contentsubtype;
}

package com.jd.springmvc.controller.mongo;

import com.jd.fastjson.JSONArray;
import com.jd.fastjson.JSONObject;
import com.jd.springmvc.domain.mongo.document.ShopExcellentRateMongoBean;
import com.jd.springmvc.service.ShopExcellentRateInnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by sunboyu on 2017/10/20.
 */
@RestController
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    private ShopExcellentRateInnerService shopExcellentRateInnerService;


    @PostMapping("/updateMongo")
    public JSONObject updateMongo(@RequestBody JSONObject jsonObject) {

        JSONObject qJson = jsonObject.getJSONObject("qMap");
        JSONObject uJson = jsonObject.getJSONObject("uMap");

        Map<String, Object> qMap = new HashMap<>();
        for (String key : qJson.keySet()) {
            qMap.put(key, qJson.get(key));
        }
        Map<String, Object> uMap = new HashMap<>();
        for (String key : uJson.keySet()) {
            uMap.put(key, uJson.get(key));
        }

        shopExcellentRateInnerService.updateFirst(qMap, uMap);
        ShopExcellentRateMongoBean a = shopExcellentRateInnerService.findOne(qMap);
        return (JSONObject) JSONObject.toJSON(a);
    }

    @PostMapping("/saveAllMongo")
    public String saveAllMongo(@RequestBody JSONArray jsonArray) {
        try {
            int length = jsonArray.size();
            JSONObject jsonObject = null;
            ShopExcellentRateMongoBean shopExcellentRateMongoBean = null;
            List<ShopExcellentRateMongoBean> list = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                jsonObject = jsonArray.getJSONObject(i);

                shopExcellentRateMongoBean = new ShopExcellentRateMongoBean();
                shopExcellentRateMongoBean.setShareId(jsonObject.getString("shareid"));
                List<Long> venderIds = new ArrayList<>();
                venderIds.add(111L);
                venderIds.add(222L);
                venderIds.add(333L);
                venderIds.add(444L);
                shopExcellentRateMongoBean.setVenderIds(venderIds);
                shopExcellentRateMongoBean.setSkuIds(new HashSet(venderIds));
                shopExcellentRateMongoBean.setResult(jsonObject);
                shopExcellentRateMongoBean.setContentsubtype(0);

                list.add(shopExcellentRateMongoBean);
            }


            shopExcellentRateInnerService.insertAll(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }
}

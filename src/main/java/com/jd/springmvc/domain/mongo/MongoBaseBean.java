package com.jd.springmvc.domain.mongo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by sunboyu on 2017/10/16.
 */
@Data
public class MongoBaseBean<T extends Object> implements Serializable {

    private static final long serialVersionUID = -187462667282614479L;

    private int status = 0;

    private boolean deleted = Boolean.FALSE;

    private T result;
}

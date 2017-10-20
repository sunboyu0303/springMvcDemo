package com.jd.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

/**
 * Created by sunboyu on 2017/10/20.
 */
@Component
public class MessageConverterConfig {

    @Bean
    public HttpMessageConverter mappingJacksonHttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }

    @Bean
    public HandlerAdapter AnnotationMethodHandlerAdapter() {

        HttpMessageConverter[] httpMessageConverters = new HttpMessageConverter[1];
        httpMessageConverters[0] = mappingJacksonHttpMessageConverter();

        AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter = new AnnotationMethodHandlerAdapter();
        annotationMethodHandlerAdapter.setMessageConverters(httpMessageConverters);

        return annotationMethodHandlerAdapter;
    }
}

package com.jd.springmvc.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan(basePackages = {"com.jd.springmvc"},
    excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class, RestController.class})})
@ImportResource("classpath:jsf-provider.xml")
public class RootConfig {
}

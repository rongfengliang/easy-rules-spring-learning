package com.appdemo.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;

public class SimpleBeanResovler implements BeanResolver {
    private ApplicationContext applicationContext;

    public SimpleBeanResovler(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object resolve(EvaluationContext context, String beanName) {
        return applicationContext.getBean(beanName);
    }
}

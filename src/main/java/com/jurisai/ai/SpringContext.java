package com.jurisai.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware {
    
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    // Método mágico que permite pegar qualquer serviço do Spring de qualquer lugar!
    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }
}
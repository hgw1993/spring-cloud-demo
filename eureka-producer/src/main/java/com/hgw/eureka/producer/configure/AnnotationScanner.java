package com.hgw.eureka.producer.configure;

import com.hgw.eureka.producer.annotation.EnableAuth;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * created 2018/11/7
 * author  guangwei.huang
 */
//@Component
public class AnnotationScanner implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
        if (methods != null && methods.length > 0) {
            for (Method method:methods){
                EnableAuth enableAuth = AnnotationUtils.findAnnotation(method,EnableAuth.class);
                if(enableAuth != null){
                    System.out.println(" enable = "+enableAuth.auth());
                }
            }
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

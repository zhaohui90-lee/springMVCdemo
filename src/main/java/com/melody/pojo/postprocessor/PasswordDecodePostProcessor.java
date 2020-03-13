package com.melody.pojo.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author 40431
 */
public class PasswordDecodePostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object object, String beanName) throws BeansException {
        return object;
    }

    @Override
    public Object postProcessAfterInitialization(Object object, String beanName) throws BeansException {
        if (object instanceof PasswordDecodable){
            String encodePassword = ((PasswordDecodable) object).getEncodingPassword();
            String decodingPassword = decodePassword(encodePassword);
            ((PasswordDecodable) object).setDecodingPassword(decodingPassword);
        }
        return object;
    }

    private String decodePassword(String decodePassword){
        // 解密逻辑
        System.out.println("开始解密...");
        return decodePassword;
    }
}

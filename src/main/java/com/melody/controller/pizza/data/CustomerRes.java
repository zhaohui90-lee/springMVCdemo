package com.melody.controller.pizza.data;

import com.melody.pojo.Customer;

/**
 * @author 40431
 */
public class CustomerRes implements CustomerRespositorImp {
    /**
     * 通过手机号码查找用户
     *
     * @param phoneNumber
     * @return
     */
    @Override
    public Customer findOne(String phoneNumber) {
        return new Customer();
    }
}

package com.melody.controller.pizza.data;

import com.melody.controller.pizza.Order;
import com.melody.pojo.Customer;

import java.util.List;

/**
 * @author 40431
 */
public interface CustomerRespositorImp {

    /**
     * 通过手机号码查找用户
     * @param phoneNumber
     * @return
     */
    Customer findOne(String phoneNumber);

}

package com.melody.controller.pizza;

import com.melody.pojo.Customer;
import org.apache.velocity.runtime.directive.Foreach;

import java.io.Serializable;
import java.util.Iterator;

/**
 * @author 40431
 */
public class PizzaFlowActions implements PizzaFlowActionImp,Serializable {
    /**
     * 保存订单成功或者失败
     *
     * @param order 订单号
     * @return true or false
     */
    @Override
    public boolean saveOrder(Order order) {
        return false;
    }

    /**
     * 通过手机号码查找用户
     *
     * @param phoneNumber 用户注册手机号码
     * @return customer
     */
    @Override
    public boolean lookupCustomer(String phoneNumber) {
        return false;
    }

    /**
     * 检查配送区域
     *
     * @param zipCode 配送区域
     * @return true or false
     */
    @Override
    public boolean checkDeliveryArea(String zipCode) {

        return false;
    }

    /**
     * 添加用户
     *
     * @param customer 用户类
     * @return true or false
     */
    @Override
    public boolean addCustomer(Customer customer) {
        return false;
    }
}

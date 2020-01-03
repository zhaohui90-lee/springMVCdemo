package com.melody.controller.pizza;

import com.melody.controller.pizza.service.PaymentDetails;
import com.melody.pojo.Customer;

/**
 * @author 40431
 */
public interface PizzaFlowActionImp {

    /**
     * 保存订单成功或者失败
     * @param order 订单
     * @return true or false
     */
    boolean saveOrder(Order order);

    /**
     * 通过手机号码查找用户
     * @param phoneNumber 用户注册手机号码
     * @return customer
     */
    Customer lookupCustomer(String phoneNumber);

    /**
     * 检查配送区域
     * @param zipCode 配送区域
     * @return true or false
     */
    boolean checkDeliveryArea(String zipCode);

    /**
     * 添加用户
     * @param customer 用户类
     * @return true or false
     */
    boolean addCustomer(Customer customer);

    /**
     * 检查订单是否异常
     * @param paymentDetails 订单信息
     * @return true or false
     */
    boolean verifyPayment(PaymentDetails paymentDetails);
}

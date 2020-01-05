package com.melody.controller.pizza;

import com.melody.controller.pizza.service.CustomerNotFoundException;
import com.melody.controller.pizza.service.PaymentDetails;
import com.melody.pojo.Customer;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * @author 40431
 */
@Service
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
    public Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException {
        if ("111".equals(phoneNumber)){
            Customer customer = new Customer();
            customer.setName("Craig Walls");
            customer.setAddress("3700 Dunlavy Rd");
            customer.setCity("Denton");
            customer.setState("TX");
            customer.setZipCode("76210");
            customer.setPhoneNumber(phoneNumber);
            return customer;
        }else{
            throw new CustomerNotFoundException();
        }

    }

    /**
     * 检查配送区域
     * 校验配送的zipCode
     * @param zipCode 配送区域
     * @return true or false
     */
    @Override
    public boolean checkDeliveryArea(String zipCode) {
        if ("".equals(zipCode)){
            return false;
        }else{
            return "12345".equals(zipCode);
        }
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

    /**
     * 检查订单是否异常
     *
     * @param paymentDetails 订单信息
     * @return true or false
     */
    @Override
    public boolean verifyPayment(PaymentDetails paymentDetails) {
        return false;
    }


}

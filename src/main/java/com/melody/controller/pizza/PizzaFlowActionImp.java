package com.melody.controller.pizza;

/**
 * @author 40431
 */
public interface PizzaFlowActionImp {

    /**
     * 保存订单成功或者失败
     * @param order 订单号
     * @return true or false
     */
    boolean saveOrder(String order);
}

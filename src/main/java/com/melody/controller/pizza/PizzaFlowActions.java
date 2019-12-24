package com.melody.controller.pizza;

import java.io.Serializable;

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
    public boolean saveOrder(String order) {
        return false;
    }
}

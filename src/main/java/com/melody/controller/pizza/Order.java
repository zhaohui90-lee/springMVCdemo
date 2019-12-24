package com.melody.controller.pizza;

import com.melody.pojo.Customer;
import com.melody.pojo.Payment;
import com.melody.pojo.pizza.Pizza;

import java.io.Serializable;
import java.util.List;

/**
 * 实现Serializable序列化
 * @author 40431
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private Customer customer;
    private List<Pizza> pizzas;
    private Payment payment;

    public Order(Customer customer, List<Pizza> pizzas) {
        this.customer = customer;
        this.pizzas = pizzas;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}

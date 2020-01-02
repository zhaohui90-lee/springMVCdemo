package com.melody.pojo;

import java.util.Arrays;
import java.util.List;

/**
 * @author 40431
 */

public enum PaymentType {

    /**
     * CASH CHECK CREDIT_CARD
     */
    CASH,CHECK,CREDIT_CARD;

    public static List<PaymentType> asList(){
        PaymentType[] all = PaymentType.values();
        return Arrays.asList(all);
    }

    @Override
    public String toString() {
        return "PaymentType{}";
    }
}

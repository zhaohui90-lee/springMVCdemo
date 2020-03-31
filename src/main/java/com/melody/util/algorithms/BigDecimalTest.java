package com.melody.util.algorithms;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: melody
 * @Date: 2020-03-31
 */
public class BigDecimalTest {
    /**
     * BigDecimal.ROUND_UP
     * 无条件进1，1.01 ->1.1
     * BigDecimal.ROUND_DOWN
     * 无条件舍弃，1.09 -> 1.0
     * BigDecimal.ROUND_HALF_UP
     * 四舍五入
     * BigDecimal.ROUND_HALF_DOWN
     * 五舍六入，即舍弃部分大于等于6才会进1
     * BigDecimal.ROUND_CEILING
     * 向正无穷方向舍弃，1.01  -> 1.1
     * BigDecimal.ROUND_FLOOR
     * 向负无穷方向舍弃，1.09  -> 1.0
     * BigDecimal.ROUND_HALF_EVEN
     * 当舍弃部分的左边是奇数时，表现同ROUND_HALF_UP（四舍五入）
     * 当舍弃部分的左边是偶数时，表现同ROUND_HALF_DOWN（五舍六入）
     * BigDecimal.ROUND_UNNECESSARY
     * Assert操作，证明计算是准确的，不需要round
     * @param args
     */
    public static void main(String[] args) {
        BigDecimal accountBalance = new BigDecimal("100");
        BigDecimal oldAccountBalance = new BigDecimal("99");
        BigDecimal addBalance = new BigDecimal("100").divide(new BigDecimal("100"),2,RoundingMode.DOWN);;
        if (accountBalance.subtract(oldAccountBalance).compareTo(addBalance) == 0){
            System.out.println("success...");
        }
    }
}

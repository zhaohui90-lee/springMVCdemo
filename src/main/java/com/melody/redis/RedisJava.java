package com.melody.redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Author: melody
 * @Date: 2020-05-28
 */
public class RedisJava {

    private static final String REQUIRE_PASS = "Jandar";

    public static void main(String[] args) {
        redisToList();
    }

    public static void redisToList(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        jedis.auth(REQUIRE_PASS);
        System.out.println("连接成功");
        //存储数据到列表中
        jedis.lpush("site-list","Runoob");
        jedis.lpush("site-list","Google");
        jedis.lpush("site-list","Taobao");
        // 获取数据并且输出
        List<String> list = jedis.lrange("site-list",0,20);
        for (String s : list) {
            System.out.println("列表是：" + s);
        }

        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }
}

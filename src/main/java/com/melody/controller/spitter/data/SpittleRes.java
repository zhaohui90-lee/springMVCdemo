package com.melody.controller.spitter.data;

import com.melody.pojo.Spittle;
import com.melody.pojo.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 40431
 */
@Component
public class SpittleRes implements SpittleRepository {
    /**
     * fetch List<Spittle> by rule count , max
     *
     * @param max   表示返回的Spittle中ID属性的最大值
     * @param count 表示要返回多少个Spittle对象
     * @return List<Spittle>
     */
    @Override
    public List<Spittle> findSpittle(long max, int count) {
        List<Spittle> spittles = new ArrayList<>(count);
        spittles.add(new Spittle(Long.toString(max),new Date(),123.456D,789.123D));
        return spittles;
    }

    /**
     * fetch Spittle by rule id
     *
     * @param spittleID 查询需要的ID
     * @return Spittle
     */
    @Override
    public User findOne(long spittleID) {
        return new User("",Long.toString(spittleID),"",Long.toString(spittleID));
    }

    /**
     * save spittle
     *
     * @param user 保存的对象
     * @return
     */
    @Override
    public User saveSpittle(User user) {
        return user;
    }
}

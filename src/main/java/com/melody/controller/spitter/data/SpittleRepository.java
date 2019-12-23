package com.melody.controller.spitter.data;

import com.melody.pojo.Spittle;
import com.melody.pojo.User;

import java.util.List;

/**
 * @author 40431
 */
public interface SpittleRepository {

    /**
     * fetch List<Spittle> by rule count , max
     *
     * @param count 表示要返回多少个Spittle对象
     * @param max 表示返回的Spittle中ID属性的最大值
     * @return List<Spittle>
     */
    List<Spittle> findSpittle(long max, int count);

    /**
     * fetch Spittle by rule id
     *
     * @param spittleID 查询需要的ID
     * @return List<Spittle>
     */
    User findOne(long spittleID);

    /**
     * save spittle
     *
     * @param user 保存的对象
     * @return
     */
    User saveSpittle(User user);

}

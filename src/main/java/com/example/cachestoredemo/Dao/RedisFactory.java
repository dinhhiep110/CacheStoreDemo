package com.example.cachestoredemo.Dao;

import com.example.cachestoredemo.Until.Const;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisFactory {

    private static final JedisPool jedisPool = new JedisPool();

    public static Jedis getConnection(){
        //TODO GetTheConnectionFrom ThePool
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //Specific commands
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            //In JedisPool mode, the Jedis resource is returned to the resource pool.
            if (jedis != null) {
                jedis.close();
            }
        }
        return jedis;
    }

    public static void init(){
        //TODO creatJedisPool
        Jedis jedis = getConnection();
        if(!jedis.exists(Const.POINT_KEY)){
            jedis.hset(Const.POINT_KEY,"A", String.valueOf(Const.POINT_A));
            jedis.hset(Const.POINT_KEY,"B", String.valueOf(Const.POINT_B));
            jedis.hset(Const.POINT_KEY,"C", String.valueOf(Const.POINT_C));
        }
    }

}

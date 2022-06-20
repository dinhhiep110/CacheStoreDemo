package com.example.cachestoredemo.Dao;

import com.example.cachestoredemo.Until.Const;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisFactory {

    private static JedisPool jedisPool = new JedisPool();

    private static final String KEY = "Grade";

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
        if(!jedis.exists(KEY)){
            jedis.hset(KEY,"A", String.valueOf(Const.GRADE_A));
            jedis.hset(KEY,"B", String.valueOf(Const.GRADE_B));
            jedis.hset(KEY,"C", String.valueOf(Const.GRADE_C));
        }
    }

    public static void close(){
        jedisPool.close();
    }
}

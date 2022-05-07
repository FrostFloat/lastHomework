package com.utils;

/**
 * 生成随机数据的工具类
 *
 * 产生一个指定范围整形随机数
 */

import java.util.Random;


public class RandomUtil {
    /*产生一个指定范围整形随机数*/
    public static int number(int width){
        Random random =new Random();
        return random.nextInt((int) Math.pow(10,width));
    }
}

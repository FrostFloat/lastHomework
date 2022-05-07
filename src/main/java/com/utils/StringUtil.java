package com.utils;

/**
 * 字符串操作工具类
 */
public class StringUtil {
    /*分割字符串*/
    public static String[] separate(String str){
        System.out.println("StringUtil----StringUtil");
        String[] splits = {"/",";"};
        String[] seps = null;
        for (int i=0;i<=splits.length;i++){
            seps = str.split(splits[i]);
            if(seps.length != 1){
                System.out.println("分割成功");
                return seps;
            }
        }
        System.out.println("分割失败");
        return null;
    }
}

package com.example.demo;

import org.springframework.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * BeanCopier工具类
 *
 * @author Tin
 */
public class BeanCopierUtils {

    /**
     * BeanCopier缓存
     */
    public static ConcurrentHashMap<String, BeanCopier> beanCopierCacheMap = new ConcurrentHashMap<String, BeanCopier>();

    /**
     * 将source对象的属性拷贝到target对象中去
     *
     * @param source source对象
     * @param target target对象
     */
    public  static void copyProperties(Object source, Object target) {

        String cacheKey = source.getClass().toString() +
                target.getClass().toString();
        BeanCopier beanCopier = null;
            if (!beanCopierCacheMap.containsKey(cacheKey)) {
                synchronized (BeanCopierUtils.class) {
                    if (!beanCopierCacheMap.containsKey(cacheKey)) {
                        beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
                        beanCopierCacheMap.put(cacheKey, beanCopier);
                    }else {
                        beanCopier = beanCopierCacheMap.get(cacheKey);
                    }
                }
            } else {
                beanCopier = beanCopierCacheMap.get(cacheKey);
            }
            if (beanCopier != null) {
                beanCopier.copy(source, target, null);
            }
        }
    }



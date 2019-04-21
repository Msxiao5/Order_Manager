package com.xiao5.ordercenter.common.utils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther: Wu Tianbing
 * @date: 2019/3/26 17:20
 */
public class BeanUtils {
    /**
     * 属性信息
     */
    private static final Map<Class, Map<String, PropertyDescriptor>> classPropertyMap = new HashMap<>();

    public static void modifyProperties(Object dest, Object sour, List<String> changeProperties) {
        if (changeProperties == null) {
            return;
        }
        Map<String, PropertyDescriptor> descPropertyMap = getPropertyMap(dest.getClass());
        Map<String, PropertyDescriptor> sourPropertyMap = getPropertyMap(sour.getClass());
        changeProperties.forEach(s -> {
            try {
                descPropertyMap.get(s).getWriteMethod()
                        .invoke(dest, sourPropertyMap.get(s).getReadMethod().invoke(sour));
            } catch (IllegalAccessException e) {
                //TODO 异常处理
            } catch (InvocationTargetException e) {
                //TODO 异常处理
            }
        });
    }

    public static Map<String, PropertyDescriptor> getPropertyMap(Class clazz) {
        Map<String, PropertyDescriptor> propertyMap;
        if ((propertyMap = classPropertyMap.get(clazz)) == null) {
            synchronized (clazz) {
                if ((propertyMap = classPropertyMap.get(clazz)) == null) {
                    final Map<String, PropertyDescriptor> finalPropertyMap = new HashMap<>();
                    propertyMap = finalPropertyMap;
                    try {
                        Arrays.asList(Introspector.getBeanInfo(clazz).getPropertyDescriptors())
                                .forEach(s -> finalPropertyMap.put(s.getName(), s));
                    } catch (IntrospectionException e) {
                        //TODO 异常处理
                    }
                    classPropertyMap.put(clazz, propertyMap);
                }
            }
        }
        return propertyMap;
    }
}

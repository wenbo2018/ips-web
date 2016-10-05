package com.ips.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;

/**
 * Created by shenwenbo on 2016/10/4.
 */
public class MapUtils {

    public static final String setMethodModify = "set";

    public static Object convert2Bean(Map<String, String> map, Object obj) {
        Class class1 = obj.getClass();
        Method[] methods = class1.getMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith(MapUtils.setMethodModify)) {
                String propertyName = methodName.substring(3).toUpperCase(
                        Locale.getDefault());
                String value = map.get(propertyName);
                try {
                    method.invoke(obj, value);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }

}

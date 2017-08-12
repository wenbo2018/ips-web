package com.ips.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
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
                    Type[] ts = method.getGenericParameterTypes();
                    String xclass = ts[0].toString();
                    if (xclass.equals("class java.lang.String")) {
                        method.invoke(obj, value);
                    } else if (xclass.equals("int")) {
                        if (!propertyName.equals("ID"))
                        method.invoke(obj, Integer.parseInt(value));
                    } else if (xclass.equals("double")) {
                        method.invoke(obj, Double.parseDouble(value));
                    }
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

    public static Map convertBean(Object bean) throws IntrospectionException, IllegalAccessException,InvocationTargetException {
        Class type = bean.getClass();
        Map returnMap = new HashMap();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, "");
                }
            }
        }
        return returnMap;
    }

}

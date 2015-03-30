package com.zwb.args.fragmentargs.annotations;

import android.support.v4.app.Fragment;

import com.maomao.client.utils.LogUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Fragment的参数解析
 * Created by wenbiao_zheng on 2015/2/4.
 *
 * @author wenbiao_zheng
 */
public class FragmentArgs {
    private static Map<String, Field> valueMap = new HashMap<String, Field>();

    /**
     * 注册表的注册，会根据注册进来的Fragment生成参数的映射表
     *
     * @param fragment 要注册的Fragment
     */
    public static void inject(Fragment fragment) {
        Class<?> clazz = fragment.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Arg.class)) {
                Arg arg = field.getAnnotation(Arg.class);
                String key = arg.value();
                valueMap.put(clazz.getName() + key, field);
            }
        }
    }

    /**
     * 设置参数的值
     *
     * @param fragment 要设置值的Fragment
     * @param params   要设置值的参数
     * @param objects  要设置的值
     */
    public static void setValue(Fragment fragment, String[] params, Object[] objects) {
        for (int i = 0, size = params.length; i < size; ++i) {
            Field field = valueMap.get(fragment.getClass().getName() + params[i]);
            try {
                field.setAccessible(true);
                field.set(fragment, objects[i]);
            } catch (IllegalAccessException e) {
                LogUtil.e(e.toString());
            }
        }
    }
}

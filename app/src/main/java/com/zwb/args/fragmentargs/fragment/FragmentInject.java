package com.zwb.args.fragmentargs.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.zwb.args.fragmentargs.annotations.Arg;

import java.lang.reflect.Field;

/**
 * Created by zwb on 2016/7/17.
 */
public class FragmentInject {
    public static void inject(Fragment fragment) {
        Bundle data = fragment.getArguments();
        Field[] fields = fragment.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Arg.class)) {
                field.setAccessible(true);
                try {
                    field.set(fragment, data.get(field.getName()));
                } catch (IllegalAccessException e) {

                }
            }
        }
    }
}

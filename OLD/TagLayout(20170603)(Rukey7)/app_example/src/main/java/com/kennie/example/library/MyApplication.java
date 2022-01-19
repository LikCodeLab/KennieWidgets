package com.kennie.example.library;

import android.app.Application;

import com.kennie.example.library.utils.ToastUtils;


/**
 * Created by long on 2016/12/9.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtils.init(this);
    }
}

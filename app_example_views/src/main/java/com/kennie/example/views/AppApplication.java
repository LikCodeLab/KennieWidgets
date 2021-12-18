package com.kennie.example.views;

import android.app.Application;

import com.kennie.example.views.label.utils.ToastUtils;

/**
 * @项目名 KennieProject
 * @类名称 AppApplication
 * @类描述
 * @创建人 Administrator
 * @修改人
 * @创建时间 2021/12/18 2:45
 */
public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtils.init(this);
    }
}

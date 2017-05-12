package com.hsy.fresco.frescodemo;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 作者：huangshuyuan on 2017/5/12 09:39
 * 邮箱：hshuyuan@foxmail.com
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        Fresco.initialize(this);
    }
}

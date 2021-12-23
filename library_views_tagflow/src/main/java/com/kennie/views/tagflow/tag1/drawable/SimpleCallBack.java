package com.kennie.views.tagflow.tag1.drawable;

import android.graphics.drawable.Drawable;


public abstract class SimpleCallBack implements Drawable.Callback {

    @Override
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
    }

    @Override
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }
}

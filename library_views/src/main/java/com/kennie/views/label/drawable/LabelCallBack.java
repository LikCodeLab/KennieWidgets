package com.kennie.views.label.drawable;

import android.graphics.drawable.Drawable;


public abstract class LabelCallBack implements Drawable.Callback {

    @Override
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
    }

    @Override
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }
}

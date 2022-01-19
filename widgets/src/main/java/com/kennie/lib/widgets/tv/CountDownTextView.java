package com.kennie.lib.widgets.tv;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.kennie.lib.widgets.R;



/**
 * Author：Kennie
 * Project：KennieUtils
 * Class：CountDownTextView
 * Date：2021/12/12 23:15
 * Desc：验证码倒计时
 */
public class CountDownTextView extends AppCompatTextView implements Runnable {

    /**
     * 倒计时秒数
     */
    private int mTotalSecond = 60;
    /**
     * 秒数单位(默认)
     */
    private static final String DEFAULT_TIME_UNIT = "S";

    /**
     * 延时时间(默认)
     */
    private static final long DEFAULT_DELAY_MILLIS = 1000;

    /**
     * 当前秒数
     */
    private int mCurrentSecond;
    /**
     * 记录原有的文本
     */
    private CharSequence mRecordText;


    public CountDownTextView(Context context) {
        super(context);
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 设置倒计时总秒数
     */
    public void setTotalTime(int totalTime) {
        this.mTotalSecond = totalTime;
    }


    /**
     * 开始倒计时
     */
    public void start() {
        mRecordText = getText();
        setEnabled(false);
        mCurrentSecond = mTotalSecond;
        post(this);
    }

    /**
     * 结束倒计时
     */
    public void stop() {
        setText(mRecordText);
        setEnabled(true);
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        // 移除延迟任务，避免内存泄露
        removeCallbacks(this);
    }

    @Override
    public void run() {
        if (mCurrentSecond == 0) {
            stop();
            return;
        }
        mCurrentSecond--;
        setText(getContext().getString(R.string._countdown_textview_apply, mCurrentSecond, DEFAULT_TIME_UNIT));
        //setText(mCurrentSecond + " " + TIME_UNIT);
        postDelayed(this, DEFAULT_DELAY_MILLIS);
    }
}

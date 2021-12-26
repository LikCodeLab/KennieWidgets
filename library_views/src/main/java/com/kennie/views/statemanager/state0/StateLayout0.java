package com.kennie.views.statemanager.state0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.kennie.views.R;

/**
 * @项目名 KennieViews
 * @类名称 StateLayout0
 * @类描述 状态布局（网络错误，异常错误，空数据）
 * @创建人 Kennie
 * @修改人
 * @创建时间 2021/11/18 0:08
 */
public class StateLayout0 extends FrameLayout {

    /**
     * 主布局
     */
    private ViewGroup mMainLayout;
    /**
     * 提示图标
     */
    private LottieAnimationView mLottieView;
    /**
     * 提示文本
     */
    private AppCompatTextView mTextView;
    /**
     * 重试按钮
     */
    private AppCompatButton mRetryView;
    /**
     * 重试监听
     */
    private OnRetryListener mListener;

    public StateLayout0(@NonNull Context context) {
        super(context);
    }

    public StateLayout0(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StateLayout0(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 显示
     */
    public void show() {

        if (mMainLayout == null) {
            //初始化布局
            initLayout();
        }

        if (isShow()) {
            return;
        }
        mRetryView.setVisibility(mListener == null ? View.INVISIBLE : View.VISIBLE);
        // 显示布局
        mMainLayout.setVisibility(VISIBLE);
    }

    /**
     * 隐藏
     */
    public void hide() {
        if (mMainLayout == null || !isShow()) {
            return;
        }
        //隐藏布局
        mMainLayout.setVisibility(INVISIBLE);
    }

    /**
     * 是否显示了
     */
    public boolean isShow() {
        return mMainLayout != null && mMainLayout.getVisibility() == VISIBLE;
    }

    /**
     * 设置提示图标，请在show方法之后调用
     */
    public void setIcon(@DrawableRes int id) {
        setIcon(ContextCompat.getDrawable(getContext(), id));
    }

    public void setIcon(Drawable drawable) {
        if (mLottieView == null) {
            return;
        }
        if (mLottieView.isAnimating()) {
            mLottieView.cancelAnimation();
        }
        mLottieView.setImageDrawable(drawable);
    }

    /**
     * 设置提示动画
     */
    public void setAnimResource(@RawRes int id) {
        if (mLottieView == null) {
            return;
        }

        mLottieView.setAnimation(id);
        if (!mLottieView.isAnimating()) {
            mLottieView.playAnimation();
        }
    }

    /**
     * 设置提示文本，请在show方法之后调用
     */
    public void setHint(@StringRes int id) {
        setHint(getResources().getString(id));
    }

    public void setHint(CharSequence text) {
        if (mTextView == null) {
            return;
        }
        if (text == null) {
            text = "";
        }
        mTextView.setText(text);
    }

    /**
     * 初始化提示的布局
     */
    private void initLayout() {

        mMainLayout = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout._state_layout0, this, false);

        mLottieView = mMainLayout.findViewById(R.id._iv_status_icon);
        mTextView = mMainLayout.findViewById(R.id._iv_status_text);
        mRetryView = mMainLayout.findViewById(R.id._iv_status_retry);

        if (mMainLayout.getBackground() == null) {
            // 默认使用 windowBackground 作为背景
            TypedArray typedArray = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowBackground});
            mMainLayout.setBackground(typedArray.getDrawable(0));
            mMainLayout.setClickable(true);
            typedArray.recycle();
        }

        mRetryView.setOnClickListener(mClickWrapper);

        addView(mMainLayout);
    }

    /**
     * 设置重试监听器
     */
    public void setOnRetryListener(OnRetryListener listener) {
        mListener = listener;
        if (isShow()) {
            mRetryView.setVisibility(mListener == null ? View.INVISIBLE : View.VISIBLE);
        }
    }

    /**
     * 点击事件包装类
     */
    private final OnClickListener mClickWrapper = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (mListener == null) {
                return;
            }
            mListener.onRetry(StateLayout0.this);
        }
    };

    /**
     * 重试监听器
     */
    public interface OnRetryListener {

        /**
         * 点击了重试
         */
        void onRetry(StateLayout0 layout);
    }
}

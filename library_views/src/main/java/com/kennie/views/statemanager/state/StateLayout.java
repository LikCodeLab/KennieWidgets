package com.kennie.views.statemanager.state;

/**
 * @项目名 KennieViews
 * @类名称 StateLayout
 * @类描述 页面状态
 * @创建人 Kennie
 * @修改人
 * @创建时间 2021/12/26 23:18
 */
public class StateLayout {

    /*当前状态 默认加载中 */
    private int mCurrentState = StateType.STATE_LOADING;

    /*回调接口*/
    private OnReloadListener mOnReloadListener;
    private OnStateListener mOnStateListener;


    /**
     * 设置点击重试的点击事件
     *
     * @param listener
     */
    public void setOnReloadListener(OnReloadListener listener) {
        mOnReloadListener = listener;
    }

    public interface OnReloadListener {
        void onStateReload();
    }

    /**
     * 设置点击重试的点击事件
     * 空/加载失败/网络错误的点击事件可分别处理
     *
     * @param listener
     */
    public void setOnStateListener(OnStateListener listener) {
        mOnStateListener = listener;
    }

    public interface OnStateListener {
        void onStateEmpty();

        void onStateError();

        void onStateNetError();
    }

}

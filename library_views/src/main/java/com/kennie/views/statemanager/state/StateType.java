package com.kennie.views.statemanager.state;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @项目名 KennieViews
 * @类名称 StateType
 * @类描述 状态Type
 * @创建人 Kennie
 * @修改人
 * @创建时间 2021/12/26 23:22
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({StateType.STATE_NORMAL, StateType.STATE_LOADING,
        StateType.STATE_ERROR, StateType.STATE_EMPTY,
        StateType.STATE_NET_ERROR, StateType.STATE_LOGIN_ERROR,
        StateType.STATE_PLACEHOLDER, StateType.STATE_CUSTOM,})
public @interface StateType {

    /* 内容 */
    public static final int STATE_NORMAL = 0;
    /* 加载中 */
    public static final int STATE_LOADING = 1;
    /* 加载失败 */
    public static final int STATE_ERROR = 2;
    /* 空数据 */
    public static final int STATE_EMPTY = 3;
    /* 网络异常(包含超时) */
    public static final int STATE_NET_ERROR = 4;
    /* 登录失效 */
    public static final int STATE_LOGIN_ERROR = 5;
    /* 占位图 */
    public static final int STATE_PLACEHOLDER = 6;
    /* 自定义 */
    public static final int STATE_CUSTOM = 7;
}

package com.kennie.example.state

import android.app.Application
import com.kennie.views.statemanager.state2.StateConfig

/**
 * @项目名 KennieViews
 * @类名称 App
 * @类描述
 * @创建人 Administrator
 * @修改人
 * @创建时间 2021/12/27 0:15
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        state2()

    }

    private fun state2() {
        StateConfig.apply {
            emptyLayout = R.layout.layout_empty
            errorLayout = R.layout.layout_error
            loadingLayout = R.layout.layout_loading

            setRetryIds(R.id.msg, R.id.iv)
        }
    }
}
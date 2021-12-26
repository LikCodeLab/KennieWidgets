package com.kennie.example.state.state2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.kennie.example.state.R
import kotlinx.android.synthetic.main.activity_state2_example.*
import kotlin.concurrent.thread

class State2ExampleActivity : AppCompatActivity(R.layout.activity_state2_example) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        state.onRefresh {
            // 一般在这里进行网络请求
            thread {
                Thread.sleep(2000)
                showContent()
            }
        }.showLoading()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.state, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_loading -> state.showLoading()
            R.id.menu_content -> state.showContent()
            R.id.menu_error -> state.showError(NullPointerException())
            R.id.menu_empty -> state.showEmpty()
        }
        return true
    }
}

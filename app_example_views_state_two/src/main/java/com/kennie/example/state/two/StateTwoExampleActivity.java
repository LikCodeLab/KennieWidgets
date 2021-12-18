package com.kennie.example.state.two;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kennie.views.statemanager.StateManager;

/**
 * @项目名 KennieViews
 * @类名称 StateTwoExampleActivity
 * @类描述
 * @创建人 Administrator
 * @修改人
 * @创建时间 2021/12/18 18:17
 */
public class StateTwoExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_state_two);

        final LinearLayout llContent = findViewById(R.id.ll_content);
        final StateManager manager = StateManager.with(llContent)
                .setNoNetworkView(R.layout.item_text_grid)
                .onRetry(new StateManager.Action() {
                    @Override
                    public void run(final StateManager manager) {
                        Toast.makeText(StateTwoExampleActivity.this, "onRetry", Toast.LENGTH_SHORT).show();
                        manager.showLoading();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        manager.showContent();
                                    }
                                });
                            }
                        }).start();
                    }
                })
                .onLogin(new StateManager.Action() {
                    @Override
                    public void run(StateManager manager) {
                        Toast.makeText(StateTwoExampleActivity.this, "onLogin", Toast.LENGTH_SHORT).show();
                    }
                })
                .showLoading();

        findViewById(R.id.btn_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.showContent();
            }
        });

        findViewById(R.id.btn_loading).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.showLoading();
            }
        });

        findViewById(R.id.btn_empty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.showEmpty();
            }
        });

        findViewById(R.id.btn_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.showError("自定义错误信息" + System.currentTimeMillis());
//                manager.showError();
            }
        });

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.showLogin();
            }
        });

        findViewById(R.id.btn_no_network).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.showNoNetwork();
            }
        });
    }
}

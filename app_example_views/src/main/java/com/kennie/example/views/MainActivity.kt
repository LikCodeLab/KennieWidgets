package com.kennie.example.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.kennie.example.views.label.ExampleLabelTagLayoutActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.function1).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, ExampleCheckViewActivity::class.java));
        })
        findViewById<Button>(R.id.function2).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, ExampleLabelTagLayoutActivity::class.java));
        })
    }
}
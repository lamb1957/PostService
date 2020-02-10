package com.example.postservice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.util.Log
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    var button: Button by Delegates.notNull<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        button.setOnClickListener {
                var post: AsyncHttp = AsyncHttp("Android", 10.11)
                post.execute()
            }
        }
}

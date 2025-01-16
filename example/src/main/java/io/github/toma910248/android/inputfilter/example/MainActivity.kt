package io.github.toma910248.android.inputfilter.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.toma910248.android.inputfilter.example.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}
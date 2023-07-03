package com.example.floatbutton.function15

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.floatbutton.R

class Function15Activity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function15)

        val list = findViewById<RecyclerView>(R.id.card_list)
        list.adapter = CardAdapter()
    }
}
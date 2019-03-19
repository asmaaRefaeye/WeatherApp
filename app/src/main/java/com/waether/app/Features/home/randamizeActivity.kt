package com.waether.app.Features.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.waether.app.R
import kotlinx.android.synthetic.main.activity_main.*

class randamizeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //

        val ViewModel =ViewModelProviders.of(this).get(RandamizeViewModel::class.java)
        incementer_button.setOnClickListener {
            ViewModel.increamentNumber ()
        }

        ViewModel.randomValue.observe(this,
            Observer { randamize_Activity_Textview.text =it.toString() }
            )


    }
}

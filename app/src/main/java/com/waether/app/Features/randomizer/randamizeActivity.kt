package com.waether.app.Features.randomizer

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.waether.app.Core.ContentViewId
import com.waether.app.R
import kotlinx.android.synthetic.main.activity_randomizer.*
@ContentViewId(R.layout.activity_randomizer)
class randamizeActivity : AppCompatActivity() {


        private val viewModel by lazy {
            ViewModelProviders.of(this).get(RandomizerViewModel::class.java)
        }


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            viewModel.numberLiveData.observe(this,
                Observer { randamize_Activity_Textview.text = it.toString() })

            incementer_button.setOnClickListener {
                viewModel.incrementNumber()
            }
        }
}

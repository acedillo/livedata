package com.example.cedilla.myapp.presentation

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.cedilla.myapp.R
import com.example.cedilla.myapp.data.DatabaseDataSource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityView {

    private lateinit var mPresenter : MainActivityPresenter<MainActivityView>

    override fun updateText(text : String) {
        mainText.text = text
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = MainActivityPresenter()
        mPresenter.onAttach(this)

        mainClickMeButton.setOnClickListener { mPresenter.onButtonClicked(this) }

        DatabaseDataSource.getInstance(this).getAll().observeForever(Observer {
            Log.d("database", "Called list $it.size")
        })

        DatabaseDataSource.getInstance(this).getCount().observeForever(Observer {
            Log.d("database", "Called count $it")
        })

    }

    override fun onDestroy() {
        mPresenter.onDetach()
        super.onDestroy()
    }


}

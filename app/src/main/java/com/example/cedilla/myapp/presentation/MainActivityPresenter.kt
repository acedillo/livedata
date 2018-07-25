package com.example.cedilla.myapp.presentation

import android.content.Context
import android.util.Log
import com.example.cedilla.myapp.data.DatabaseDataSource
import com.example.cedilla.myapp.model.User

class MainActivityPresenter<V : MainActivityView> {


    private var view: V? = null
    private var id = 0

    private val isViewAttached: Boolean get() = view != null

    fun onAttach(view: V?) {
        this.view = view
    }

    fun onDetach() {
        view = null
    }

    fun getView(): V? = view

    fun onButtonClicked(context: Context){
        getView()!!.updateText("test complete")
        Log.d("Database", "click!")
        DatabaseDataSource.getInstance(context).insert(createUser("blah $id"))
    }

    private fun createUser(name : String) : User{
        return User(name, "lastname")
    }
}
package com.example.mvvm.view


import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.mvvm.R

import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.view_model.LoginViewModel




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        activityMainBinding.viewModel = LoginViewModel()
        activityMainBinding.executePendingBindings()




    }

    @BindingAdapter("toastMessage")
    fun runMe(view: View, message: String?) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show()
    }
}

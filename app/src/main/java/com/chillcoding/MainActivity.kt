package com.chillcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.content.Context
import android.content.res.Resources.getSystem



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Log.i(MainActivity::class.simpleName, getString(R.string.oncreate))


    }

    override fun onStart() {
        super.onStart()
        //Log.i(MainActivity::class.simpleName, getString(R.string.onstart))

    }
}
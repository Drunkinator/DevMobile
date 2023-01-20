package com.chillcoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(MainActivity::class.simpleName, getString(R.string.text_oncreate))
    }

    override fun onStart() {
        super.onStart()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_onstart))
    }

    override fun onResume() {
        super.onResume()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_onresume))
    }

    override fun onPause() {
        super.onPause()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_onpause))
    }


    override fun onRestart() {
        super.onRestart()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_onrestart))
    }

    override fun onStop() {
        super.onStop()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_onstop))
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_ondestroy))
    }

    //Main button method
    fun onClickStartQuiz(view : View){
        val intent = Intent (this,QuizActivity1 :: class.java)
        startActivity(intent)
    }
}
package com.example.chapter2

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showLog("onCreate 호출됨")
        setContentView(R.layout.activity_main)

        val numberTextView = findViewById<TextView>(R.id.numberTextView)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val plusButton = findViewById<Button>(R.id.plusButton)

        resetButton.setOnClickListener {
            number = 0
            numberTextView.text = number.toString()
            Log.d("onClick", "리셋된 숫자는 $number")
        }

        plusButton.setOnClickListener{
            number += 1
            numberTextView.text = number.toString()
            Log.d("onClick","플러스 된 숫자는 $number")
        }

        if(savedInstanceState != null){
            number = savedInstanceState.getInt("count", 0)
            showLog("데이터 로드 $number !!")
            numberTextView.text = number.toString()
        }

    }

    override fun onStart() {
        super.onStart()
        showLog("onStart 호출됨")
    }

    override fun onStop() {
        super.onStop()
        showLog("onStop 호출됨")
    }

    override fun onDestroy() {
        super.onDestroy()
        showLog("onDestroy 호출됨")
    }

    private fun showLog(data: String) {
        Log.d("LifeCycle", data)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        showLog("데이터 저장 $number !!")
        outState.putInt("count", number)
        super.onSaveInstanceState(outState)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        showLog("화면전환!! config: $newConfig")

        val temp = number
        showLog("데이터 저장 : $temp")

        setContentView(R.layout.activity_main)

        val numberTextView1 = findViewById<TextView>(R.id.numberTextView)

        showLog("데이터 로드 : $temp")
        numberTextView1.text = temp.toString()


    }
}


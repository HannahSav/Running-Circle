package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toast.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sunImageView =
            findViewById<View>(R.id.sun) as ImageView
        val sunRiseAnimation = AnimationUtils.loadAnimation(this, R.anim.circle_move)
        val sunSetAnimation = AnimationUtils.loadAnimation(this, R.anim.circle_move2)

        var point: Int = -1

        button.setOnClickListener {
            if(point < 0) {
                button.setText("Hi!")
                sunImageView.startAnimation(sunRiseAnimation)
            }
            else {
                button.setText("See u")
                sunImageView.startAnimation(sunSetAnimation)
            }
            point *= (-1)
        }
    }


    var x: Float = 110.0F
    var y:Float = 160.0F
    override fun onTouchEvent(event: MotionEvent): Boolean {
        x = event.x
        y = event.y
        textView.setText("x = "+ x+ " y = "+ y)
       // val anim = AnimationUtils.loadAnimation(this, R.anim.circle_move)
        return true
    }
}
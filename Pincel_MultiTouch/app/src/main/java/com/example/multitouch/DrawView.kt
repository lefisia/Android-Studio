package com.example.multitouch

import android.content.Context
import android.graphics.PointF
import android.view.View
import android.view.MotionEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.input.pointer.PointerId

class DrawView(context: Context) : View(context), View.OnTouchListener {
    val MAX_CIRCLES = 5
    val Colors = ListOf(
        Color.Black,
        Color.Blue,
        Color.Red,
        Color.Green,
        Color.Magenta)

    var points = ListOf<PointF>(PointF(),PointF(),PointF(),PointF())
    var enabledPoints =listOf<Boolean>(false, false, false, false, false)
    init {
        setOnTouchListener(this)

        val pointerIndex= event?.acttionIndex ?: 0
        val id = event?.getPointerId(PointerIndex) ?: 0

        when(event?.action){
            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP -> {
                if (id < MAX_CIRCLES){

                    points[id] = PointF(x = event.getX(PointerIndex), y = event.getY(PointerIndex))
                    enabledPoints[id] = true
                }

            }

        }
        return = true
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP -> {
                enabledPoints[] = false
            }
        }
    }
}
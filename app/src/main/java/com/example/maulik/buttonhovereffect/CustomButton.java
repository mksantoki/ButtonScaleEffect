package com.example.maulik.buttonhovereffect;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

/**
 * Created by Developer on 20/12/18.
 */
public class CustomButton extends AppCompatButton {
    public CustomButton(Context context) {
        super(context);
        pressEffect();
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        pressEffect();
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        pressEffect();
    }

    private void pressEffect() {
        setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.e("Test", " pressed ");
                        scaleView(v, 1f, 0.95f, 1f, 0.95f);
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.e("Test", " released ");
                        scaleView(v, 0.95f, 1f, 0.95f, 1f);
                        callOnClick();
                        return true;
                }
                return false;
            }
        });
    }

    public void scaleView(View v, float startScaleX, float endScaleX, float startScaleY, float endScaleY) {
        Animation anim = new ScaleAnimation(
                startScaleX, endScaleX, // Start and end values for the X axis scaling
                startScaleY, endScaleY, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
        anim.setFillAfter(true); // Needed to keep the result of the animation
        anim.setDuration(0);
        v.startAnimation(anim);
    }
}

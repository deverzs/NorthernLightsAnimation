package edu.miracostacollege.cs134.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Frame Animation
    AnimationDrawable frameAnim ; // here it is null, if hasn't started want to start it, vice versa

    //Tween animation
    Animation rotateAnim;
    Animation shakeAnim;
    Animation customAnim;

    private ImageView lightsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightsImageView = findViewById(R.id.lightsImageView);
    }

    //FRAME ANIMATION (not Tween Anim)
    public void toggleFrameAnim(View v)
    {
        if(frameAnim == null)
        {
            lightsImageView.setBackgroundResource(R.drawable.frame_anim);
            frameAnim = (AnimationDrawable) lightsImageView.getBackground() ;
        }
        //if the animation is runing and we click the button, stop the animation
        if(frameAnim.isRunning())
        {
            frameAnim.stop();
        }
        else
        {
            frameAnim.start();
        }

    }


    public void toggleRotateAnim(View v)
    {
        //check to see if the rotate_anim has already started
        //if start it, stop it
        if(rotateAnim != null && rotateAnim.hasStarted())
        {
            lightsImageView.clearAnimation();
            rotateAnim = null;
        }
        else
        {
            rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim) ;
            lightsImageView.startAnimation(rotateAnim);
        }
    }

    public void toggleShakeAnim(View v)
    {
        //check to see if the rotate_anim has already started
        //if start it, stop it
        if(shakeAnim != null && shakeAnim.hasStarted())
        {
            lightsImageView.clearAnimation();
            shakeAnim = null;
        }
        else
        {
            shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim) ;
            lightsImageView.startAnimation(shakeAnim);
        }
    }

    public void toggleCustomAnim(View v)
    {
        if(customAnim != null && customAnim.hasStarted())
        {
            lightsImageView.clearAnimation();
            customAnim = null;
        }
        else
        {
            customAnim = AnimationUtils.loadAnimation(this, R.anim.custom_anim) ;
            lightsImageView.startAnimation(customAnim);
        }
    }


}

package com.example.playanimation

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {

    private lateinit var playButton: LottieAnimationView
    private lateinit var playingBar: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playButton = findViewById(R.id.play_button)
        playingBar = findViewById(R.id.playing_bar)

        playButton.setOnClickListener {
            play()
        }
    }


    fun play() {

        val animtor = ValueAnimator.ofFloat(0f, 0.5f)
        animtor.addUpdateListener { animator ->
            playButton.progress = animator.animatedValue as Float
        }

        animtor.duration = 500
        animtor.start()

        playingBar.playAnimation()

        playButton.setOnClickListener {
            pause()
        }
    }

    fun pause() {
        val animtor = ValueAnimator.ofFloat(0.5f, 1f)
        animtor.addUpdateListener { animator ->
            playButton.progress = animator.animatedValue as Float
        }

        animtor.duration = 500
        animtor.start()

        playingBar.pauseAnimation()

        playButton.setOnClickListener {
            play()
        }
    }

}
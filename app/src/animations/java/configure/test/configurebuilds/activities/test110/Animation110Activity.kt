package configure.test.configurebuilds.activities.test110

import android.animation.AnimatorSet
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.animations.activity_animation110.*


class Animation110Activity : AppCompatActivity() {

    val mAnimatorSet = AnimatorSet()
    var mOriginalWidth: Int = 0
    var mOriginalHeight: Int = 0

    var mScaledWidth: Int = 0
    var mScaledHeight: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation110)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun setUpAnimation() {


    }

    fun onAnimationClick(view: View) {
        val loadAnimation = AnimationUtils.loadAnimation(this, R.anim.text_view_scale_animation)
//        animation_text_view.clearAnimation()
//        animation_text_view.animation = loadAnimation
        animation_text_view.startAnimation(loadAnimation)

    }

}

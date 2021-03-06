/*
 * Copyright 2018 Pankaj Nimgade
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package configure.test.configurebuilds.activities.test101

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.animation.BounceInterpolator
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.animations.activity_animation101.*


class Animation101Activity : AppCompatActivity() {

    private lateinit var animateHorizontallyButton: Button
    private lateinit var animateVerticallyButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation101)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        initializeUi()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initializeUi() {

        animateHorizontally()
        animateVertically()

    }

    private fun animateVertically() {
        animateVerticallyButton = findViewById(R.id.Animation101Activity_animate_vertically_button)

        animateVerticallyButton.setOnClickListener {

            val animation = ValueAnimator.ofFloat(0f, -200f)
            animation.duration = 1000
            animation.interpolator = BounceInterpolator()
            animation.start()

            animation.addUpdateListener { updatedAnimation ->
                updatedAnimation.let {
                    val animatedValue = updatedAnimation.animatedValue as Float
                    animateVerticallyButton.translationY = animatedValue
                }
            }
        }
    }

    private fun animateHorizontally() {
        animateHorizontallyButton = findViewById(R.id.Animation101Activity_animate_horizontally_button)

        animateHorizontallyButton.setOnClickListener {

            val animation = ValueAnimator.ofFloat(0f, 200f)
            animation.duration = 1000
            animation.interpolator = BounceInterpolator()
            animation.start()

            animation.addUpdateListener { updatedAnimation ->
                updatedAnimation.let {
                    val animatedValue = updatedAnimation.getAnimatedValue() as Float
                    animateHorizontallyButton.translationX = animatedValue
                }
            }
        }
    }

}

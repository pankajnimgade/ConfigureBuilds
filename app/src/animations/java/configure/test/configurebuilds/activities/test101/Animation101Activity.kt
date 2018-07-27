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
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import configure.test.configurebuilds.R
import kotlinx.android.synthetic.animations.activity_animation101.*


class Animation101Activity : AppCompatActivity() {

    private lateinit var animateButton: Button

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

    }

    private fun animateHorizontally() {
        animateButton = findViewById(R.id.Animation101Activity_animate_button)

        animateButton.setOnClickListener {

            val animation = ValueAnimator.ofFloat(0f, 100f)
            animation.duration = 1000
            animation.start()

            animation.addUpdateListener { updatedAnimation ->
                updatedAnimation.let {
                    val animatedValue = updatedAnimation.getAnimatedValue() as Float
                    animateButton.translationX = animatedValue
                }
            }
        }
    }

}
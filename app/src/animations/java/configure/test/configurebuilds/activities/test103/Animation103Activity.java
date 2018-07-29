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

package configure.test.configurebuilds.activities.test103;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;

import configure.test.configurebuilds.R;

public class Animation103Activity extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5, button6, button7;
    private ObjectAnimator animate1, animate2, animate3, animate4, animate5, animate6, animate7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation103);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initializeUi();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initializeUi() {
        button1 = findViewById(R.id.Animation103Activity_button1);
        button2 = findViewById(R.id.Animation103Activity_button2);
        button3 = findViewById(R.id.Animation103Activity_button3);
        button4 = findViewById(R.id.Animation103Activity_button4);
        button5 = findViewById(R.id.Animation103Activity_button5);
        button6 = findViewById(R.id.Animation103Activity_button6);
        button7 = findViewById(R.id.Animation103Activity_button7);

        animate1 = ObjectAnimator.ofFloat(button1, "translationX", 200f);
        animate1.setDuration(700);
        animate1.setInterpolator(new AccelerateInterpolator());

        animate2 = ObjectAnimator.ofFloat(button2, "translationX", 200f);
        animate2.setDuration(700);
        animate2.setInterpolator(new AccelerateInterpolator());

        animate3 = ObjectAnimator.ofFloat(button3, "translationX", 200f);
        animate2.setDuration(700);
        animate2.setInterpolator(new AccelerateInterpolator());

        animate4 = ObjectAnimator.ofFloat(button4, "translationX", 200f);
        animate4.setDuration(700);
        animate4.setInterpolator(new AccelerateInterpolator());

        animate5 = ObjectAnimator.ofFloat(button5, "translationX", 200f);
        animate5.setDuration(700);
        animate5.setInterpolator(new AccelerateInterpolator());

        animate6 = ObjectAnimator.ofFloat(button6, "translationX", 200f);
        animate6.setDuration(700);
        animate6.setInterpolator(new AccelerateInterpolator());

        animate7 = ObjectAnimator.ofFloat(button7, "translationX", 200f);
        animate7.setDuration(700);
        animate7.setInterpolator(new AccelerateInterpolator());

        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animate1);
        animatorSet.play(animate2).after(animate1);
        animatorSet.play(animate3).after(animate2);
        animatorSet.play(animate4).after(animate3);
        animatorSet.play(animate5).after(animate4);
        animatorSet.play(animate6).after(animate5);
        animatorSet.play(animate7).after(animate6);
        ValueAnimator fadeAnim = ObjectAnimator.ofFloat(animate1, "alpha", 1f, 0f);
        fadeAnim.setDuration(250);
        fadeAnim.start();
        animatorSet.play(animate1).before(fadeAnim);
        animatorSet.start();


    }

}

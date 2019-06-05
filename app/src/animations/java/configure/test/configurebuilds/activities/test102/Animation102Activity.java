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

package configure.test.configurebuilds.activities.test102;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import configure.test.configurebuilds.R;

public class Animation102Activity extends AppCompatActivity {

    private Button animateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation102);
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
        animateButton = findViewById(R.id.Animation102Activity_animate_button);


        animateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animationX = ObjectAnimator.ofFloat(animateButton,
                        "translationX", -100f);
                animationX.setDuration(1000);
                animationX.setInterpolator(new AccelerateInterpolator());
                animationX.start();

                ObjectAnimator animationY = ObjectAnimator.ofFloat(animateButton, "translationY",
                        -100f);
                animationY.setDuration(1000);
                animationY.setInterpolator(new AccelerateInterpolator());
                animationY.start();
            }
        });

    }

}

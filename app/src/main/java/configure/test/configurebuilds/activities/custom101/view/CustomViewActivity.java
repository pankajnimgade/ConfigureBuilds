package configure.test.configurebuilds.activities.custom101.view;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import configure.test.configurebuilds.R;

public class CustomViewActivity extends AppCompatActivity {

    private static final String TAG = CustomViewActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void barChartAnimate(View view) {
        Log.d(TAG, "barChartAnimate: ");

        ValueAnimator mValueAnimator = new ValueAnimator();
        mValueAnimator.setDuration(500);
        mValueAnimator.setInterpolator(new AccelerateInterpolator());
        mValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener) findViewById(R.id.CustomViewActivity_BarChart));
        mValueAnimator.setFloatValues(0f, 1f);
        mValueAnimator.start();
    }
}

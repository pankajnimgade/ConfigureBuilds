package configure.test.configurebuilds.ui;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import configure.test.configurebuilds.R;


public class AndroidMeActivity extends AppCompatActivity {

    private FrameLayout bodyContainerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
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

        initializeUi();
    }

    private void initializeUi() {
        bodyContainerFrameLayout = findViewById(R.id.AndroidMeActivity_body_container_FrameLayout);

        BodyPartFragment bodyPartFragment = new BodyPartFragment();

        // Use FragmentManager and transaction to add the fragment to the screen
        FragmentManager fragmentManager = getFragmentManager();

        fragmentManager.beginTransaction().add(R.id.AndroidMeActivity_body_container_FrameLayout,
                bodyPartFragment).commit();

    }

}

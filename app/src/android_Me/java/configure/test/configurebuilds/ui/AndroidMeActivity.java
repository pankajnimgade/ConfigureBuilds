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
import configure.test.configurebuilds.data.AndroidImageAssets;


public class AndroidMeActivity extends AppCompatActivity {

    private FrameLayout headContainerFrameLayout;
    private FrameLayout bodyContainerFrameLayout;
    private FrameLayout legContainerFrameLayout;

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

        initializeUi(savedInstanceState);
    }

    private void initializeUi(Bundle savedInstanceState) {

        if (savedInstanceState == null){
            legContainerFrameLayout = findViewById(R.id.AndroidMeActivity_leg_container_FrameLayout);
            headContainerFrameLayout = findViewById(R.id.AndroidMeActivity_head_container_FrameLayout);
            bodyContainerFrameLayout = findViewById(R.id.AndroidMeActivity_body_container_FrameLayout);

            HeadPartFragment headPartFragment = new HeadPartFragment();
            BodyPartFragment bodyPartFragment = new BodyPartFragment();
            LegPartFragment legPartFragment = new LegPartFragment();

            // Use FragmentManager and transaction to add the fragment to the screen
            FragmentManager fragmentManager = getFragmentManager();

            // Add head part fragment to the activity
            headPartFragment.setmImageIds(AndroidImageAssets.getHeads());
            fragmentManager.beginTransaction().add(R.id.AndroidMeActivity_head_container_FrameLayout,
                    headPartFragment).commit();

            // Add body part fragment to the activity
            bodyPartFragment.setmImageIds(AndroidImageAssets.getBodies());
            fragmentManager.beginTransaction().add(R.id.AndroidMeActivity_body_container_FrameLayout,
                    bodyPartFragment).commit();

            // Add body part fragment to the activity
            legPartFragment.setmImageIds(AndroidImageAssets.getLegs());
            fragmentManager.beginTransaction().add(R.id.AndroidMeActivity_leg_container_FrameLayout,
                    legPartFragment).commit();
        }

    }

}

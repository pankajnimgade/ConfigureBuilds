package configure.test.configurebuilds.ui;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;

import configure.test.configurebuilds.R;
import configure.test.configurebuilds.data.AndroidImageAssets;

public class MasterListActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private static final String TAG = "MasterListActivity";

    private CoordinatorLayout rootCoordinatorLayout;

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    private boolean mTowPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_list);
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
        rootCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.root_CoordinatorLayout);

        if (findViewById(R.id.MasterListActivity_android_me_linear_layout) != null) {
            mTowPane = true;



            // create new body part fragments
            HeadPartFragment headPartFragment = new HeadPartFragment();
            BodyPartFragment bodyPartFragment = new BodyPartFragment();
            LegPartFragment legPartFragment = new LegPartFragment();

            // Use FragmentManager and transaction to add the fragment to the screen
            FragmentManager fragmentManager = getFragmentManager();

            // Add head part fragment to the activity
            headPartFragment.setmImageIds(AndroidImageAssets.getHeads());
            headPartFragment.setmListIndex(headIndex);
            fragmentManager.beginTransaction().add(R.id.MasterListActivity_head_container_FrameLayout,
                    headPartFragment).commit();

            // Add body part fragment to the activity
            bodyPartFragment.setmImageIds(AndroidImageAssets.getBodies());
            bodyPartFragment.setmListIndex(bodyIndex);
            fragmentManager.beginTransaction().add(R.id.MasterListActivity_body_container_FrameLayout,
                    bodyPartFragment).commit();

            // Add body part fragment to the activity
            legPartFragment.setmImageIds(AndroidImageAssets.getLegs());
            legPartFragment.setmListIndex(legIndex);
            fragmentManager.beginTransaction().add(R.id.MasterListActivity_leg_container_FrameLayout,
                    legPartFragment).commit();
        }
    }

    @Override
    public void onImageSelected(int position) {
        Snackbar.make(rootCoordinatorLayout, "selected position = " + position, Snackbar
                .LENGTH_SHORT).show();
        int bodyPartNumber = position / 12;

        int listIndex = position - (12 * bodyPartNumber);

        GridView gridView = findViewById(R.id.fragment_list_GridView);
        if (gridView != null) {
            gridView.setNumColumns(2);
        }

        if (mTowPane) {

            BodyPartFragment newBodyPartFragment = new BodyPartFragment();
            switch (bodyPartNumber) {
                case 0:
                    newBodyPartFragment.setmImageIds(AndroidImageAssets.getHeads());
                    newBodyPartFragment.setmListIndex(listIndex);
                    getFragmentManager().beginTransaction().add(
                            R.id.MasterListActivity_head_container_FrameLayout, newBodyPartFragment)
                            .commit();
                    break;
                case 1:
                    newBodyPartFragment.setmImageIds(AndroidImageAssets.getBodies());
                    newBodyPartFragment.setmListIndex(listIndex);
                    getFragmentManager().beginTransaction().add(
                            R.id.MasterListActivity_body_container_FrameLayout, newBodyPartFragment)
                            .commit();
                    break;
                case 2:
                    newBodyPartFragment.setmImageIds(AndroidImageAssets.getLegs());
                    newBodyPartFragment.setmListIndex(listIndex);
                    getFragmentManager().beginTransaction().add(
                            R.id.MasterListActivity_leg_container_FrameLayout, newBodyPartFragment)
                            .commit();
                    break;
            }
        } else {
            switch (bodyPartNumber) {
                case 0:
                    headIndex = listIndex;
                    break;
                case 1:
                    bodyIndex = listIndex;
                    break;
                case 2:
                    legIndex = listIndex;
                    break;
            }

            Bundle bundle = new Bundle();
            bundle.putInt("headIndex", headIndex);
            bundle.putInt("bodyIndex", bodyIndex);
            bundle.putInt("legIndex", legIndex);

            final Intent intent = new Intent(this, AndroidMeActivity.class);
            intent.putExtras(bundle);

            findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(intent);
                }
            });
        }
    }
}

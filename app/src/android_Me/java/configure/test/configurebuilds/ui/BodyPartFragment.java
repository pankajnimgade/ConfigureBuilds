package configure.test.configurebuilds.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import configure.test.configurebuilds.R;
import configure.test.configurebuilds.data.AndroidImageAssets;

public class BodyPartFragment extends Fragment {

    private ImageView bodyPartImageView;

    public BodyPartFragment() {
    }

    public static Fragment newInstance() {
        return new BodyPartFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_body_part, container, false);

        // Get a reference to ImageView in the fragment layout
        bodyPartImageView = (ImageView) view.findViewById(R.id.fragment_body_part_ImageView);

        // Set Image resource to display
        bodyPartImageView.setImageResource(AndroidImageAssets.getBodies().get(0));

        // Return the root view
        return view;
    }


}

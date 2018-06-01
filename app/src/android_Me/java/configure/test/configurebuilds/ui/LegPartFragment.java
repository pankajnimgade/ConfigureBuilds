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

public class LegPartFragment extends Fragment {

    private ImageView legImageView;

    public LegPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leg_part, container, false);

        legImageView = (ImageView) view.findViewById(R.id.fragment_leg_part_ImageView);

        legImageView.setImageResource(AndroidImageAssets.getLegs().get(0));

        return view;
    }
}

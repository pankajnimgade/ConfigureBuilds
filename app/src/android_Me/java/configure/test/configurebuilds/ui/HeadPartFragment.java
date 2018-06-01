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

public class HeadPartFragment extends Fragment {

    private ImageView headImageView;

    public HeadPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_head_part, container, false);

        headImageView = (ImageView) view.findViewById(R.id.fragment_head_part_ImageView);

        headImageView.setImageResource(AndroidImageAssets.getHeads().get(0));
        return view;
    }
}

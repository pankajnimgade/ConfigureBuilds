package configure.test.configurebuilds.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import configure.test.configurebuilds.R;
import configure.test.configurebuilds.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gridView = (GridView) view.findViewById(R.id.fragment_list_GridView);
        gridView.setAdapter(new MasterListAdapter(getActivity().getApplicationContext(), AndroidImageAssets.getAll()));
        return view;
    }
}

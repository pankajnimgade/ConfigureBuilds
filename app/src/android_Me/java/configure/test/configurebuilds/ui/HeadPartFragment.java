package configure.test.configurebuilds.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import configure.test.configurebuilds.R;
import configure.test.configurebuilds.data.AndroidImageAssets;

public class HeadPartFragment extends Fragment {

    private static final String TAG = "HeadPartFragment";

    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    private List<Integer> mImageIds;
    private int mListIndex;

    private ImageView headImageView;

    public HeadPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        View view = inflater.inflate(R.layout.fragment_head_part, container, false);

        headImageView = (ImageView) view.findViewById(R.id.fragment_head_part_ImageView);

        if (mImageIds != null) {
            headImageView.setImageResource(mImageIds.get(mListIndex));
            headImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListIndex < mImageIds.size() - 1) {
                        mListIndex++;
                    } else {
                        mListIndex = 0;
                    }
                    headImageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        } else {
            Log.d(TAG, "onCreateView: this fragment has null list of image ids");
            headImageView.setImageResource(AndroidImageAssets.getHeads().get(0));
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        outState.putInt(LIST_INDEX, mListIndex);
    }

    public List<Integer> getmImageIds() {
        return mImageIds;
    }

    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public int getmListIndex() {
        return mListIndex;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }
}

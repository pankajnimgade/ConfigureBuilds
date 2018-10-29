package custom.view.activities.test101;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;

import configure.test.configurebuilds.R;

public class MyTextView extends AppCompatTextView {

    public static final String TAG = MyTextView.class.getSimpleName();


    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "MyTextView: ");

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.MyTextView, 0, 0);

        try {
            int fontIndex = typedArray.getInteger(R.styleable.MyTextView_mono_font, 0);

            FontType fontType = FontType.values()[fontIndex];
            Typeface font = ResourcesCompat.getFont(getContext(), R.font.merriweather_light);
            switch (fontType) {
                case LIGHT:
                    font = ResourcesCompat.getFont(getContext(), R.font.merriweather_light);
                    break;
                case REGULAR:
                    font = ResourcesCompat.getFont(getContext(), R.font.merriweather_regular);
                    break;
                case BOLD:
                    font = ResourcesCompat.getFont(getContext(), R.font.merriweather_bold);
                    break;
            }

            setTypeface(font);
        } finally {
            typedArray.recycle();
        }

    }


    enum FontType {
        LIGHT, REGULAR, BOLD
    }

}

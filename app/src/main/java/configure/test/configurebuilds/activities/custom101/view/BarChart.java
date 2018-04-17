package configure.test.configurebuilds.activities.custom101.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class BarChart extends View {

    private static final String TAG = BarChart.class.getSimpleName();
    private int maxHeight = getHeight();
    private int maxWidth = getWidth();
    private float mPadding = 5f;
    
    public BarChart(Context context) {
        super(context);
    }

    public BarChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BarChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: ...");
        
    }
}

package configure.test.configurebuilds.activities.custom101.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class BarChart extends View {

    private static final String TAG = BarChart.class.getSimpleName();
    private int maxHeight = getHeight();
    private int maxWidth = getWidth();
    private float mPadding = 15f;
    private static Paint mAxisBlackPaint;
    private static Paint mGuilLineBlackPaint;

    static {
        mAxisBlackPaint = new Paint(Color.BLACK);
        mAxisBlackPaint.setFakeBoldText(true);
        mAxisBlackPaint.setStrokeWidth(3f);

        mGuilLineBlackPaint = new Paint(Color.BLACK);
        mGuilLineBlackPaint.setStrokeWidth(1f);
    }

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
        maxHeight = getHeight();
        maxWidth = getWidth();
        Log.d(TAG, "onDraw: maxHeight: " + getHeight());
        Log.d(TAG, "onDraw: maxWidth: " + getWidth());
        final float gridTop = mPadding;
        final float gridRight = maxWidth - mPadding;
        final float gridBottom = maxHeight - mPadding;
        final float gridLeft = mPadding;
        Log.d(TAG, "onDraw: gridTop: " + gridTop);
        Log.d(TAG, "onDraw: gridRight: " + gridRight);
        Log.d(TAG, "onDraw: gridBottom: " + gridBottom);
        Log.d(TAG, "onDraw: gridLeft: " + gridLeft);

        //draw charts x-axis
        canvas.drawLine(gridLeft, gridBottom, gridRight, gridBottom, mAxisBlackPaint);
        //draw charts y-axis
        canvas.drawLine(gridLeft, gridTop, gridLeft, gridBottom, mAxisBlackPaint);

        //draw guideLines
        float guideLineWidth = (gridBottom - gridTop) / 10f;
        for (int i = 0; i < 10; i++) {
            float yValue = gridTop + (i* guideLineWidth);
            canvas.drawLine(gridLeft, yValue, gridRight, yValue, mGuilLineBlackPaint);
        }


    }
}

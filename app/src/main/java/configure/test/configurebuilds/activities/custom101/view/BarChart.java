package configure.test.configurebuilds.activities.custom101.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class BarChart extends View {

    private static final String TAG = BarChart.class.getSimpleName();
    private int maxHeight = getHeight();
    private int maxWidth = getWidth();
    private float mPadding = 10f;
    private static Paint mAxisBlackPaint;
    private static Paint mGuideLineBlackPaint;
    private static Paint mBarChartPaint;
    private static final int barCount = 10;
    private static final float barSpacing = 10f;

    static {
        mAxisBlackPaint = new Paint();
        mAxisBlackPaint.setColor(Color.BLACK);
        mAxisBlackPaint.setFakeBoldText(true);
        mAxisBlackPaint.setStrokeWidth(3f);

        mGuideLineBlackPaint = new Paint(Color.BLACK);
        mGuideLineBlackPaint.setColor(Color.GRAY);
        mGuideLineBlackPaint.setStrokeWidth(1f);

        mBarChartPaint = new Paint(Color.GREEN);
        mBarChartPaint.setColor(Color.GREEN);
        mBarChartPaint.setStyle(Paint.Style.FILL);
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

        //draw right border of chart
        canvas.drawLine(gridRight, gridTop, gridRight, gridBottom, mGuideLineBlackPaint);

        //draw guideLines
        float guideLineWidth = (gridBottom - gridTop) / 10f;
        for (int i = 0; i < 10; i++) {
            float yValue = gridTop + (i * guideLineWidth);
            canvas.drawLine(gridLeft, yValue, gridRight, yValue, mGuideLineBlackPaint);
        }

        // draw bars in chart
        final float totalColumnSpacing = barSpacing * (barCount + 1);
        float columnWidth = (gridRight - gridLeft - totalColumnSpacing) / barCount;

        float columnLeft = gridLeft + barSpacing;
        float columnRight = columnLeft + columnWidth;

        for (int i = 0; i < barCount; i++) {
            float columnTop = (new Random().nextInt((int) gridBottom)) + gridTop + gridTop + gridTop;
            canvas.drawRect(columnLeft, columnTop, columnRight, gridBottom, mBarChartPaint);

            //
            columnLeft = columnRight+ barSpacing;
            columnRight = columnLeft + columnWidth;
        }


    }
}

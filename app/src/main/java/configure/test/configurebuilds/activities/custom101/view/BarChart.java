package configure.test.configurebuilds.activities.custom101.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class BarChart extends View implements ValueAnimator.AnimatorUpdateListener {

    private static final String TAG = BarChart.class.getSimpleName();
    private static Paint mAxisBlackPaint;
    private static Paint mGuideLineBlackPaint;
    private static Paint mBarChartPaint;
    private static final int barCount = 10;
    private static final float[] barPercentage = new float[barCount];
    private static final float barSpacing = 10f;
    private float mAnimationFraction = 0f;

    private static ValueAnimator mValueAnimator;


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

        for (int i = 0; i < barPercentage.length; i++) {
            barPercentage[i] = new Random().nextFloat();
        }
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
        int maxHeight = getHeight();
        int maxWidth = getWidth();
        Log.d(TAG, "onDraw: maxHeight: " + getHeight());
        Log.d(TAG, "onDraw: maxWidth: " + getWidth());
        float mPadding = 10f;
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
        float gridHeight = gridBottom - gridTop;

        // draw bars in chart
        final float totalColumnSpacing = barSpacing * (barCount + 1);
        float columnWidth = (gridRight - gridLeft - totalColumnSpacing) / barCount;

        float columnLeft = gridLeft + barSpacing;
        float columnRight = columnLeft + columnWidth;

        for (float percent : barPercentage) {

            float columnTop = ((1 - percent * mAnimationFraction) * gridHeight) + gridTop;
            canvas.drawRect(columnLeft, columnTop, columnRight, gridBottom, mBarChartPaint);

            //
            columnLeft = columnRight + barSpacing;
            columnRight = columnLeft + columnWidth;
        }


    }


    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        mAnimationFraction = animation.getAnimatedFraction();

        invalidate();
    }
}

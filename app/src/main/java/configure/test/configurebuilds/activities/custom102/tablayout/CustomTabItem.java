package configure.test.configurebuilds.activities.custom102.tablayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class CustomTabItem extends android.support.v7.widget.AppCompatTextView {

    public CustomTabItem(Context context) {
        super(context);
    }

    public CustomTabItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

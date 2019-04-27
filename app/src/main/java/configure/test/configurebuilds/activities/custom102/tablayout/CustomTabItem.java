package configure.test.configurebuilds.activities.custom102.tablayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class CustomTabItem extends AppCompatTextView {

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

package configure.test.configurebuilds.activities.edittext;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;

/**
 * Created by Pankaj Nimgade on 3/27/2018.
 */

public class TestCustomEditText extends AppCompatEditText implements TextWatcher {

    public TestCustomEditText(Context context) {
        super(context);
    }

    public TestCustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestCustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}

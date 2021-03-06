package configure.test.configurebuilds.activities.superscript;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import configure.test.configurebuilds.R;


public class SuperScriptActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_script);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initializeUi();
    }

    private void initializeUi() {
        textView1 = findViewById(R.id.SuperScriptActivity_textView1);
        textView2 = findViewById(R.id.SuperScriptActivity_textView2);
        textView3 = findViewById(R.id.SuperScriptActivity_textView3);
        textView4 = findViewById(R.id.SuperScriptActivity_textView4);
        textView5 = findViewById(R.id.SuperScriptActivity_textView5);
        textView6 = findViewById(R.id.SuperScriptActivity_textView6);
        textView7 = findViewById(R.id.SuperScriptActivity_textView7);
        textView8 = findViewById(R.id.SuperScriptActivity_textView8);


        testSuperScript101();
        testSuperScript102();
        testSuperScript103();
        testSuperScript104();
        testSuperScript105();
        testSuperScript106();
        testSuperScript107();
    }

    private void testSuperScript107() {
        String text = "Custom®";
        /*SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(.75f);
        spannableStringBuilder.setSpan(new SuperscriptSpan(), 6, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(relativeSizeSpan, 6, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView7.setText(spannableStringBuilder);*/

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(.75f);
        spannableStringBuilder.setSpan(new SuperscriptSpan(), text.indexOf("®"), text.indexOf
                ("®") + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(relativeSizeSpan, text.indexOf("®"), text.indexOf
                ("®") + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView7.setText(spannableStringBuilder);
    }

    private void testSuperScript106() {
        textView6.setText(Html.fromHtml("Citi\u00AE"));
    }

    private void testSuperScript105() {
        textView5.setText(Html.fromHtml("X\u00B2"));
    }

    private void testSuperScript104() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView4.setText(Html.fromHtml("X <sup>2</sup>", Html
                    .FROM_HTML_MODE_LEGACY));
        } else {
            textView4.setText(Html.fromHtml("X <sup>2</sup>"));
        }
    }

    private void testSuperScript103() {
        textView3.setText(Html.fromHtml("X <sup><small>2</small></sup>"));
    }

    private void testSuperScript102() {
        SpannableStringBuilder cs = new SpannableStringBuilder("X®1");
        cs.setSpan(new SuperscriptSpan(), 1, 2, 0);
//        cs.setSpan(new SuperscriptSpan(), 1, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        cs.setSpan(new SuperscriptSpan(), 1, 2, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//        cs.setSpan(new SuperscriptSpan(), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        cs.setSpan(new RelativeSizeSpan(0.70f), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView2.setText(cs);
    }

    private void testSuperScript101() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView1.setText(Html.fromHtml("X<sup><small>2</small></sup>", 0));
            textView1.invalidate();
        } else {
            textView1.setText(Html.fromHtml("X<sup><small>2</small></sup>"));
            textView1.invalidate();
        }
    }

}

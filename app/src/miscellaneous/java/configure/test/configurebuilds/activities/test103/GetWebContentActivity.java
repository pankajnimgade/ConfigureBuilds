package configure.test.configurebuilds.activities.test103;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import configure.test.configurebuilds.R;

/**
 * https://stackoverflow.com/questions/58043404/cant-download-web-page-content
 */
public class GetWebContentActivity extends AppCompatActivity {

    private static final String TAG = "GetWebContent";

    private TextView webContentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_web_content);
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webContentTextView = findViewById(R.id.web_content_text_view);
        (new GetWebContent()).execute("https://www.google.com/"); //argument is the website link

    }

    class GetWebContent extends AsyncTask<String, Void, String> {

        private String webContentResult = "Couldn't get web content";

        @Override
        protected String doInBackground(String... strings) {

            String urlOfTheWebsite = strings[0];

            try {
                URL url = new URL(urlOfTheWebsite);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = httpURLConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

                String tempText = null;
                StringBuilder stringBuilder = new StringBuilder();
                while ((tempText = bufferedReader.readLine()) != null) {
                    stringBuilder.append(tempText);
                }

                webContentResult = stringBuilder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return webContentResult;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d(TAG, "" + s); // you may log the web content like this
            //or
            webContentTextView.setText("" + s); // print this on UI
        }

    }
}

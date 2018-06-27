/*
 * Copyright 2018 Pankaj Nimgade
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package configure.test.configurebuilds.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import configure.test.configurebuilds.BuildConfig;
import configure.test.configurebuilds.R;

public class EmojifyMeActivity extends AppCompatActivity {

    private static final String TAG = "EmojifyMeActivity";

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_STORAGE_PERMISSION = 1;

    private static final String FILE_PROVIDER_AUTHORITY = BuildConfig.APPLICATION_ID + ".provider";

    @BindView(R.id.EmojifyMeActivity_root_CoordinatorLayout)
    CoordinatorLayout mRootCoordinatorLayout;

    @BindView(R.id.image_view)
    ImageView mImageView;

    @BindView(R.id.emojify_button)
    Button mEmojiButton;

    @BindView(R.id.share_button)
    FloatingActionButton mShareFab;

    @BindView(R.id.save_button)
    FloatingActionButton mSaveFab;

    @BindView(R.id.clear_button)
    FloatingActionButton mClearFab;

    @BindView(R.id.title_text_view)
    TextView mTitleTextView;

    private String mTempPhotoPath;

    private Bitmap mResultsBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emojify_me);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        initializeUi();
    }

    private void initializeUi() {

        mTitleTextView.setText("Butte Knife example");


    }

    public void GO(View view) {
        // Check for the external storage permission
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            // If you don't have permission, request it
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_STORAGE_PERMISSION);
        } else {
            launchCamera();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Called when you request permission to read and write to external storage
        switch (requestCode) {
            case REQUEST_STORAGE_PERMISSION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    launchCamera();
                } else {
                    Snackbar.make(mRootCoordinatorLayout, "Permission denied", Snackbar
                            .LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * Creates a temporary image file and captures a picture to store in it
     */
    private void launchCamera() {
        Log.d(TAG, "launchCamera: ");

        // Create the capture image intent
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //ensure there's a camera activity to handel the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // create temporary File where photo should go
            File photoFile = null;

            try {
                photoFile = BitmapUtils.createTempImageFile(this);
            } catch (Exception e) {
                // error occurred while creating a file
                e.printStackTrace();
            }

            // Continue only if the file was created successfully
            if (photoFile != null) {
                // Get the path for the temporary file
                mTempPhotoPath = photoFile.getAbsolutePath();

                // Get the content URI for the image file
                Uri photoUri = FileProvider.getUriForFile(this, FILE_PROVIDER_AUTHORITY, photoFile);

                // Add the URI so the camera can store the image
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);

                // Launch the camera activity
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // If the image capture activity was called and successful
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // Process and set the Image
            processAndSetImage();
        } else {
            // Otherwise delete the temporary image file
            BitmapUtils.deleteImageFile(this, mTempPhotoPath);
        }
    }

    private void processAndSetImage() {
        mEmojiButton.setVisibility(View.GONE);
        mTitleTextView.setVisibility(View.GONE);
        mSaveFab.setVisibility(View.VISIBLE);
        mShareFab.setVisibility(View.VISIBLE);
        mClearFab.setVisibility(View.VISIBLE);

        mResultsBitmap = BitmapUtils.resamplePic(this, mTempPhotoPath);

//        mImageView.setImageBitmap(mResultsBitmap);

//        Emojifier.detectFaces(this, mResultsBitmap);

        mImageView.setImageBitmap(Emojifier.detectFaces(this, mResultsBitmap));
    }

    public void saveMe(View view) {
        BitmapUtils.deleteImageFile(this, mTempPhotoPath);
        BitmapUtils.saveImage(this, mResultsBitmap);
    }

    public void shareMe(View view) {
        BitmapUtils.deleteImageFile(this, mTempPhotoPath);
        BitmapUtils.saveImage(this, mResultsBitmap);
        BitmapUtils.shareImage(this, mTempPhotoPath);
    }

    public void clearMe(View view) {

        mImageView.setImageResource(0);
        mEmojiButton.setVisibility(View.VISIBLE);
        mTitleTextView.setVisibility(View.VISIBLE);
        mShareFab.setVisibility(View.INVISIBLE);
        mClearFab.setVisibility(View.INVISIBLE);
        mSaveFab.setVisibility(View.INVISIBLE);

        BitmapUtils.deleteImageFile(this, mTempPhotoPath);

    }
}

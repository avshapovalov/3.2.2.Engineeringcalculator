package com.example.engineeringcalculator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Scanner;


public class OptionsActivity extends AppCompatActivity {
    private Button loadPicture;
    private EditText link;
    private ImageView mImageView;
    public static final String FOLDER_NAME = "Download";
    public static final String FILE_NAME = "1.png";
    public static final String LOG_TAG = "СМОТРИ СЮДА";
    public Writer writer;
    public File pictureFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customizing);

        link = findViewById(R.id.link);
        loadPicture = findViewById(R.id.loadPicture);
        mImageView = (ImageView) findViewById(R.id.imageView);
        link.setText("/storage/emulated/0/Download/default.png");
        loadPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mImageView.setImageURI(Uri.parse(link.getText().toString()));
               finish();
            }
        });
    }

    public File getPictureFile() {
        return new File(getPictureFolder(this, FOLDER_NAME), FILE_NAME);
    }

    public File getPictureFolder(Context context, String albumName) {
        File file = new File(context.getExternalFilesDir(
                Environment.DIRECTORY_DOWNLOADS), albumName);
        if (!file.mkdirs()) {
            Log.e(LOG_TAG, "Directory not created");
        }
        return file;
    }

}
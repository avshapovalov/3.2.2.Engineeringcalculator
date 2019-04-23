package com.example.engineeringcalculator;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.engineeringcalculator.MainActivity.mImageView;

public class OptionsActivity extends AppCompatActivity {
    private Button loadPicture;
    private EditText link;
    public String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customizing);

        link = findViewById(R.id.link);
        loadPicture = findViewById(R.id.loadPicture);

        path = Environment.getExternalStorageDirectory().toString() + "/Download/default.png";
        link.setText(path);
        loadPicture.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mImageView.setImageURI(Uri.parse(link.getText().toString()));
                finish();
            }
        });
    }
}
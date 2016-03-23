package com.anthony.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private Button editNameButton;
    private TextView displayNameTextView;
    public static final String NAME = "name";
    private Button openUrlButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();

    }


    private void setupViews() {
        editNameButton = (Button) findViewById(R.id.edit_name_button);
        displayNameTextView = (TextView) findViewById(R.id.display_name_textview);

        editNameButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Get the name in text view
                // pass it to next screen
                // launch the next screen
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String name = displayNameTextView.getText().toString();
                intent.putExtra(NAME, name);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        openUrlButton = (Button) findViewById(R.id.open_link_button);
        openUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.google.com"));

                startActivity(intent);
            }
        });
    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
                displayNameTextView.setText(data.getStringExtra(NAME));
            }
        }





}


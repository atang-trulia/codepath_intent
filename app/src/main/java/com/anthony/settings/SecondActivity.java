package com.anthony.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import static com.anthony.settings.MainActivity.NAME;

public class SecondActivity extends AppCompatActivity {

    private EditText nameEditText;
    private View submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setupView();
    }

    private void setupView() {
        nameEditText = (EditText) findViewById(R.id.name_edit_text);
        submitButton = findViewById(R.id.submit_button);

        String name = getIntent().getStringExtra(NAME);
        nameEditText.setText(name);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                Intent result = new Intent();
                result.putExtra(MainActivity.NAME, name);
                setResult(RESULT_OK, result);

                finish();
            }
        });

    }
}

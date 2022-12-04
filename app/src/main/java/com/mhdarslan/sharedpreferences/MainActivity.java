package com.mhdarslan.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button applyTextBtn;
    private Button saveBtn;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";

    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialization
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        applyTextBtn = findViewById(R.id.apply_textBtn);
        saveBtn = findViewById(R.id.saveBtn);

        // apply text on textview
        applyTextBtn.setOnClickListener(v -> {
            textView.setText(editText.getText().toString());
        });

        // save text into sharedPreferences
        saveBtn.setOnClickListener(v -> {
            saveDate();
        });

        // calling functions on startup
        loadDate();
        updateViews();
    }

    private void saveDate() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, textView.getText().toString());
        
        editor.apply();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    private void loadDate() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT,"");
    }
    private void updateViews() {
        textView.setText(text);
    }
}
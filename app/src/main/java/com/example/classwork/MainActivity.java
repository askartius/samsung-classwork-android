package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.classwork.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    final String SAVED_TEXT = "TEXT";
    final String SAVED_NUMBER = "NUMBER";
    private EditText editText, editNumber;
    private SharedPreferences sharedPreferences;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        editText = binding.editText;
        editNumber = binding.editNumber;
        Button saveButton = binding.save;
        Button loadButton = binding.load;

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });
    }

    void saveData() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SAVED_TEXT, editText.getText().toString());
        editor.putInt(SAVED_NUMBER, Integer.parseInt(editNumber.getText().toString()));
        editor.apply();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    void loadData() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        String savedText = sharedPreferences.getString(SAVED_TEXT, "");
        int savedNumber = sharedPreferences.getInt(SAVED_NUMBER, 0);
        editText.setText(savedText);
        editNumber.setText(Integer.toString(savedNumber));
        Toast.makeText(this, "Loaded", Toast.LENGTH_SHORT).show();
    }
}
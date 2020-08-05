package com.example.hw3_4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    String language;
    private static int marginTheme = R.style.AppTheme_MarginSmall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(marginTheme);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initLanguage();
        initMargin();
        Button okBtn = findViewById(R.id.okBtn);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale(language);
                Configuration configuration = new Configuration();
                configuration.setLocale(locale);
                getResources().updateConfiguration(configuration,
                        getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        });
    }

    private void initLanguage() {
        Spinner languageSpinner = findViewById(R.id.languageSpinner);

        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] languages = getResources().getStringArray(R.array.languages);
                language = languages[position];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void initMargin() {
        Spinner marginSpinner = findViewById(R.id.marginSpinner);

        ArrayAdapter<?> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.margins, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marginSpinner.setAdapter(arrayAdapter);

        marginSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        marginTheme = R.style.AppTheme_MarginSmall;
                        break;
                    case 1:
                        marginTheme = R.style.AppTheme_MarginMedium;
                        break;
                    case 2:
                        marginTheme = R.style.AppTheme_MarginLarge;
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
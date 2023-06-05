package com.example.holyquran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class SurahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);

        int selectedSurahIndex = getIntent().getIntExtra("EXTRA_SURAH_INDEX", 1);
        // QuranArabicText holyQuranText = new QuranArabicText();
        // String surahDetails = holyQuranText.QuranArabicText[1];

        TextView surahDetailsView = findViewById(R.id.surah_details_text_view);
        surahDetailsView.setText("Hello surah " + selectedSurahIndex);
        setTitle("SURAH DETAILS");
    }
}
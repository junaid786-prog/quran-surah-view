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

        String selectedSurahName = getIntent().getStringExtra("EXTRA_SURAH_NAME");
        int start_index = getIntent().getIntExtra("EXTRA_SURAH_START_INDEX", 0);
        int ayaCount = getIntent().getIntExtra("EXTRA_SURAH_AYAT_COUNT", 0);

        QuranArabicText holyQuranText = new QuranArabicText();
        String surahDetails = holyQuranText.QuranArabicText[0] + "\n\n";
        for (int i = 0; i < ayaCount - 1; i++){
            surahDetails += holyQuranText.QuranArabicText[i + start_index] + "\n";
        }

        TextView surahDetailsView = findViewById(R.id.surah_details_text_view);
        surahDetailsView.setText(surahDetails);
        setTitle("SURAH: " + selectedSurahName);
    }
}
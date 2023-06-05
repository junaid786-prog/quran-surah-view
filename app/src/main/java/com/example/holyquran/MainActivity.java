package com.example.holyquran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QDH holyQuran = new QDH();
        ListView surahListView = findViewById(R.id.all_surah_list);
        ArrayList<String> surahNames = new ArrayList<>();
        for (int i = 0; i < holyQuran.urduSurahNames.length; i++){
            System.out.println(i);
            surahNames.add(holyQuran.urduSurahNames[i]);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, surahNames);
        surahListView.setAdapter(adapter);

        surahListView.setOnItemClickListener(this::onItemClick);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        QDH holyQuran = new QDH();
        int selectedSurahIndex = position;

        int surahAyaCount = holyQuran.surahAyatCount[selectedSurahIndex];
        int surahStartIndex = holyQuran.SSP[position];

        Intent surahDetailIntent = new Intent(this, SurahActivity.class);
        surahDetailIntent.putExtra("EXTRA_SURAH_NAME", holyQuran.englishSurahNames[selectedSurahIndex]);
        surahDetailIntent.putExtra("EXTRA_SURAH_START_INDEX", surahStartIndex);
        surahDetailIntent.putExtra("EXTRA_SURAH_AYAT_COUNT", surahAyaCount);
        startActivity(surahDetailIntent);
    }
}

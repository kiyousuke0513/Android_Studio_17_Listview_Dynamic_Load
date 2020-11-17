package com.example.listview_dynamic_load;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    TextView textView_MSG;
    String[] item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        textView_MSG = findViewById(R.id.textView_MSG);

        textView_MSG.setText("請選擇項目");
        item = getResources().getStringArray(R.array.Item_List_Array);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listView_OnItemClickListener);
    }

    //listView點擊Event
    private final AdapterView.OnItemClickListener listView_OnItemClickListener = new AdapterView.OnItemClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            textView_MSG.setText("你選擇了: " + item[position]);
            new CountDownTimer(1000, 100) {
                public void onTick(long millisUntilFinished) {
                    //textView_MSG.setVisibility(View.VISIBLE);

                }

                public void onFinish() {
                    //textView_MSG.setVisibility(View.INVISIBLE);
                    textView_MSG.setText("請選擇項目");
                }
            }.start();
        }
    };
}
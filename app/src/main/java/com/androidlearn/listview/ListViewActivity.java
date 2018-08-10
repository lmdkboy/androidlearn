package com.androidlearn.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.androidlearn.summary.sumarry.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView lstView = findViewById(R.id.lv);
        List<String> lst = new ArrayList<String>();
        lst.add("----------------1-----------------");
        lst.add("----------------2-----------------");
        lst.add("----------------3-----------------");
        lst.add("----------------4-----------------");
        lst.add("----------------5-----------------");

        lstView.setAdapter(new Item(lst, this));
    }
}

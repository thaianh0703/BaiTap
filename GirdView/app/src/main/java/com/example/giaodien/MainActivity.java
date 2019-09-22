package com.example.giaodien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

//androi:numColumns so cot trong giao dien
//
public class MainActivity extends AppCompatActivity {
    String arr[] ={"1","2","3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView selection=(TextView)findViewById(R.id.tv_selectiom);
        final GridView gridView = (GridView)findViewById(R.id.gridView);
        ArrayAdapter<String>da=new ArrayAdapter<String >(this,android.R.layout.simple_list_item_single_choice,arr);
        gridView.setAdapter(da);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selection.setText(arr[i]);
            }
        });
    }
}

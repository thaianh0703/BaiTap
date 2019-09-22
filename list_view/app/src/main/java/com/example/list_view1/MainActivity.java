package com.example.list_view1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    String[] presidents; // tao 1 chuoi
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ListView lstView = getListView();
        lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lstView.setTextFilterEnabled(true);
        presidents = getResources().getStringArray(R.array.president_array);

        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,presidents));
}
   @Override
    public void onListItemClick(ListView parent, View v, int position, long id){
       Toast.makeText(this," You are select" + presidents[position],Toast.LENGTH_SHORT).show();
    }
    public void onClick(View view){
        ListView lstView = getListView();
        String itemSelect = "Select item: \n";
        for (int i=0;i<lstView.getCount();i++)//lstView.getCount dem so luong item
        {
            if(lstView.isItemChecked(i))//item thu i trung khop
            {
                itemSelect += lstView.getItemAtPosition(i)+ "\n";
            }
        }
        Toast.makeText(this,itemSelect,Toast.LENGTH_LONG).show(); //hien thi tren man hinh
    }
    }


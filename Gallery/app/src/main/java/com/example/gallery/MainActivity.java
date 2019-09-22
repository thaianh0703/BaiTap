package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add(R.drawable.mot);
        list.add(R.drawable.hai);
        list.add(R.drawable.ba);
        list.add(R.drawable.bon);
        list.add(R.drawable.nam);
        final ImageView imageView = (ImageView)findViewById(R.id.image_clb);
        Gallery gallery = (Gallery)findViewById(R.id.gallery_clb);
        MyAdapte adapte = new MyAdapte(list,MainActivity.this);

        gallery.setAdapter(adapte);
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setImageResource(list.get(i));
            }
        });
    }
}

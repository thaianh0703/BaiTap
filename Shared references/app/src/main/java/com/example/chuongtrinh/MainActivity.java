package com.example.chuongtrinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edtFilename = (EditText)findViewById(R.id.edt_file);
        final EditText edtContent = (EditText)findViewById(R.id.edt_thongtin);

        Button btnNhapmoi =  (Button)findViewById(R.id.btn_nhap);
        btnNhapmoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtFilename.setText("");
                edtContent.setText("");
            }
        });
        final ArrayList<String> filenamelist = new ArrayList<>();
        filenamelist.add("Hello");
        Spinner spinnerFilename = (Spinner)findViewById(R.id.spinner_filename);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_single_choice,filenamelist);
        spinnerFilename.setAdapter(adapter);
        spinnerFilename.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()// chon item can  chon trong  spinner
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                edtFilename.setText(filenamelist.get(i).toString());// chon ten file name de hien thong tin tren bang thong tin
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Button btnLuu = (Button)findViewById(R.id.btn_luu);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = edtFilename.getText().toString();
                /*filenamelist.add(filename);
                try{
                    FileOutputStream fout = openFileOutput(filename, MODE_PRIVATE); //FileOutStream luu du liệu từ nguồn ra file
                    fout.write(edtContent.getText().toString().getBytes());//luu thông ting vo bo nho trong
                    fout.close();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Lỗi lưu file", Toast.LENGTH_SHORT).show();
                }*/
                SharedPreferences pref = getApplicationContext().getSharedPreferences(filename,Context.MODE_PRIVATE);
                SharedPreferences.Editor  editor = pref.edit();
                editor.putString("content",edtContent.getText().toString());
                editor.commit();
                edtFilename.setText("");
                edtContent.setText("");
            }
        });
        Button btnMo = (Button)findViewById(R.id.btn_mo);
        btnMo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = edtFilename.getText().toString();
               /* StringBuffer buffer = new StringBuffer();
                String line = null;
                try{
                    FileInputStream fin = openFileInput(filename);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                    while ((line = br.readLine()) != null)
                        buffer.append(line).append("\n");
                    edtContent.setText(buffer.toString());
                } catch (Exception e) {
                }*/
                SharedPreferences pref = getApplicationContext().getSharedPreferences(filename,Context.MODE_PRIVATE);
                edtContent.setText(pref.getString("content",null));

            }
        });
    }
}

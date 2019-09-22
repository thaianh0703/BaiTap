package com.example.dailog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_kq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Message");
        dialog.setIcon(R.drawable.ic_launcher_background);
        dialog.setMessage("welcom to my");
        tv_kq = (TextView)findViewById(R.id.tv_ketqua);
        dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv_kq.setText("you choice yes");
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv_kq.setText("Ban chon No");
            }
        });
        final CharSequence [] item={"đỏ","vàng","cam"};
        dialog.setItems(item, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv_kq.setText(item[i].toString());
            }
        });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }
}

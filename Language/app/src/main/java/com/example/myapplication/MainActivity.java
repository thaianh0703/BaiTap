package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
// có 2 loại ngôn ngữ
    // 1 ngôn ngữ theo hệ thống không có chức năng chuyển đổi
    // 2 ngôn ngữ độc lập
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //loadLocal();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
        setContentView(R.layout.activity_main);
        Button btn_chang = (Button)findViewById(R.id.btn_chang_lang);
        btn_chang.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showChanglangueDialog();
            }
        });
    }
    private void showChanglangueDialog()
    {
        final String[] listItem = {"English","French","Vietnam"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose languege");
        builder.setSingleChoiceItems(listItem, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                switch (i)
            {
                case 0:{
                    setLocale("en");
                    recreate();
                    break;
                }
                case 1:{
                    setLocale("fr-rFR");
                    recreate();
                    break;
                }
                case 2:{
                  setLocale("vi");
                  recreate();
                  break;
                }
                default: dialogInterface.dismiss();
            }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void setLocale(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale= locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("setting",MODE_PRIVATE).edit();
        editor.putString("My_lang",lang);
        editor.apply();
    }
    public void loadLocal()
    {
        SharedPreferences pref = getSharedPreferences("setting", Activity.MODE_PRIVATE);
        String language = pref.getString("my lang","");
        setLocale(language);
    }
}

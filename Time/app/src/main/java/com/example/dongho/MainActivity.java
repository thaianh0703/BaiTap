package com.example.dongho;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doWork();
    }
    public  void doWork(){
        Button b1 = (Button)findViewById(R.id.bt_1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnalogClock analog = new AnalogClock(MainActivity.this);
                ((LinearLayout)findViewById(R.id.myLayout)).addView(analog);
            }
        });
        Button b2 = (Button)findViewById(R.id.bt_2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chronometer cro = new Chronometer(MainActivity.this);
                ((LinearLayout)findViewById(R.id.myLayout)).addView(cro);
            }
        });
        /*Button b3 = (Button)findViewById(R.id.bt_3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                TimePicker.OnTimeChangedListener callback = new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                        ((TextView)findViewById(R.id.tv_date)).setText(hour +":"+minute+"@@@" + view.getCurrentHour() + view.getCurrentMinute() );
                    }
                };
                TimePickerDialog time = new TimePickerDialog(MainActivity.this,callback,11,30,true);
                time.show();
            }
        });*/
        Button b4 = (Button)findViewById(R.id.bt_4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        ((TextView)findViewById(R.id.tv_date)).setText((day+1)+ "/"+ (month+1)+"/"+year);
                    }
                };
                DatePickerDialog pic = new DatePickerDialog(MainActivity.this,callback,2012,11,30);
                pic.setTitle("Ngay cua toi");
                pic.show();
            }
        });
    }
}

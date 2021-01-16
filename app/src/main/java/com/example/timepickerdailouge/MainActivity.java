package com.example.timepickerdailouge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView timeShowTextView;
    private TextView timeShowButton;
    private TimePickerDialog timePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeShowTextView = (TextView) findViewById(R.id.showTime);
        timeShowButton = (Button) findViewById(R.id.timeShowButton);
        timeShowButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.timeShowButton){
            TimePicker  timePicker= new  TimePicker(this);
            int currentMinite = timePicker.getCurrentMinute();
            int currtentHour = timePicker.getCurrentHour();

            timePickerDialog = new TimePickerDialog(this,

                new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hourOftheDay, int minuteOfTheDay) {
                    timeShowTextView.setText(hourOftheDay+":"+minuteOfTheDay);
                }
            },currentMinite,currtentHour,true);

            timePickerDialog.show();
        }
    }
}
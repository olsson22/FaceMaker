package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;
import android.view.SurfaceView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Face faceobj = findViewById(R.id.theSurfaceView);

        SeekBar seekBarRed = findViewById(R.id.seekBarRed);
        seekBarRed.setOnSeekBarChangeListener(faceobj);

        SeekBar seekBarGreen = findViewById(R.id.seekBarGreen);
        seekBarGreen.setOnSeekBarChangeListener(faceobj);

        SeekBar seekBarBlue = findViewById(R.id.seekBarBlue);
        seekBarBlue.setOnSeekBarChangeListener(faceobj);

        RadioGroup radiogroup = findViewById(R.id.radiogroup);

        radiogroup.setOnCheckedChangeListener(faceobj);
        Spinner spinner = findViewById(R.id.spinner2);
        //spinner.setOnItemSelectedListener(faceobj);

        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, faceobj.haircuts);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(faceobj);

        Button randomButton = findViewById(R.id.buttonRandom);
        randomButton.setOnClickListener(faceobj);





    }
}

package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;
import android.view.SurfaceView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
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
        RadioButton radioButtonSkin = findViewById(R.id.radioButtonSkin);



       // faceobj.setRadioButton(radioButtonSkin);


        faceobj.setSeekBars(seekBarRed, seekBarGreen, seekBarBlue);

        faceobj.setRadioGroup(radiogroup);
        radiogroup.check(R.id.radioButtonSkin);
        faceobj.updateSeekBars();






        /**
         * Date: 22 September 2019

         Problem: did not know how to use the Adapterview.OnSelectedItemListener

         Resource: https://developer.android.com/guide/topics/ui/controls/spinner

         Solution: I used the examples from this page
        * */


        Spinner spinner = findViewById(R.id.spinner2);

        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, faceobj.haircuts);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(faceobj);

        Button randomButton = findViewById(R.id.buttonRandom);
        randomButton.setOnClickListener(faceobj);





    }

}

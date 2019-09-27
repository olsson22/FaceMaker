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

/**
 * @author Fredrik Olsson
 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Face faceobj = findViewById(R.id.theSurfaceView);


        //Creates the Red Seekbar Object.
        SeekBar seekBarRed = findViewById(R.id.seekBarRed);

        //Sets on the listener for the Red Seekbar Object
        seekBarRed.setOnSeekBarChangeListener(faceobj);


        //Creates the Green Seekbar Object
        SeekBar seekBarGreen = findViewById(R.id.seekBarGreen);

        //Sets on the listener for the Green Seekbar object
        seekBarGreen.setOnSeekBarChangeListener(faceobj);


        //Creates the Blue Seekbar Object
        SeekBar seekBarBlue = findViewById(R.id.seekBarBlue);

        //Sets on the listener for the Blue SeekBar object
        seekBarBlue.setOnSeekBarChangeListener(faceobj);



        //Creates the Radiogroup object
        RadioGroup radiogroup = findViewById(R.id.radiogroup);

        //Sets on the listener for the Radiogroup object
        radiogroup.setOnCheckedChangeListener(faceobj);

        //Connects the Seekbars created in this class to the ones in the Face class
        faceobj.setSeekBars(seekBarRed, seekBarGreen, seekBarBlue);

        //Connects the Radiogroup created in this class to the one in the Face class
        faceobj.setRadioGroup(radiogroup);

        //Updates the seekBars before any of the Radiobuttons have been checked by a user
        faceobj.updateSeekBars();

        //Creates the Button Object
        Button randomButton = findViewById(R.id.buttonRandom);

        //Sets on the clicklistener for the Button object
        randomButton.setOnClickListener(faceobj);


        /**
         External Citation

             Date: 22 September 2019

             Problem: did not know how to use the Adapterview.OnSelectedItemListener

             Resource: https://developer.android.com/guide/topics/ui/controls/spinner

         Solution: I used the examples from this page
        * */

        //Creates the spinner object
        Spinner spinner = findViewById(R.id.spinner2);

        //Creates an arraylist where the different haircuts will be added in the Face Class
        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, faceobj.hairCuts);

        //Specifies the layout to use when the different options appear
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Connects the spinner created in this class, to the FaceClass
        faceobj.setSpinner(spinner);

        //Applies the Adapter to the spinner
        spinner.setAdapter(dataAdapter);

        //Sets on the listener for the Spinner object
        spinner.setOnItemSelectedListener(faceobj);







    }

}

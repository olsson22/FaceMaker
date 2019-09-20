package com.example.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Face extends SurfaceView implements RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, Spinner.OnItemSelectedListener {

        int red;
        int green;
        int blue;

        boolean skin;
        boolean hair;
        boolean eyes;



        Paint paintface = new Paint();
        Paint painthair = new Paint();
        Paint painteyes = new Paint();
        Paint paintnose = new Paint();
        Paint paintmouth = new Paint();

        int skinColor= android.graphics.Color.rgb(red,green,blue);
        int eyeColor;
        int hairColor;
        int hairStyle;
    List <String> haircuts = new ArrayList<>();

        public Face(Context context, AttributeSet attrs){
            super(context, attrs);
            haircuts.add("mohawk");
            haircuts.add("buzzccut");
            haircuts.add("other cut");
       /* this.skinColor=skinColor;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.hairStyle = hairStyle;*/
            setWillNotDraw(false);
        }


        public void onDraw(Canvas canvas){

        //paints the faceshape
        if(skin){
            skinColor = android.graphics.Color.rgb(red,green, blue);
        }
        paintface.setColor(skinColor);
        canvas.drawOval(700, 50, 1200, 700, paintface);

        //paints the eyes

        //sets the color and paints the white part of the eye
        painteyes.setColor(Color.WHITE);
        canvas.drawCircle(850,250,40,painteyes);
        canvas.drawCircle(1050,250,40,painteyes);
        //sets the color of the iris and paints it
            if(eyes){
                eyeColor = android.graphics.Color.rgb(red,green,blue);
            }
        painteyes.setColor(eyeColor);
        canvas.drawCircle(850, 250,20,painteyes);
        canvas.drawCircle(1050,250,20,painteyes);
       //sets the color of the black part of the eye and paints it
        painteyes.setColor(Color.BLACK);
        canvas.drawCircle(850, 250,10,painteyes);
        canvas.drawCircle(1050,250,10,painteyes);


        //sets the color for the lines representing the nose and then draws it

        paintnose.setColor(Color.BLACK);
        canvas.drawLine(950,350,900,450,paintnose);
        canvas.drawLine(900,450,950,450,paintnose);

        //sets the color of the lips and draws it

        paintmouth.setColor(Color.BLACK);
        canvas.drawOval(850, 550, 1050, 650, paintmouth);

        //sets the color of the hair and draws it
            if(hair){
                hairColor = android.graphics.Color.rgb(red,green,blue);
            }
            painthair.setColor(hairColor);
           // canvas.drawRect(900,30,1000,200,painthair);
            canvas.drawOval(800, 50,1100,150,painthair);






    }

        public void randomize(){
            Random rand = new Random();
            skinColor = rand.nextInt(255)+1;
            eyeColor = rand.nextInt(255)+1;
            hairColor=rand.nextInt(255)+1;
            hairStyle=rand.nextInt(3)+1;
        }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch(checkedId){
            case R.id.radioButtonEyes:
                Log.d("onCheckedChange", "this is now checked");
                //code for only manipulating eyecolor
                eyes=true;
                skin=false;
                hair=false;
                break;
            case R.id.radioButtonHair:
                hair = true;
                skin=false;
                eyes=false;
                //code for only changing haircolor
                break;
            case R.id.radioButtonSkin:
                skin =true;
                hair = false;
                eyes=false;//skinColor = android.graphics.Color.rgb(red,green,blue);
                //code for only changing skincolor
                break;
        }
        invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        switch(seekBar.getId()){
            case R.id.seekBarRed:
                red = progress;
                break;

            case R.id.seekBarGreen:
                green = progress;
                break;

            case R.id.seekBarBlue:
                blue = progress;
                break;

        }
        invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}



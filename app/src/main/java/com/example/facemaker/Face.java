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

public class Face extends SurfaceView implements RadioGroup.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener, Spinner.OnItemSelectedListener, View.OnClickListener {





        public int redhair;
        public int greenhair;
        public int bluehair;

        public int redeyes;
        public int greeneyes;
        public int blueeyes;

        public int redskin;
        public int greenskin;
        public int blueskin;

        public boolean skin;
        public boolean hair;
        public boolean eyes;



        Paint paintface = new Paint();
        Paint painthair = new Paint();
        Paint painteyes = new Paint();
        Paint paintnose = new Paint();
        Paint paintmouth = new Paint();

        int skinColor;
        int eyeColor;
        int hairColor;
        int hairStyle;
    List <Integer> haircuts = new ArrayList<>();

        public Face(Context context, AttributeSet attrs){
            super(context, attrs);
            randomize();
            haircuts.add(1);
            haircuts.add(2);
            haircuts.add(3);
            skin = true;
            eyes = true;
            hair = true;

            /* this.skinColor=skinColor;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.hairStyle = hairStyle;*/
            setWillNotDraw(false);
        }


        public void onDraw(Canvas canvas){

        //paints the faceshape
       // if(skin) {
            skinColor = android.graphics.Color.rgb(redskin, greenskin, blueskin);
        //}
        paintface.setColor(skinColor);
        canvas.drawOval(700, 50, 1200, 700, paintface);

        //paints the eyes

        //sets the color and paints the white part of the eye
        painteyes.setColor(Color.WHITE);
        canvas.drawCircle(850,250,40,painteyes);
        canvas.drawCircle(1050,250,40,painteyes);
        //sets the color of the iris and paints it
            //if(eyes){
                eyeColor = android.graphics.Color.rgb(redeyes,greeneyes,blueeyes);
            //}
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
            //if(hair){
                hairColor = android.graphics.Color.rgb(redhair,greenhair,bluehair);
            //}
            painthair.setColor(hairColor);
            switch(hairStyle) {
                case 1:  canvas.drawRect(900, 30, 1000, 200, painthair);
                break;
                case 2: canvas.drawOval(800, 50, 1100, 150, painthair);
                break;
                case 3: for(int i =1;i<170;i++){
                    canvas.drawLine(750 +2*i,180,850+2*i, 30,painthair);
                }



            }



    }

        public void randomize(){
          //  skin = true;
            //eyes = true;
            //hair = true;

            Random rand = new Random();
            redskin = rand.nextInt(255)+1;
            greenskin = rand.nextInt(255)+1;
            blueskin = rand.nextInt(255)+1;
            skinColor = android.graphics.Color.rgb(redskin,greenskin,blueskin);

            redeyes = rand.nextInt(255)+1;
            greeneyes = rand.nextInt(255)+1;
            blueeyes = rand.nextInt(255)+1;
            eyeColor = android.graphics.Color.rgb(redeyes,greeneyes,blueeyes);

            redhair = rand.nextInt(255)+1;
            greenhair = rand.nextInt(255)+1;
            bluehair = rand.nextInt(255)+1;
            hairColor=android.graphics.Color.rgb(redhair,greenhair,bluehair);


            hairStyle=rand.nextInt(3)+1;
            invalidate();
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
                
                invalidate();


                break;
            case R.id.radioButtonHair:
                hair = true;
                skin=false;
                eyes=false;
                invalidate();
                //code for only changing haircolor

                break;
            case R.id.radioButtonSkin:
                skin =true;
                hair = false;
                eyes=false;//skinColor = android.graphics.Color.rgb(red,green,blue);
                //code for only changing skincolor
                invalidate();
                break;
        }
       // invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {



            switch(seekBar.getId()){
                case R.id.seekBarRed:
                    if(skin){

                    redskin = progress;}
                    else if(eyes){

                        redeyes=progress;}
                    else if(hair){

                        redhair=progress;}

                break;

            case R.id.seekBarGreen:
                if(skin){
                    greenskin = progress;}
                else if(eyes){greeneyes=progress;}
                else if(hair){greenhair=progress;}


                break;

            case R.id.seekBarBlue:
                if(skin){
                    blueskin = progress;}
                else if(eyes){blueeyes=progress;}
                else if(hair){bluehair=progress;}


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
        hairStyle = (int) parent.getItemAtPosition(position);

        invalidate();
        }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        randomize();
        invalidate();
    }
}



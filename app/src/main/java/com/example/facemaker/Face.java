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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Fredrik Olsson
 *
 * This class represents a Face on a specific
 * Context and AttributeSet
 *
 *
 */


public class Face extends SurfaceView implements RadioGroup.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener, Spinner.OnItemSelectedListener, View.OnClickListener {





        public int redHair;
        public int greenHair;
        public int blueHair;

        public int redEyes;
        public int greenEyes;
        public int blueEyes;

        public int redSkin;
        public int greenSkin;
        public int blueSkin;

        public boolean skin;
        public boolean hair;
        public boolean eyes;
        //public boolean first;

        private SeekBar seekBarRed;
        private SeekBar seekBarGreen;
        private SeekBar seekBarBlue;

        private RadioGroup radioGroup;
        Spinner spinner;


        Paint paintFace = new Paint();
        Paint paintHair = new Paint();
        Paint paintEyes = new Paint();
        Paint paintNose = new Paint();
        Paint paintMouth = new Paint();

        int skinColor;
        int eyeColor;
        int hairColor;
        int hairStyle;
    List <Integer> hairCuts = new ArrayList<>();

    /**
     * When a user creates a Face the user must specify what Context and
     * what AttributeSet the Face should be created within.
     * @param context
     * @param attrs
     */

        public Face(Context context, AttributeSet attrs){
            super(context, attrs);
            randomize();
            hairCuts.add(1);
            hairCuts.add(2);
            hairCuts.add(3);
            setWillNotDraw(false);

        }

    /**
     * Paints the Face on the given Canvas
     * @param canvas the canvas on which the Face will be drawn
     */

        public void onDraw(Canvas canvas){


            /**
             External Citation

             Date: 21 September 2019

             Problem: did not know how to convert rgb values to a single int.

             Resource: https://stackoverflow.com/questions/18022364/how-to-convert-rgb-color-to-int-in-java

             Solution: I found the android.graphics.Color.rgb()-method from this page
             * */
            //paints the faceshape
        skinColor = android.graphics.Color.rgb(redSkin, greenSkin, blueSkin);

        paintFace.setColor(skinColor);
        canvas.drawOval(700, 50, 1200, 700, paintFace);

        //paints the eyes

        //sets the color and paints the white part of the eye
        paintEyes.setColor(Color.WHITE);
        canvas.drawCircle(850,250,40,paintEyes);
        canvas.drawCircle(1050,250,40,paintEyes);
        //sets the color of the iris and paints it

        eyeColor = android.graphics.Color.rgb(redEyes,greenEyes,blueEyes);

        paintEyes.setColor(eyeColor);
        canvas.drawCircle(850, 250,20,paintEyes);
        canvas.drawCircle(1050,250,20,paintEyes);

       //sets the color of the black part of the eye and paints it
        paintEyes.setColor(Color.BLACK);
        canvas.drawCircle(850, 250,10,paintEyes);
        canvas.drawCircle(1050,250,10,paintEyes);


        //sets the color for the lines representing the nose and then draws it

        paintNose.setColor(Color.BLACK);
        canvas.drawLine(950,350,900,450,paintNose);
        canvas.drawLine(900,450,950,450,paintNose);

        //sets the color of the lips and draws it

        paintMouth.setColor(Color.BLACK);
        canvas.drawOval(850, 550, 1050, 650, paintMouth);

        //sets the color of the hair and draws it
        hairColor = android.graphics.Color.rgb(redHair,greenHair,blueHair);
        paintHair.setColor(hairColor);
        paintHair.setStrokeWidth(2);
            switch(hairStyle) {
                case 1:  canvas.drawRect(900, 30, 1000, 200, paintHair);
                break;
                case 2: canvas.drawOval(800, 50, 1100, 150, paintHair);
                break;
                case 3: for(int i =1;i<170;i++){
                    canvas.drawLine(750 +2*i,180,850+2*i, 30,paintHair);
                }

            }

    }

    /**
     * Randomizes the skinColor, hairColor and eyeColor.
     * Depending on which radiobutton is clicked,
     * then applies these colors to that face attribute
     */
        public void randomize(){

            Random rand = new Random();
            redSkin = rand.nextInt(255);
            greenSkin = rand.nextInt(255);
            blueSkin = rand.nextInt(255);
            skinColor = android.graphics.Color.rgb(redSkin,greenSkin,blueSkin);

            redEyes = rand.nextInt(255);
            greenEyes = rand.nextInt(255);
            blueEyes = rand.nextInt(255);
            eyeColor = android.graphics.Color.rgb(redEyes,greenEyes,blueEyes);

            redHair = rand.nextInt(255);
            greenHair = rand.nextInt(255);
            blueHair = rand.nextInt(255);
            hairColor=android.graphics.Color.rgb(redHair,greenHair,blueHair);


            hairStyle=rand.nextInt(3)+1;

            if(skin){
                seekBarRed.setProgress(redSkin);
                seekBarGreen.setProgress(greenSkin);
                seekBarBlue.setProgress(blueSkin);
            }
            else if(eyes){
                seekBarRed.setProgress(redEyes);
                seekBarGreen.setProgress(greenEyes);
                seekBarBlue.setProgress(blueEyes);
            }
            else if(hair){
                seekBarRed.setProgress(redHair);
                seekBarGreen.setProgress(greenHair);
                seekBarBlue.setProgress(blueHair);
            }

            invalidate();
        }

    /**
     * Connects the SeekBar-objects in the MainActivity-class
     * so these objects can be called from the Face-class
     *
     * @param seekBarRed The SeekBar which controls how much red
     *                   should be shown.
     * @param seekBarGreen The SeekBar which controls how much Green
     *      *              should be shown.
     * @param seekBarBlue The SeekBar which controls how much Blue
     *      *              should be shown
     */
        public void setSeekBars(SeekBar seekBarRed,SeekBar seekBarGreen,SeekBar seekBarBlue){
            this.seekBarRed=seekBarRed;
            this.seekBarGreen = seekBarGreen;
            this.seekBarBlue = seekBarBlue;
        }

    /**
     * Connects the RadioGroup-object in the MainActivity-class
     * so this object can be called from the Face-class.
     *
     * @param radioGroup The RadioGroup which controls what attribute
     *                   of the face that should change color.
     */
        public void setRadioGroup(RadioGroup radioGroup){
            this.radioGroup=radioGroup;
            skin = true;
        }

    /**
     * This method sets the seekBars values before any clicking
     * on the radiobuttons has occured
     */
        public void updateSeekBars(){
            seekBarRed.setProgress(redSkin);
            seekBarGreen.setProgress(greenSkin);
            seekBarBlue.setProgress(blueSkin);
}


    /**
     * Listens continuously to see if a click-event happens of one
     * of the radiobuttons. If that happens, the values of the seekbars
     * are changed to match the values of the clicked attribute.
     *
     * @param radioGroup not used
     * @param checkedId the int ID connected to the clicked button
     */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        /**
         External Citation

         Date: 23 September 2019

         Problem: did not know what interface to use for the radiogroup

         Resource: https://developer.android.com/reference/android/widget/RadioGroup

         Solution: I found the interface from this page
         * */

        switch(checkedId){
            case R.id.radioButtonEyes:
                Log.d("onCheckedChange", "this is now checked");
                //Only manipulating eyecolor
                eyes=true;
                skin=false;
                hair=false;
                seekBarRed.setProgress(redEyes);
                seekBarGreen.setProgress(greenEyes);
                seekBarBlue.setProgress(blueEyes);
                invalidate();
                break;
            case R.id.radioButtonHair:
                //Only manipulating haircolor
                hair = true;
                skin=false;
                eyes=false;
                seekBarRed.setProgress(redHair);
                seekBarGreen.setProgress(greenHair);
                seekBarBlue.setProgress(blueHair);
                invalidate();
                break;
            case R.id.radioButtonSkin:
                //Only manipulating skincolor
                skin =true;
                hair = false;
                eyes=false;
                seekBarRed.setProgress(redSkin);
                seekBarGreen.setProgress(greenSkin);
                seekBarBlue.setProgress(blueSkin);
                invalidate();
                break;
        }

    }

    /**
     * Listens to any change in value on a seekbar.
     * If so, sets that attribute to the value that
     * the seekbar was changed to.
     *
     * @param seekBar The Seekbar that was changed.
     * @param progress The value that the seekbar was set to.
     * @param b not used parameter
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

            switch(seekBar.getId()){
                case R.id.seekBarRed:
                    if(skin){
                    redSkin = progress;
                    }
                    else if(eyes){
                        redEyes=progress;
                    }
                    else if(hair){
                        redHair=progress;
                    }
                break;

            case R.id.seekBarGreen:
                if(skin){
                    greenSkin = progress;
                }
                else if(eyes){
                    greenEyes=progress;
                }
                else if(hair){
                    greenHair=progress;
                }
                break;

            case R.id.seekBarBlue:
                if(skin){
                    blueSkin = progress;
                }
                else if(eyes){
                    blueEyes=progress;
                }
                else if(hair){
                    blueHair=progress;
                }
                break;

        }
        invalidate();
    }

    /**
     * unused method from interface SeekBar.OnSeekBarChangeListener.
     * @param seekBar not used
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    /**
     * unused method from interface SeekBar.OnSeekBarChangeListener.
     * @param seekBar
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    /**
     * Listens to find if any item on the spinner is selected.
     * If so, the hairstyle is changed to the hairstyle selected on the spinner.
     *
     * @param parent The ArrayList with the options displayed on the spinner.
     *
     * @param view not used.
     *
     * @param position retrieves the value at the given position.
     * @param id not used.
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        /**
         External Citation

         Date: 22 September 2019

         Problem: did not know how to use the Adapterview.OnSelectedItemListener

         Resource: https://developer.android.com/guide/topics/ui/controls/spinner

         Solution: I used the examples from this page
         * */
        hairStyle = (int) parent.getItemAtPosition(position);
        invalidate();
        }


    /**
     * unused method from interface Spinner.OnItemSelectedListener.
     *
     * @param adapterView
     */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /**
     * Connects the Spinner in the MainActivity to this Class
     * @param spinner the spinner that should be connected
     */
    public void setSpinner(Spinner spinner){
        this.spinner = spinner;
    }
    /**
     * Listens to find if any clickevent is recognized on the button
     * If so, calls the randomize-method.
     * @param view not used
     */
    @Override
    public void onClick(View view) {
        randomize();
        spinner.setSelection(hairStyle-1);
        invalidate();
    }
}



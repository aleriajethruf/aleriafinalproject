package com.mlabs.bbm.firstandroidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import android.widget.TextView;

/**
 * Created by androidstudio on 10/09/16.
 */
public class blankAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blank);

        final ImageView img;


        img = (ImageView)findViewById(R.id.imageView);


        img.setOnTouchListener(new View.OnTouchListener() {
            float dx;
            float dy;
            float x1;
            float y1;
            float x2;
            float y2;
            String initialD="";
            String FinalD="";
            String Quadrant="";

            @Override
            public boolean onTouch(View v, MotionEvent e) {
                TextView AlignX = (TextView) findViewById(R.id.textview20);
                TextView AlignY = (TextView) findViewById(R.id.textView2);
                TextView output1 = (TextView) findViewById(R.id.textView3);
                TextView output2 = (TextView) findViewById(R.id.textView4);
                TextView output3 = (TextView) findViewById(R.id.textView5);
                TextView output4 = (TextView) findViewById(R.id.textView6);



                switch (e.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx=e.getX();
                        dy=e.getY();
                        AlignX.setText(" ");

                        AlignY.setText(" ");
                        output1.setText(" ");
                        output2.setText(" ");
                        output3.setText(" ");
                        output4.setText(" ");


                        return true;


                    case MotionEvent.ACTION_UP:
                        x1=e.getX();
                        y1=e.getY();
                        if (dx<x1){

                            initialD = "Left To Right";

                        }else{
                            initialD="Right To Left";
                        }
                        if (dy<y1){

                            FinalD = "Top to Bottom";

                        }else
                        {
                            FinalD="Bottom to Top";
                        }
                        if (x1>(img.getMeasuredWidth()/2)  && y1>(img.getMeasuredHeight()/2)){
                            Quadrant="Quadrant 4";
                        }
                        else if(x1<(img.getMeasuredWidth()/2) && y1>(img.getMeasuredHeight()/2)){
                            Quadrant="Quadrant 3";
                        }
                        else if(x1>(img.getMeasuredWidth()/2) && y1<(img.getMeasuredHeight()/2)){
                            Quadrant="Quadrant 1";
                        }
                        else if(x1<(img.getMeasuredWidth()/2) && y1<(img.getMeasuredHeight()/2)){
                            Quadrant="Quadrant 2";
                        }
                        if (x1==(img.getMeasuredWidth()/2) || y1==(img.getMeasuredHeight()/2)){
                            Quadrant="No Quadrant";
                        }
                        if(dx>x1){
                            x2= dx-x1;
                        }
                        else if(dx<x1){
                            x2=x1-dx;
                        }
                        if(dy>y1){
                            y2= dy-y1;
                        }
                        else if(dy<y1){
                            y2=y1-dy;
                        }
                        if (dx==x1){
                            x2=0;
                        }
                        if (dy==y1){
                            y2=0;
                        }
                        if(x2 < 20 && y2 <20){
                            initialD="No swipe from left or right";
                            FinalD="No swipe from top or bottom";

                        }

                        AlignX.setText("x1="+dx+" to x2="+x1);

                        AlignY.setText("y1="+dy+" to y2="+y1);
                        output1.setText("Difference of dx= "+(x2));
                        output2.setText("Difference of dy= "+(y2));
                        output3.setText("Direction = "+initialD +" and "+ FinalD );
                        output4.setText("Quadrant: "+ Quadrant );

                }
                return  false;
            }

        });


    }

}

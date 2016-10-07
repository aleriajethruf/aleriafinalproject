package com.mlabs.bbm.firstandroidapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.regex.Pattern;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText EmailInput;
    EditText PassInput;
    Button BtnLogin;
    Button BtnShow;
    TextView BtnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmailInput = (EditText) findViewById(R.id.editText);
        PassInput = (EditText) findViewById(R.id.editText2);
        BtnLogin = (Button) findViewById(R.id.button);
        BtnShow = (Button) findViewById(R.id.show);
        BtnSignUp = (TextView) findViewById(R.id.button2);




        BtnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                AccountRepo repo = new AccountRepo(getApplicationContext());
                boolean res = false;
                res = repo.validateLogin(EmailInput.getText().toString(), PassInput.getText().toString());
                if(res == true){

                    finish();
                    Intent intent = new Intent(MainActivity.this, blankAct.class);
                    startActivity(intent);}
                else  {

                    Toast.makeText(getBaseContext(), "Username/EmailInput or password is incorrect.",Toast.LENGTH_SHORT).show();
                }

            }
        }
        );

        BtnShow.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionevent) {

                final int cursor = PassInput.getSelectionStart();

                int event = motionevent.getAction();

                switch (motionevent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("login","ACTION_DOWN");
                        PassInput.setTransformationMethod(null);
                        PassInput.setSelection(cursor);
                        break;

                    case MotionEvent.ACTION_UP:
                        Log.d("login","ACTION_UP");
                        PassInput.setTransformationMethod(new PasswordTransformationMethod());
                        PassInput.setSelection(cursor);
                        break;
                }
                return true;
            }
        });




        BtnSignUp.setOnClickListener(new OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          Intent intent = new Intent(MainActivity.this, signup.class);
                                          startActivity(intent);
                                          EmailInput.setText("");
                                          PassInput.setText("");
                                      }


                                  }
        );
    }


}


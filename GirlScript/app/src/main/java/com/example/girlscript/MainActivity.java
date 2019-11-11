package com.example.girlscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener{


    Boolean signUpModeActive = true;
    TextView changeSignupModeTextView;
    EditText passwordEditText;

    public void showUserList(){

        Intent intent = new Intent(getApplicationContext(), activity_user_list.class);
        startActivity(intent);

    }



    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.changeSignupModeTextView){
            Log.i("AppInfo", "Change Signup Mode");
            Button signupButton = (Button) findViewById(R.id.signupButton);

            if(signUpModeActive == true){

                signUpModeActive = false;
                signupButton.setText("Login");
                changeSignupModeTextView.setText("Or, Signup");
            } else{

                signUpModeActive = true;
                signupButton.setText("Signup");
                changeSignupModeTextView.setText("Or, Login");
            }

        }else if(view.getId()==R.id.backgroundLinearLayout || view.getId()==R.id.logoImageView){
            InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Gec Talks");

        changeSignupModeTextView= (TextView) findViewById(R.id.changeSignupModeTextView);
        changeSignupModeTextView.setOnClickListener(this);


        LinearLayout backgroundLinearLayout = (LinearLayout) findViewById(R.id.backgroundLinearLayout);
        ImageView logoImageView = (ImageView) findViewById(R.id.logoImageView);

        backgroundLinearLayout.setOnClickListener(this);
        logoImageView.setOnClickListener(this);





        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        passwordEditText.setOnKeyListener(this);
    }

}

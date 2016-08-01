package com.example.shikt.safetyapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by shikt on 31-07-2016.
 */
public class message extends FragmentActivity implements View.OnClickListener {
    Button save;
    EditText ms;
    @Override
    public  void onCreate(Bundle savedInstancestate){
        super.onCreate(savedInstancestate);
        setContentView(R.layout.message);
        save=(Button)findViewById(R.id.save);
        save.setOnClickListener(this);
        ms=(EditText)findViewById(R.id.ed);
    }


    @Override
    public void onClick(View v) {
        String msg=ms.getText().toString();

    }
}

package com.jhonatasrm.example_dialogfragment_communication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ExitDialog.ExitListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ExitDialog exitDialog = new ExitDialog();
        exitDialog.show(getSupportFragmentManager(), "exitDialog");
    }

    @Override
    public void onExit() {
        finish();
    }
}

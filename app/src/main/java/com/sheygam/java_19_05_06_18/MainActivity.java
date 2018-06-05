package com.sheygam.java_19_05_06_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements IMainView, View.OnClickListener {

    @InjectPresenter
    MainPresenter presenter;

    private TextView resTxt;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resTxt = findViewById(R.id.resTxt);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void changeText(String text) {
        resTxt.setText(text);
    }

    @Override
    public void disableBtn() {
        button.setEnabled(false);
    }

    @Override
    public void enableBtn() {
        button.setEnabled(true);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button){
            presenter.onStart();
        }
    }
}

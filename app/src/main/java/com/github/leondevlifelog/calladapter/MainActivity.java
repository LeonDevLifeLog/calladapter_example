package com.github.leondevlifelog.calladapter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.leondevlifelog.calladapter.network.Api;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        Api.getInstance().get().observe(this, stringResultWrapper -> {
            if (stringResultWrapper.isSuccess()) {
                textView.setText(stringResultWrapper.getResult());
            } else {
                textView.setText("出错");
            }
        });
    }
}

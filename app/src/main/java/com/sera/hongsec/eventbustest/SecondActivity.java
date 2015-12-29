package com.sera.hongsec.eventbustest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import de.greenrobot.event.EventBus;

/**
 * Created by seojk on 2015-12-30.
 */
public class SecondActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data data=new Data();
                data.msg="lalla";
                EventBus.getDefault().post(data);
            }
        });
    }
}

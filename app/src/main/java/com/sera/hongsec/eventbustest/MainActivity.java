package com.sera.hongsec.eventbustest;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EventBus.getDefault().register(this);
        Log.e("test", "onCreate");
        textView=(TextView)findViewById(R.id.textView);

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        Log.e("test", "onPostCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("test", "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e("test", "onResume");
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.e("test", "onPostResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("test", "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.e("test", "onStop");
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        Log.e("test", "onDestroy");
        super.onDestroy();
    }

    //SHUNXU RUXIA
    public void onEvent(Data data){
        Log.e("test", "onEvent:" + data.msg);
    }
    public void onEventMainThread(Data data){
        Log.e("test","onEventMainThread:"+ data.msg);
        textView.setText(data.msg);
    }

    public void onEventBackgroundThread(Data data){
        Log.e("test", "onEventBackgroundThread:" + data.msg);
    }
    public void onEventAsync(Data data){
        Log.e("test", "onEventAsync：" + data.msg);
    }

    public void floatingbutton(View v){
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

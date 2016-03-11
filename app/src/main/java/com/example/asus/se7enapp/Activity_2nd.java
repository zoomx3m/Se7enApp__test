package com.example.asus.se7enapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Activity_2nd extends AppCompatActivity {
    public TextView tv_head;
    public TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2nd);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_head = (TextView) findViewById(R.id.textView1);
        tv_text = (TextView) findViewById(R.id.text1);

        Intent intent = getIntent();

        tv_head.setText(intent.getStringExtra(Constant.HEADLINE_KEY));
        tv_text.setText(intent.getStringExtra(Constant.CONTENT_KEY));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}

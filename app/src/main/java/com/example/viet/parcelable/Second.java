package com.example.viet.parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import java.util.ArrayList;

public class Second extends AppCompatActivity {

    meta metaA;
    String name;
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txt = (EditText) findViewById(R.id.editText);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            name(extras);
        }
    }

    public void name(Bundle extras) {
        txt.setText(extras.getString("NAME"));
    }

    public void onBackPressed() {

        name = txt.getText().toString();
        metaA = new meta(name);
        Intent resultIntent = new Intent();
        ArrayList<meta> dataList = new ArrayList<>();
        dataList.add(metaA);
        resultIntent.putParcelableArrayListExtra("DATA", dataList);
        setResult(RESULT_OK, resultIntent);
        super.onBackPressed();
    }
}

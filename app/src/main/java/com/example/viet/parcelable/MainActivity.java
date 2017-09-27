package com.example.viet.parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String name;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.textView);
        name = "Initialised data";
        txt.setText(name);
    }

    @Override
    protected void onResume() {
        super.onResume();
        name = txt.getText().toString();
        txt.setText(name);
    }

    public void changeActivity(View view) {
        Intent intent = new Intent(MainActivity.this, Second.class);
        intent.putExtra("NAME", name);
        startActivityForResult(intent, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                ArrayList<meta> metaData = intent.getParcelableArrayListExtra("DATA");
                meta parcelEnvelop = metaData.get(0);
                txt.setText(parcelEnvelop.toString());
            }
        }
    }

}

package com.example.nawaf.myapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ActivityDesign extends AppCompatActivity {

    public void initials(){

        TextView t1= (TextView) findViewById(R.id.nbs_txt);
        TextView t2= (TextView) findViewById(R.id.fam_txt);
        TextView t3= (TextView) findViewById(R.id.clrs_txt);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDesign.this,Numbers.class);
                startActivity(intent);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDesign.this,Family.class);
                startActivity(intent);
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDesign.this,Colors.class);
                startActivity(intent);
            }
        });

        // -------------

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initials();

    }
}

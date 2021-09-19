package com.example.sargamdesign.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sargamdesign.R;

public class Stiching extends AppCompatActivity {

    ImageView Item_Image;
    TextView Item_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stiching);

        Item_Image=findViewById(R.id.grstichkurtha);
        Item_name=findViewById(R.id.churidar);

        Item_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String s1=Item_name.getText().toString();

                Intent intent = new Intent(Stiching.this,Measurement.class);
                intent.putExtra("item_name", s1);
                startActivity(intent);

            }
        });
    }
}

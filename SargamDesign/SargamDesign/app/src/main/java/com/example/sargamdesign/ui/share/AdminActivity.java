package com.example.sargamdesign.ui.share;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sargamdesign.R;

public class AdminActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


    }

    public void select_category(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(AdminActivity.this);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(view.getContext()).inflate(R.layout.product_category, viewGroup, false);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();



    }
    public void add_fashion(View view){
        Intent intent=new Intent(AdminActivity.this,AddProductActivity.class);
        startActivity(intent);



    }


    public void selectNotificaton(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AdminActivity.this);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(view.getContext()).inflate(R.layout.notification_alertbox, viewGroup, false);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void fashion_notification(View view) {
        Intent intent = new Intent(AdminActivity.this,FashionNotificationActivity.class);
        startActivity(intent);

    }

}

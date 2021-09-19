package com.example.sargamdesign.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sargamdesign.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OrderSummary extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener{

    Spinner SpinnerState;
    String[] State = {"Kerala","Tamilnadu","Karnadaka","Maharastra","Goa"};
    TextView StateName;

    DatabaseReference reference;
    OrderUpload upload;

    long maxid=0;

    EditText CustomerName;
    EditText CustomerEmail;
    EditText CustomerPhone;
    EditText CustomerCity;
    EditText Customeraddress;
    EditText CustomerPinCode;
    EditText CustomerLandMark;
    EditText Customerdistrict;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        final TextView Measurment=findViewById(R.id.measurment_name);
        final TextView Measurment_Count=findViewById(R.id.measurment_count);
        TextView Measurment_Design_Price=findViewById(R.id.measurment_desing_price);
        final TextView Measurment_Total_Price=findViewById(R.id.measurment_total_price);
        final TextView Measurment_Color=findViewById(R.id.measurment_color);
        final TextView Measurment_Size=findViewById(R.id.measurment_size);
        final TextView Measurment_Material=findViewById(R.id.measurment_material);
        TextView Measurment_Material_price=findViewById(R.id.bill_material_price);
        TextView Measurment_Stiching_Price=findViewById(R.id.stitching_price);

        Bundle bundle=getIntent().getExtras();
        String name = bundle.getString("mc_name");
        Measurment.setText("Category :"+name);

        Bundle bundle1=getIntent().getExtras();
        String name1 = bundle1.getString("count");
        Measurment_Count.setText("Qty "+name1);

        Bundle bundle2=getIntent().getExtras();
        String name2 = bundle2.getString("d_price");
        Measurment_Design_Price.setText(name2);

        Bundle bundle3=getIntent().getExtras();
        String name3 = bundle3.getString("total");
        Measurment_Total_Price.setText("Rs: "+name3);

        Bundle bundle4=getIntent().getExtras();
        String name4 = bundle4.getString("color");
        Measurment_Color.setText("Color: "+name4);

        Bundle bundle5=getIntent().getExtras();
        String name5 = bundle5.getString("mc_category");
        Measurment_Size.setText("Size: "+name5);

        Bundle bundle6=getIntent().getExtras();
        String name6 = bundle6.getString("mc_material");
        Measurment_Material.setText("Material: "+name6);

        Bundle bundle7=getIntent().getExtras();
        String name7 = bundle7.getString("stich_price");
        Measurment_Stiching_Price.setText(name7);

        Bundle bundle8=getIntent().getExtras();
        String name8 = bundle8.getString("m_price");
        Measurment_Material_price.setText(name8);

        StateName=(TextView)findViewById(R.id.state_name);
        SpinnerState=findViewById(R.id.state_spinner);

        SpinnerState.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,State);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        SpinnerState.setAdapter(arrayAdapter);


        CustomerName=(EditText) findViewById(R.id.bayer_name);
        CustomerEmail=(EditText) findViewById(R.id.bayer_email);
        CustomerPhone=(EditText) findViewById(R.id.bayer_phone);
        CustomerCity=(EditText) findViewById(R.id.bayer_city);
        Customeraddress=(EditText) findViewById(R.id.bayer_address);
        Customerdistrict=(EditText) findViewById(R.id.bayer_district);
        CustomerPinCode=(EditText) findViewById(R.id.bayer_pinCode);
        CustomerLandMark=(EditText) findViewById(R.id.bayer_landMark);

        Button SubmitStitching=findViewById(R.id.submit_stitching_order);

        upload=new OrderUpload();
        reference= FirebaseDatabase.getInstance().getReference().child("StitchingOrder");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists())
                    maxid= (int) dataSnapshot.getChildrenCount();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        SubmitStitching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upload.setCategory(Measurment.getText().toString());
                upload.setColor(Measurment_Color.getText().toString());
                upload.setSize(Measurment_Size.getText().toString());
                upload.setMaterial(Measurment_Material.getText().toString());
                upload.setQty(Measurment_Count.getText().toString());

                upload.setCdts(Customerdistrict.getText().toString());
                upload.setCstate(StateName.getText().toString());
                upload.setCrname(CustomerName.getText().toString());
                upload.setCremail(CustomerEmail.getText().toString());
                upload.setCrphone(CustomerPhone.getText().toString());
                upload.setCrcity(CustomerCity.getText().toString());
                upload.setCraddress(Customeraddress.getText().toString());
                upload.setCrpin(CustomerPinCode.getText().toString());
                upload.setCrlandmark(CustomerLandMark.getText().toString());

                upload.setAmount(Measurment_Total_Price.getText().toString());
                upload.setID(String.valueOf(maxid+1));

                reference.child(String.valueOf(maxid+1)).setValue(upload);
                Toast.makeText(OrderSummary.this, "inserted", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        StateName.setText(State[position]);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

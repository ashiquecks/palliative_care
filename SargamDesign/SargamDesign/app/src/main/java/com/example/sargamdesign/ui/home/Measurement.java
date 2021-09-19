package com.example.sargamdesign.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sargamdesign.R;

public class Measurement extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    final Context context = this;

    Button SaveContinue;
    Spinner spinner,spinner2;
    RadioGroup Neck_Design;
    RadioButton radioButton;

    RadioGroup Color_Design;
    RadioButton radioButton_color;

    String[] Size = {"SMALL","MEDIUM","LARGE","XL","XXL"};
    String[] Material = {"COTTON","LINEN","SILK FABRIC","NYLON FABRIC","WOOL FABRIC"};

    float Result_total;
    float Result_extra;
    int num1;
    int num2;
    int num3;
    int num4;
    EditText DesignPrice;
    TextView MateralName;
    TextView MaterialPrice;
    TextView StitchingPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement);


        spinner=(Spinner)findViewById(R.id.sizespinner);
        spinner2=(Spinner)findViewById(R.id.meterialspinner);
        SaveContinue=(Button)findViewById(R.id.save_continue_btn);
        Neck_Design=(RadioGroup) findViewById(R.id.neck_design);
        Color_Design=(RadioGroup) findViewById(R.id.radio_color);

        final TextView MeasurmentName=findViewById(R.id.itemText_name);
        Bundle bundle=getIntent().getExtras();
        String name = bundle.getString("item_name");
        MeasurmentName.setText(name);

        MaterialPrice=(TextView)findViewById(R.id.material_price);
        final TextView StitchingPrice=findViewById(R.id.stitching_price);
        final EditText Itemcount=findViewById(R.id.edicount);
        final EditText DesignPrice = findViewById(R.id.design_price);
        final TextView TotalPrice = findViewById(R.id.total_price);
        final TextView ExtraPrice = findViewById(R.id.extra_price);
        final TextView Color_Name = findViewById(R.id.color_name);
        final TextView MateralName = findViewById(R.id.material_name);


        spinner.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,Size);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrayAdapter);

        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,Material);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner2.setAdapter(arrayAdapter2);


        SaveContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = Neck_Design.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);

                DesignPrice.setText(radioButton.getText());

                int radioId2 = Color_Design.getCheckedRadioButtonId();

                radioButton_color = findViewById(radioId2);

                Color_Name.setText(radioButton_color.getText());


                num1 = Integer.parseInt(Itemcount.getText().toString());
                num2 = Integer.parseInt(DesignPrice.getText().toString());
                num3 = Integer.parseInt(MaterialPrice.getText().toString());
                num4 = Integer.parseInt(StitchingPrice.getText().toString());

                Result_extra=num3+num2+num4;
                Result_total=num1*Result_extra;

                ExtraPrice.setText(String.valueOf(Result_extra));

                TotalPrice.setText(String.valueOf(Result_total));

                String Total=TotalPrice.getText().toString();
                String Count=Itemcount.getText().toString();
                String D_price=DesignPrice.getText().toString();
                String Stich_price=StitchingPrice.getText().toString();
                String M_price=MaterialPrice.getText().toString();
                String Color=Color_Name.getText().toString();
                String Mc_Name=MeasurmentName.getText().toString();
                String MC_Category=spinner.getSelectedItem().toString();
                String Mc_Matrial=spinner2.getSelectedItem().toString();

                Intent intent=new Intent(Measurement.this,OrderSummary.class);
                intent.putExtra("total",Total);
                intent.putExtra("count",Count);
                intent.putExtra("color",Color);
                intent.putExtra("d_price",D_price);
                intent.putExtra("stich_price",Stich_price);
                intent.putExtra("m_price",M_price);
                intent.putExtra("mc_name",Mc_Name);
                intent.putExtra("mc_category",MC_Category);
                intent.putExtra("mc_material",Mc_Matrial);
                startActivity(intent);


            }
        });


    }
    public void checkButton(View v) {

        int radioId = Neck_Design.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);



    }
    public void checkColor(View v) {

        int radioId = Color_Design.getCheckedRadioButtonId();

        radioButton_color = findViewById(radioId);

        Toast.makeText(this, "Selected Radio Button: " + radioButton_color.getText(),
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch(position)
        {
            case 0:
                MaterialPrice.setText("120");
                break;

            case 1:
                MaterialPrice.setText("200");
                break;

            default:
                MaterialPrice.setText("340");
                break;
        }

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void AlertMe(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(Measurement.this);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(view.getContext()).inflate(R.layout.size_chart, viewGroup, false);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}

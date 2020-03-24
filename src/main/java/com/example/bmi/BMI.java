package com.example.bmi;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class BMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        getSupportActionBar().hide();

        final TextView heightText=findViewById(R.id.heightText);
        final TextView weightText=findViewById(R.id.weightText);
        final TextView resText=findViewById(R.id.resText);
        Button calButton=findViewById(R.id.calButton);

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result=new StringBuilder();
                if (v.getId()==R.id.calButton);
                    String height=heightText.getText().toString();
                    String weight=weightText.getText().toString();
                    double res=0,heightNum=0,weightNum=0;
                    if (!height.isEmpty()&&!weight.isEmpty()){
                        heightNum=Double.parseDouble(height);
                        weightNum=Double.parseDouble(weight);
                        res=weightNum/((heightNum/100)*(heightNum/100));
                        if (res<14)
                            resText.setText(R.string.chaoshou_name);
                        else if (res>14&&res<17)
                            resText.setText(R.string.thin_name);
                        else if (res>17&&res<23.5)
                            resText.setText(R.string.normal_name);
                        else if (res>23.5&&res<26)
                            resText.setText(R.string.fat_name);
                        else if (res>26&&res<40)
                            resText.setText(R.string.bfat_name);
                        else if (res>40)
                            resText.setText(R.string.toofat_name);

                    }else Toast.makeText(BMI.this,"输入有误",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

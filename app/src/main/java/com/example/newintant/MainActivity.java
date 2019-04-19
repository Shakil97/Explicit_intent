package com.example.newintant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText etName;
     Button btn1,btn2;
     TextView tvRusults;
     final int ACTIVITY3=3;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName =findViewById(R.id.etName);
        btn1 =findViewById(R.id.btn1);
        btn2 =findViewById(R.id.btn2);
        tvRusults=findViewById(R.id.tvResults);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"please enter all field!",Toast.LENGTH_SHORT).show();
            }
            else{
                String name=etName.getText().toString().trim();

                    Intent intent=new Intent(MainActivity.this,com.example.newintant.Activity2.class);
                    intent.putExtra("name",name);
                    startActivity(intent);
                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,com.example.newintant.Activity3.class);
                startActivityForResult(intent, ACTIVITY3);
            }
        });
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);

        if (resultCode==ACTIVITY3)
        {
           if (resultCode==RESULT_OK){
               tvRusults.setText(data.getStringExtra("surname"));

           }
           if (resultCode==RESULT_CANCELED){
               tvRusults.setText("no data found");

           }
        }

    }
}
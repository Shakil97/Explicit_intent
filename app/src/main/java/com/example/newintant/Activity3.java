package com.example.newintant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    EditText etsurname;
    Button submit,cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        etsurname=findViewById(R.id.etsurname);
        submit=findViewById(R.id.submit);
        cancel=findViewById(R.id.cancel);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etsurname.getText().toString().isEmpty())
                {
                    Toast.makeText(Activity3.this,"please enter all field!",Toast.LENGTH_SHORT).show();
                }
                else{
                    String surname=etsurname.getText().toString().trim();

                    Intent intent=new Intent();
                    intent.putExtra("surname",surname);
                    startActivity(intent);
                    setResult(RESULT_OK,intent);
                    Activity3.this.finish();
                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                Activity3.this.finish();
            }
        });
    }
}

package com.example.myapplicationresponse;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private final int ACTIVITY_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , SecondActivity.class);
                startActivityForResult(intent,ACTIVITY_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ACTIVITY_CODE ){

            if(resultCode == RESULT_CANCELED)
                Toast.makeText(this, "Cancelado por el usuario", Toast.LENGTH_LONG).show();
            else if (resultCode == RESULT_OK){

                String name = data.getExtras().getString("name");
                Toast.makeText(this, "Aceptado por " + name, Toast.LENGTH_LONG).show();
            }

        }
    }
}
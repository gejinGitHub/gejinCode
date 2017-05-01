package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.R.id.button1;

public class MainActivity extends AppCompatActivity {
private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView) findViewById(R.id.image_view);
        Button button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button1:
                        Toast.makeText(MainActivity.this,"现在请看第二张黑照，哈哈哈哈",Toast.LENGTH_LONG).show();
                        imageView.setImageResource(R.drawable.yangsan3_pic);

                }

            }
        });
    }
}

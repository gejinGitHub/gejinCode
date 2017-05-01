package com.example.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1=(Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Intent intent =new Intent("com.example.activitytest.ACTION_START");
                //intent.addCategory("com.example.activitytest.MY_CATEGORY");
                //startActivity(intent);
                //Intent intent=new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.baidu.com"));
                //String data="Hello SecondActivity!";
               // Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
               // intent.putExtra("extra_data",data);
               // startActivity(intent);
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });

    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        switch(requestCode)
        {
            case 1:
                if(resultCode==RESULT_OK)
                {
                    String returnedData=data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnedData);
                }
                break;
            default:
        }
    }
}

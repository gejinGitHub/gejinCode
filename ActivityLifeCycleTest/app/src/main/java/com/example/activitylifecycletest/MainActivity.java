package com.example.activitylifecycletest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="MainActivity";
    private ImageView imageView;
    private EditText editText;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*if(savedInstanceState!=null)
       // {
            String tempData=savedInstanceState.getString("data_key");
            Log.d("MainActivity",tempData);
        }
        Button startNormalActivity=(Button)findViewById(R.id.start_normal_activity);
        Button stratDialogActivity=(Button)findViewById(R.id.start_dialog_activity);
        startNormalActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });
        stratDialogActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        }); */
        Button button1=(Button)findViewById(R.id.button1);
          editText=(EditText)findViewById(R.id.edit_text);
        imageView=(ImageView)findViewById(R.id.image_view);
        progressBar=(ProgressBar)findViewById(R.id.progress_bar);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.button1:
                        /*if(progressBar.getVisibility()==View.GONE)
                        {
                            progressBar.setVisibility(View.VISIBLE);
                        }
                        else
                            progressBar.setVisibility(View.GONE);
                        */

                        //String inputText=editText.getText().toString();
                       // Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();

                        /*int progress=progressBar.getProgress();
                        progress=progress+10;
                        progressBar.setProgress(progress);
                        imageView.setImageResource(R.drawable.picture1);
                        */

                       /* AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("this is dialog ");
                        dialog.setMessage("Something important");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("OK",new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        dialog.show();
                        */

                        ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                        progressDialog.setTitle("this is ProgressDialog");
                        progressDialog.setMessage("loding...");
                        progressDialog.setCancelable(true);
                        progressDialog.show();  
                        break;
                    default:
                        break;
                }

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }
   protected void onSaveInstanceState(Bundle outState){
       super.onSaveInstanceState(outState);
       String tempData="some thing i just typed";
       outState.putString("data_key",tempData);

    }
}

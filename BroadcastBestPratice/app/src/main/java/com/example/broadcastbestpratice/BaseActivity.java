package com.example.broadcastbestpratice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lenovo on 2017/2/11.
 */

public class BaseActivity extends AppCompatActivity {
    private ForceOfflineReceiver receiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.broadcastpractice.FORCE_OFFFLINE");
        receiver=new ForceOfflineReceiver();
        registerReceiver(receiver,intentFilter);
    }
    protected void onPause()
    {
        super.onPause();
        if(receiver!=null)
        {
            unregisterReceiver(receiver);
            receiver=null;
        }
    }
    protected void onDestroy()
    {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
    class ForceOfflineReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(final Context context, Intent intent) {//当一个广播消息被Receiver监听到时，Android会调用它的onReceive()方法，并将包含消息的 Intent对象传给它
            AlertDialog.Builder builder=new AlertDialog.Builder(context);//构建一个对话框
            builder.setTitle("Waring");
            builder.setMessage("you are forced to be offline.Please try to login again.");
            builder.setCancelable(false);//对话框不可取消
            builder.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll();
                    Intent intent =new Intent(context,LoginActivity.class);
                    context.startActivity(intent);
                }
            });
            builder.show();
        }
    }
}

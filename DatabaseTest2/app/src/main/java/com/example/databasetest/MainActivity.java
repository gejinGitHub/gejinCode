package com.example.databasetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper=new MyDatabaseHelper(this,"BookStore.db",null,2);
        Button createDatabase=(Button)findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });
        Button addData=(Button)findViewById(R.id.add_Data);
        addData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues valus=new ContentValues();
                //开始组装第一条数据
                valus.put("name","The Da Vinici Code");
                valus.put("author","Dan Brown");
                valus.put("pages",454);
                valus.put("price",16.96);
                db.insert("Book",null,valus);
                valus.clear();
                //第二条数据
                valus.put("name","the lost symbol");
                valus.put("author","zhaogejin");
                valus.put("pages",500);
                valus.put("price",45.54);
                db.insert("Book",null,valus);

            }
        });
        Button updateData=(Button)findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("price",10.99);
                db.update("Book",values,"name=?",new String[] {"The Da Vinici Code"
                });//第四个参数为第三个参数提供参数
            }



        });
            Button deletedata=(Button)findViewById(R.id.delete_data);
        deletedata.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                db.delete("Book","pages>?",new String[]{"480"});
            }
        });
        Button queryData=(Button)findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                Cursor cursor=db.query("Book",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do {
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String author=cursor.getString(cursor.getColumnIndex("author"));
                        int pages=cursor.getInt(cursor.getColumnIndex("pages"));
                        double price=cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("MainActivity","book name is"+name);
                        Log.d("MainActivity","book author is"+author);
                        Log.d("MainActivity","book pages is"+pages);
                        Log.d("MainActivity","book price is"+price);
                    }while(cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }
}

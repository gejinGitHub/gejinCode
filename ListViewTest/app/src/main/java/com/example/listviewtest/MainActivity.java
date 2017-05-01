package com.example.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   // private String[] data={"Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry",
   // "Mango","Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry",
   //         "Mango"};
    private ImageView imageView;
private List<Fruit>fruitList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ArrayAdapter<String>adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);

        initFruits();
        FruitAdapter adapter=new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
       // ListView listview=(ListView)findViewById(R.id.list_view) ;
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?>parent,View view,int positon,long id){
                Fruit fruit=fruitList.get(positon);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        imageView=(ImageView)findViewById(R.id.fruit_image);
       //Button button1=(Button)findViewById(R.id.button1);
      //  button1.setOnClickListener(new View.OnClickListener() {
        //    public void onClick(View v) {
        //    switch(v.getId()){
           //      case R.id.button1:
                 //    imageView.setImageResource(R.drawable.yangsan2_pic);
               //      break;
             //     default:
              //       break;

           //   }
         //   }
      //  });
    }
    private void initFruits(){
        //for(int i=0;i<2;i++)
        //{
            Fruit apple=new Fruit("apple",R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana=new Fruit("Banana",R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange=new Fruit("Orange",R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon=new Fruit("Watermelon",R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear=new Fruit("Pear",R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape=new Fruit("Grape",R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit strawberry=new Fruit("Strawberry",R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry=new Fruit("Cherry",R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit mango=new Fruit("Mango",R.drawable.mango_pic);
            fruitList.add(mango);


        //}
    }
}

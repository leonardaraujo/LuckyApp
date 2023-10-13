package com.example.luckynumber;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView welcomeTxt,luckyNumberTxt;
    Button share_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        welcomeTxt=findViewById(R.id.textView2);
        luckyNumberTxt=findViewById(R.id.strLuckyNumber);
        share_btn=findViewById(R.id.share_btn);

        Intent i=getIntent();
        String userName=i.getStringExtra("name");
        int random_num=generateRandomNumber();
        luckyNumberTxt.setText(random_num);
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            shareData(userName,random_num);
            }
        });
    }
    public int generateRandomNumber(){
        Random random=new Random();
        return random.nextInt(1000);
    }
    public void shareData(String username,int random_number){
        Intent i =new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,username+"got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,"Hi lucky number day is"+random_number);
        startActivity(Intent.createChooser(i,"Choose a platform"));

    }
}
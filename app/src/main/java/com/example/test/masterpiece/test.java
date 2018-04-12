package com.example.test.masterpiece;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        setTitle("세번째 화면");

        final int voteCount[] = new int[9];
        for (int i =0; i < 9; i ++)
            voteCount[i] = 0;

        ImageView image[] = new ImageView[9];
        Integer imageId[] = {R.id.pic1, R.id.pic2, R.id.pic3, R.id.pic4, R.id.pic5, R.id.pic6, R.id.pic7, R.id.pic8, R.id.pic9};
        final String imgName[] = {"얍얍", "조이", "조이아이린", "조이아이린2", "아이린", "박성수", "김재현", "모재영", "김진우"};



        Button btnFirst = (Button) findViewById(R.id.btn1);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnSecond = (Button) findViewById(R.id.btn2);
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(test.this, result.class);
                a.putExtra("VoteCount", voteCount);
                a.putExtra("ImageName", imgName);
                startActivity(a);
            }
        });
    }
}

package com.example.test.masterpiece;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        //메인 액티비티에서 보낸 인텐트를 받고, 넘겨 받은 투표 결과 배열과 그림 이름을 배열을 저장
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");


        // 텍스트뷰 9개와 레이팅바 9개의 위젯 변수 배열을 선언
        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        // 텍스트뷰 id를 저장한 배열 변수, 레이팅바의 id를 저장한 배열 변수를 선언한다.
        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer rbarID[] = {R.id.rbr1, R.id.rbr2, R.id.rbr3, R.id.rbr4, R.id.rbr5, R.id.rbr6, R.id.rbr7, R.id.rbr8, R.id.rbr9};


        for(int i = 0; i < voteResult.length; i++){
            tv[i] = (TextView) findViewById(tvID[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);
        }
        // 텍스트뷰 위젯 변수에 넘겨받은 그림을 적용한다. 레이팅바에는 넘겨 받은 투표 결과를 적용한다.
        for (int i = 0; i < voteResult.length; i++){
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }

        // 버튼을 클릭하면 서브 액티비티를 종료한다.
        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

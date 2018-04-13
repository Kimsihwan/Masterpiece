package com.example.test.masterpiece;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");

        // 필요한 변수를 선언한다.

        // 그림을 클릭할 때마다 투표수를 저장할 9개짜리 배열을 선언하고 0으로 초기화한다.
        final int voteCount[] = new int[9];
        for (int i =0; i < 9; i ++)
            voteCount[i] = 0;

        // 이미지뷰 위젯을 저장할 9개 짜리 배열을 선언한다.
        ImageView image[] = new ImageView[9];

        // 이미지뷰 위젯의 id인 R.id.pic1 ~ pic9를 저장한 배열을 선언한다.
        Integer imageId[] = {R.id.pic1, R.id.pic2, R.id.pic3, R.id.pic4, R.id.pic5, R.id.pic6, R.id.pic7, R.id.pic8, R.id.pic9};


        final String imgName[] = {"얍얍", "조이", "조이아이린", "조이아이린2", "아이린", "박성수", "김재현", "모재영", "김진우"};


        // 이미지를 클릭할때마다 해당 이미지의 이름과 누적된 투표수도 토스트 메시지로 보여줌
        // 이미지뷰가 9개나 되므로 반복문을 사용
        for (int i = 0; i < imageId.length; i++){
            final int index;
            index = i;
            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgName[index] + ": 총 " + voteCount[index] + " 표", Toast.LENGTH_SHORT).show();
                }
            });
        }


        // 인텐트를 생성하고, 인텐트에 투표수 배열과 그림 이름 배열을 넣은 후에 결과 액티비티를 호출
        Button btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), result.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageName", imgName);
                startActivity(intent);
            }
        });



        Button btnThrid = (Button) findViewById(R.id.btn3);
        btnThrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), test.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageName", imgName);
                startActivity(intent);
            }
        });

    }
}

package com.example.week10_assignment_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class SecondAct extends AppCompatActivity {

    int[] result;
    RatingBar ratingBar1, ratingBar2, ratingBar3;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_second);

        ratingBar1 = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar2 = (RatingBar) findViewById(R.id.ratingBar2);
        ratingBar3 = (RatingBar) findViewById(R.id.ratingBar3);

        Intent intent = getIntent();
        if(intent != null){
            result = intent.getIntArrayExtra("cnt");
            ratingBar1.setRating(result[0]);
            ratingBar2.setRating(result[1]);
            ratingBar3.setRating(result[2]);
        }


        btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondAct.this, MainActivity.class);
                intent.putExtra("cnt", new int[]{(int)ratingBar1.getRating(), (int)ratingBar2.getRating(), (int)ratingBar3.getRating()});
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
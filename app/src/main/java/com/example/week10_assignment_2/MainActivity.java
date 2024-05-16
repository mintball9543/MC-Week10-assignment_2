package com.example.week10_assignment_2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ImageView img, img2, img3;
    TextView tv, tv2, tv3;
    int[] cnt = {0, 0, 0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultClick(v);
            }
        });

        img = (ImageView) findViewById(R.id.imageView);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);
        tv = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        tv.setText(String.valueOf(cnt[0]));
        tv2.setText(String.valueOf(cnt[1]));
        tv3.setText(String.valueOf(cnt[2]));
//        Log.i("cnt", String.valueOf(cnt[0]) + " " + String.valueOf(cnt[1]) + " " + String.valueOf(cnt[2]));

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(String.valueOf(++cnt[0]));
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(String.valueOf(++cnt[1]));
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv3.setText(String.valueOf(++cnt[2]));
            }
        });

    }

    public void resultClick(View v){
        Intent intent = new Intent(MainActivity.this, SecondAct.class);

        intent.putExtra("cnt", cnt);

        startActivityForResult(intent, 1);
//        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            cnt = data.getIntArrayExtra("cnt");
            tv.setText(String.valueOf(cnt[0]));
            tv2.setText(String.valueOf(cnt[1]));
            tv3.setText(String.valueOf(cnt[2]));
        }
    }
}
package com.example.aoiumi.uranaiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //レイアウト（activity_result.xml）より、名前、結果のテキストビューを取得
        TextView txvName = (TextView) findViewById(R.id.result_txv_name);
        TextView txvDivine = (TextView) findViewById(R.id.result_txv_divine);

        //遷移元（MainActivity）から送られてきたインテントを取得
        Intent intent = getIntent();

        //遷移元でセットした氏名を取得し、TextViewに設定する
        String name = intent.getStringExtra(MainActivity.INPUT_NAME);
        txvName.setText(name);

        //遷移元でセットした結果番号を取得する
        //defaultValue: キーに対応するデータが見つからなかった時、返す値
        int resultNumber = intent.getIntExtra(MainActivity.RESULT_NUMBER, 0);

        //Resource(strings.xml)より、String型の配列データを取得
        String[] divineData = getResources().getStringArray(R.array.result_txv_divine_data);
        txvDivine.setText(divineData[resultNumber]);







        Button divineBtn = (Button) findViewById(R.id.modoru);

        divineBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

        

    }
}

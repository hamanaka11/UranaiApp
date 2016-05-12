package com.example.aoiumi.uranaiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Activity:画面
//メイン画面の制御を行うためのクラス
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        //final定数　public staticいつでもどこでも呼び出せる。
        //入力された名前に対応するキー名（定数）
        public static final String INPUT_NAME = "InputName";

        //占い結果の計算値に対応するキー名（定数）
    public static final String RESULT_NUMBER = "ResultNumber";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //継承元クラス（AppCompactActivity）のonCreateメソッドを呼び出している。
        //activity_main.xmlを読み込んでいる。→画面が表示
        setContentView(R.layout.activity_main);
        //log(ログ)：履歴、情報を残す
        //System.out.printlnみたいなもの
        Log.d("LifeCycle", "onCreate");

        // レイアウト(activity_main.xml)より、「占う」ボタン(IDがmain_btn_divine)を取得
        Button divineBtn = (Button) findViewById(R.id.main_btn_divine);

        //占うボタンにリスナーを設定
        //this:このクラス（MainActivity）
        divineBtn.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "onCreate");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "onDestroy");

    }
    // view:押されたビュー（テキスト、ボタン等）の情報
    @Override
    public void onClick(View view) {
        //「占う」ボタンが押された時の処理を書く

        //Intentクラスのオブジェクトを生成
        //this:     このクラス（MainActivity）自身
        //ResultActivity.class:遷移先のクラス
        Intent intent = new Intent(this,ResultActivity.class);

        //レイアウト（activity_main.xml）より、名前入力欄の情報を取得
        //EDITテキストを持ってきている状況（）
        EditText etx = (EditText) findViewById(R.id.main_etx_name);

        //入力されている名前を文字列（String）として取得
        //toString(): Editable→Stringへ変換
        String inputName = etx.getText().toString();

        // 遷移先に渡すデータをセット
        // 1. 取り出すときに指定するキー
        // 2. 実際のデータ
        intent.putExtra(INPUT_NAME,inputName);

        //0~9までのランダムな値を生成する
        int resultNumber = new java.util.Random().nextInt(13);
        intent.putExtra(RESULT_NUMBER,resultNumber);
        //画面遷移開始
        startActivity(intent);

        //========変数表示＝＝＝＝＝＝
        //次はアクティビティリザウトへ飛ぶ
        TextView textText1 = (TextView) findViewById(R.id.textTest1);
        textText1.setText("変換しましたよ");

        //TextView nameOutput = (TextView)findViewById(R.id.nameOutput);
        //nameOutput.setText();


    }
}
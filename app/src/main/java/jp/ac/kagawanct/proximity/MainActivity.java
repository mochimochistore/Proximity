package jp.ac.kagawanct.proximity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    // ログ出力用タグ名
    private static final String TAG = "MainActivity";

    // センサーマネージャ
    private SensorManager mSensorManager;
    // 近接センサーを取り扱うオブジェクト
    private Sensor mSensor;
    // UI への処理実行を管理するハンドラ
    private Handler mHandler;

    //
    private ImageView mImageView;

    // 画面に表示する画像のリソース ID のリスト
    private List<Integer> mImages;
    // リスト内の選択中インデックス番号
    private int mImageIndex;

    @SuppressLint("HandlerLeak") // Handler のメモリリーク警告を表示させないための設定
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: フィールドの初期化と、センサー計測値の更新時に呼び出されるハンドルメソッドの定義
    }

    @Override
    protected void onResume() {
        super.onResume();

        // TODO: 近接センサーの計測を開始
    }

    @Override
    protected void onPause() {
        super.onPause();

        // TODO: 近接センサーの計測を解除
    }

    // SensorEventListener インタフェースが提供するメソッドの実装
    @Override
    public void onSensorChanged(SensorEvent event) {
        // TODO: 取得した近接センサー計測値に応じて画像を更新
    }

    // SensorEventListener インタフェースが提供するメソッドの実装
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // 何もしない
    }
}


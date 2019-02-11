package jp.ac.yuge.proximity;

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

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // センサーマネージャのインスタンスを取得
        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        // 近接センサーを取り扱うためのオブジェクトのインスタンスを取得
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        //
        mImageView = (ImageView)MainActivity.this.findViewById(R.id.image_view);

        mImages = Arrays.asList(R.drawable.animal01,
                R.drawable.animal02,
                R.drawable.animal03,
                R.drawable.animal04,
                R.drawable.animal05);
        mImageIndex = 0;

        //
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {

                int imageResourceId = mImages.get(mImageIndex);
                mImageView.setImageResource(imageResourceId);

                mImageIndex++;
                if (mImageIndex >= mImages.size()) {
                    mImageIndex = 0;
                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mSensor != null) {
            //
            mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);

        } else {
            //
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mSensor != null) {
            //
            mSensorManager.unregisterListener(this);

        } else {
            //
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float proximity = event.values[0];
        Log.d(TAG, "proximity: " + proximity);

        //
        if (proximity <= 0) {
            mHandler.sendMessage(Message.obtain());
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //
    }
}


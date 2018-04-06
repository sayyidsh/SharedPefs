package pro.nanosystems.sharedpefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import pro.nanosystems.sharedpefs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private SharedPreferences sh;
    private SharedPreferences.Editor shEdit;
    private String SHARED_FILE;
    private final String COUNT_KEY = "Count";
    private final String CURRENT_COLOR_KEY = "Color";

    ActivityMainBinding mainBinding;
    private Integer mCount = 0;
    private int mCurrentColor;
    private final int DEFAULT_COLOR = Color.GRAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        SHARED_FILE = this.getApplicationContext().getPackageName();
        sh = getSharedPreferences(SHARED_FILE, Context.MODE_PRIVATE);
        shEdit = sh.edit();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        shEdit.putInt(COUNT_KEY, mCount);
        shEdit.putInt(CURRENT_COLOR_KEY, mCurrentColor);
        shEdit.apply();
        Log.i(TAG, "onSaveInstanceState: Saved");
    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();

        mCount = sh.getInt(COUNT_KEY, 0);
        mCurrentColor = sh.getInt(CURRENT_COLOR_KEY, DEFAULT_COLOR);
        mainBinding.countText.setText(mCount.toString());
        mainBinding.countText.setBackgroundColor(mCurrentColor);

    }

    public void setColorBlack(View view) {
        mCurrentColor = ((ColorDrawable) view.getBackground()).getColor();
        mainBinding.countText.setBackgroundColor(mCurrentColor);

    }

    public void setColorBlue(View view) {
        mCurrentColor = ((ColorDrawable) view.getBackground()).getColor();
        mainBinding.countText.setBackgroundColor(mCurrentColor);
        // startActivity(new Intent(this, Main2Activity.class));
    }

    public void setColorRed(View view) {
        mCurrentColor = ((ColorDrawable) view.getBackground()).getColor();
        mainBinding.countText.setBackgroundColor(mCurrentColor);
    }

    public void setColorGreen(View view) {

        mCurrentColor = ((ColorDrawable) view.getBackground()).getColor();
        mainBinding.countText.setBackgroundColor(mCurrentColor);
    }

    public void setCount(View view) {
        mCount++;
        mainBinding.countText.setText(mCount.toString());
    }

    public void resetCount(View view) {
        mCount = 0;
        mCurrentColor = DEFAULT_COLOR;
        mainBinding.countText.setText(mCount.toString());
        mainBinding.countText.setBackgroundColor(DEFAULT_COLOR);
        shEdit.clear();
        shEdit.apply();
    }
}

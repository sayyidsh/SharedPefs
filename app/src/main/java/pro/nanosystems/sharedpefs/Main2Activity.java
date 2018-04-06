package pro.nanosystems.sharedpefs;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pro.nanosystems.sharedpefs.databinding.ActivityMain2Binding;

public class Main2Activity extends AppCompatActivity {
    ActivityMain2Binding main2Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main2Binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);

    }
}

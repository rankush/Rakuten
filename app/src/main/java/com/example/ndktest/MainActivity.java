package com.example.ndktest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Load the 'my-native-library' library on application startup.
    static {
        System.loadLibrary("my-native-library");
    }

    private TextView mCounterTextView;
    private Button mCounterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
    }

    private void initUi() {
        mCounterTextView = findViewById(R.id.counter_textview);

        mCounterButton = findViewById(R.id.counter_btn);
        mCounterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        if (viewId == R.id.counter_btn) {
            int currentCount = incrementCounter();
            mCounterTextView.setText(String.valueOf(currentCount));
            return;
        }
    }

    /**
     * A native method that is implemented by the 'my-native-library' native library,
     * to increment the counter and get the value
     */
    public native int incrementCounter();
}

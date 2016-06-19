package com.redchild.scrollerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.redchild.scrollerdemo.view.ScrollViewGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ScrollViewGroup mScrollViewGroup;
    private Button mUpBtn;
    private Button mDownBtn;
    private Button mLeftBtn;
    private Button mRightBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        mUpBtn.setOnClickListener(this);
        mDownBtn.setOnClickListener(this);
        mLeftBtn.setOnClickListener(this);
        mRightBtn.setOnClickListener(this);
    }

    private void initView() {
        mScrollViewGroup = (ScrollViewGroup) findViewById(R.id.main_content);
        mUpBtn = (Button) findViewById(R.id.main_up_btn);
        mDownBtn = (Button) findViewById(R.id.main_down_btn);
        mLeftBtn = (Button) findViewById(R.id.main_left_btn);
        mRightBtn = (Button) findViewById(R.id.main_right_btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_up_btn:
                upClick();
                break;

            case R.id.main_down_btn:
                downClick();
                break;

            case R.id.main_left_btn:
                leftClick();
                break;

            case R.id.main_right_btn:
                rightClick();
                break;
        }
    }

    private void rightClick() {
        mScrollViewGroup.right();
    }

    private void leftClick() {
        mScrollViewGroup.left();
    }

    private void downClick() {
        mScrollViewGroup.down();
    }

    private void upClick() {
        mScrollViewGroup.up();
    }
}

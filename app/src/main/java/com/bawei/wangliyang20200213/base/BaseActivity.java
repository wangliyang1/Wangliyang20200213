package com.bawei.wangliyang20200213.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei.wangliyang20200213.R;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    protected P mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        ButterKnife.bind(this);
        mPresenter = provitePresenter();
        if (mPresenter!=null){
            mPresenter.attach(this);
        }
        initView();
        initData();
    }

    protected abstract P provitePresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detach();
        }
    }
}

package com.bawei.wangliyang20200213.base;

public abstract class BasePresenter<V> {
    protected V view;

    public void attach(V view) {
        this.view = view;
    }

    public void detach(){
        view = null;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}

package com.bawei.wangliyang20200213.model;

import com.bawei.wangliyang20200213.contract.ReAndLoginContract;
import com.bawei.wangliyang20200213.model.bean.LoginBean;
import com.bawei.wangliyang20200213.model.bean.RegisterBean;
import com.bawei.wangliyang20200213.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ReAndLoginModel implements ReAndLoginContract.IModel {
    @Override
    public void register(String phone, String pwd, IModelCallback iModelCallback) {
        NetUtil.getInstance().getApi().register(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                       if ("0000".equals(registerBean.getStatus())){
                           iModelCallback.onRegisterSuccess(registerBean);
                       }else {
                           iModelCallback.onRegisterFailure(new Exception(registerBean.getMessage()));
                       }
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onRegisterFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void login(String phone, String pwd, IModelCallback iModelCallback) {
         NetUtil.getInstance().getApi().login(phone,pwd)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<LoginBean>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(LoginBean loginBean) {
                         if ("0000".equals(loginBean.getStatus())){
                             iModelCallback.onLoginSuccess(loginBean);
                         }else {
                             iModelCallback.onLoginFailure(new Exception(loginBean.getMessage()));
                         }
                     }

                     @Override
                     public void onError(Throwable e) {
                         iModelCallback.onLoginFailure(e);
                     }

                     @Override
                     public void onComplete() {

                     }
                 });
    }
}

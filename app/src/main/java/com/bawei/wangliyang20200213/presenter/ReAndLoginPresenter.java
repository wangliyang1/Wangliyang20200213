package com.bawei.wangliyang20200213.presenter;

import com.bawei.wangliyang20200213.base.BasePresenter;
import com.bawei.wangliyang20200213.contract.ReAndLoginContract;
import com.bawei.wangliyang20200213.model.ReAndLoginModel;
import com.bawei.wangliyang20200213.model.bean.LoginBean;
import com.bawei.wangliyang20200213.model.bean.RegisterBean;

public class ReAndLoginPresenter extends BasePresenter<ReAndLoginContract.IView> implements ReAndLoginContract.IPresenter {

    private ReAndLoginModel reAndLoginModel;

    @Override
    protected void initModel() {
        reAndLoginModel = new ReAndLoginModel();
    }

    @Override
    public void register(String phone, String pwd) {
        reAndLoginModel.register(phone, pwd, new ReAndLoginContract.IModel.IModelCallback() {
            @Override
            public void onRegisterSuccess(RegisterBean registerBean) {
                view.onRegisterSuccess(registerBean);
            }

            @Override
            public void onRegisterFailure(Throwable throwable) {
                view.onRegisterFailure(throwable);
            }

            @Override
            public void onLoginSuccess(LoginBean loginBean) {

            }

            @Override
            public void onLoginFailure(Throwable throwable) {

            }
        });
    }

    @Override
    public void login(String phone, String pwd) {
        reAndLoginModel.login(phone, pwd, new ReAndLoginContract.IModel.IModelCallback() {
            @Override
            public void onRegisterSuccess(RegisterBean registerBean) {

            }

            @Override
            public void onRegisterFailure(Throwable throwable) {

            }

            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                view.onLoginSuccess(loginBean);
            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                view.onLoginFailure(throwable);
            }
        });
    }
}

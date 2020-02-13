package com.bawei.wangliyang20200213.contract;

import com.bawei.wangliyang20200213.model.bean.LoginBean;
import com.bawei.wangliyang20200213.model.bean.RegisterBean;

public interface ReAndLoginContract {
    interface IView{
        void onRegisterSuccess(RegisterBean registerBean);
        void onRegisterFailure(Throwable throwable);

        void onLoginSuccess(LoginBean loginBean);
        void onLoginFailure(Throwable throwable);
    }
    interface IPresenter{
        void register(String phone,String pwd);
        void login(String phone,String pwd);
    }
    interface IModel{
        void register(String phone,String pwd,IModelCallback iModelCallback);
        void login(String phone,String pwd,IModelCallback iModelCallback    );
        interface IModelCallback{
            void onRegisterSuccess(RegisterBean registerBean);
            void onRegisterFailure(Throwable throwable);

            void onLoginSuccess(LoginBean loginBean);
            void onLoginFailure(Throwable throwable);
        }
    }
}

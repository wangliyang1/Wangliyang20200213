package com.bawei.wangliyang20200213.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.wangliyang20200213.R;
import com.bawei.wangliyang20200213.base.BaseActivity;
import com.bawei.wangliyang20200213.contract.ReAndLoginContract;
import com.bawei.wangliyang20200213.model.bean.LoginBean;
import com.bawei.wangliyang20200213.model.bean.RegisterBean;
import com.bawei.wangliyang20200213.presenter.ReAndLoginPresenter;
import com.blankj.utilcode.util.EncryptUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterAndLoginActivity extends BaseActivity<ReAndLoginPresenter> implements ReAndLoginContract.IView {


    @BindView(R.id.edt_phone)
    EditText edtPhone;
    @BindView(R.id.edt_pwd)
    EditText edtPwd;
    @BindView(R.id.n_login)
    Button nLogin;
    @BindView(R.id.n_register)
    Button nRegister;
//nihaoya
    @Override
    protected ReAndLoginPresenter provitePresenter() {
        return new ReAndLoginPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_register_and_login;
    }

    @Override
    public void onRegisterSuccess(RegisterBean registerBean) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterFailure(Throwable throwable) {
        Toast.makeText(this, "注册失败"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure(Throwable throwable) {
        Toast.makeText(this, "登录失败"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.n_login, R.id.n_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.n_login:
                String phone2 = edtPhone.getText().toString();
                String pwd2 = edtPwd.getText().toString();
                String mdpwd2 = EncryptUtils.encryptMD5ToString(pwd2);
                mPresenter.login(phone2,mdpwd2);
                break;
            case R.id.n_register:
                String phone = edtPhone.getText().toString();
                String pwd = edtPwd.getText().toString();
                String mdpwd = EncryptUtils.encryptMD5ToString(pwd);
                mPresenter.register(phone,mdpwd);
                break;
        }
    }
}

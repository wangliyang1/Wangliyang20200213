package com.bawei.wangliyang20200213;

import com.bawei.wangliyang20200213.model.bean.LoginBean;
import com.bawei.wangliyang20200213.model.bean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<RegisterBean> register(@Field("phone")String phone,@Field("pwd")String pwd);

    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<LoginBean> login(@Field("phone")String phone, @Field("pwd")String pwd);

}

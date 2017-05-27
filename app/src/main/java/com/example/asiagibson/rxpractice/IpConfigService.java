package com.example.asiagibson.rxpractice;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by asiagibson on 5/14/17.
 */

public interface IpConfigService {
    @GET("json")
    Call<IpConfigResponse> getCurrentIp();
}

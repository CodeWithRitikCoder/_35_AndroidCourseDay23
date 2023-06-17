package com.ritikcoder.project23ofandroiddev_howtouseapi_1

import retrofit2.Call
import retrofit2.http.GET

interface API_Interface {

    @GET("products")
    fun getProduct(): Call<MyData>

}
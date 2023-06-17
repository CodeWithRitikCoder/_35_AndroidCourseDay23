package com.ritikcoder.project23ofandroiddev_howtouseapi_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ritikcoder.project23ofandroiddev_howtouseapi_1.databinding.ActivityMain2Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding
    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //It is used to hide support action bar
        supportActionBar?.hide()

        //initialization of recyclerView.
        recyclerView= binding.recyclerView

        //API Code to work done
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API_Interface::class.java)

        val retrofitData = retrofitBuilder.getProduct()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                //if API call is a success, then use the data of API and show in you Application.
                val responseBody = response.body()
                val productList = responseBody?.products!!

                //initialization of myAdapter.
                myAdapter= MyAdapter(this@MainActivity2, productList)

                recyclerView.adapter= myAdapter
                recyclerView.layoutManager= LinearLayoutManager(this@MainActivity2)


            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                //if API call is fails, then you show what ever you want to show to user.
                Log.d("Main Activity", "onFailure: " + t.message)

            }
        })

    }
}
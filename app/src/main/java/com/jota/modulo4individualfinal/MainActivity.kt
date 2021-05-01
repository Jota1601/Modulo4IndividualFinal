package com.jota.modulo4individualfinal

import android.os.Bundle
import layout.Adapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var RV: RecyclerView
    lateinit var adapterD:Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RV = findViewById(R.id.rvDogs)
        searchD()
    }

    private fun initChar(cans:DResponse) {

        adapterD = Adapter(cans.images)
        RV.setHasFixedSize(true)
        RV.layoutManager = LinearLayoutManager(this)
        RV.adapter = adapterD
    }

    private fun searchD() {
        doAsync {
            val call = getRetrofit().create(ServiceAPI::class.java).tomarTodo("mix/images").execute()
            val cans = call.body() as DResponse
            uiThread {

                initChar(cans)
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://dog.ceo/api/breed/").addConverterFactory(
                GsonConverterFactory.create()).build()
    }
}

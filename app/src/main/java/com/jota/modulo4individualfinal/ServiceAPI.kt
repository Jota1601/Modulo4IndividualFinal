package com.jota.modulo4individualfinal

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ServiceAPI {

        @GET
        fun tomarTodo(@Url url: String): Call<DResponse>
        //Toma el dato que tiene la lista de la data DResponse

}
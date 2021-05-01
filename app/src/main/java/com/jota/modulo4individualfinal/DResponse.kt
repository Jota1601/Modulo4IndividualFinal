package com.jota.modulo4individualfinal

import com.google.gson.annotations.SerializedName

data class DResponse( // se crea la data para las listas donde esta la api
    @SerializedName("status") var status:String,
    @SerializedName("message") var images:List<String>
)

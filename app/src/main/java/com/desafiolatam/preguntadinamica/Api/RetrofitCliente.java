package com.desafiolatam.preguntadinamica.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCliente {



    private static Retrofit retrofit;
            private static final String BASE_URL="https://opentdb.com/";



    public static Retrofit getRetrofit(){

    if(retrofit==null){
        retrofit= new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    return retrofit;


    }
}


package com.desafiolatam.preguntadinamica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.desafiolatam.preguntadinamica.Api.Api;
import com.desafiolatam.preguntadinamica.Api.RetrofitCliente;
import com.desafiolatam.preguntadinamica.model.RespuestaApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
 private TextView pregunta,categoria,dificultad;

 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();


               Api api = RetrofitCliente.getRetrofit().create(Api.class);
                      Call<RespuestaApi> call = api.getQuestion();
                      call.enqueue(new Callback<RespuestaApi>() {
                          @Override
                          public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {
                              pregunta.setText(response.body().getResults().get(0).getQuestion());
                          }
                          @Override
                          public void onFailure(Call<RespuestaApi> call, Throwable t) {
                              Toast.makeText(MainActivity.this, "Algo Fallo, intentelo despues", Toast.LENGTH_SHORT).show();

                              Log.e("ERROR", t.toString());
                          }

                      });
                  }


    private void initializeViews(){
        pregunta=findViewById(R.id.pregunta);
        categoria=findViewById(R.id.categoria);
        dificultad=findViewById(R.id.dificultad);
    }



}

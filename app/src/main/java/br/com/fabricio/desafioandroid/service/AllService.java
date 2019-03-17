package br.com.fabricio.desafioandroid.service;

import br.com.fabricio.desafioandroid.model.All;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Fabricio on 12/03/2019.
 */

public interface AllService {

    @GET("hmg-search")
    Call<All> recuperarAll();

}

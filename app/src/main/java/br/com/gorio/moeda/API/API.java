package br.com.gorio.moeda.API;

import br.com.gorio.moeda.model.Currency;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    @GET("/latest")
    Call<Currency> getLatestCurrency();

    @GET("/latest")
    Call<Currency> getLatestCurrencyBase(@Query("base") String base);
}

package br.com.gorio.moeda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.gorio.moeda.API.API;
import br.com.gorio.moeda.model.Currency;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCurrency("USD");
    }

    private void getCurrency(final String rate) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.fixer.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API currencyAPI = retrofit.create(API.class);
        Call<Currency> getCurrency;
        if (rate.isEmpty()) {

            getCurrency = currencyAPI.getLatestCurrency();
        } else {
            getCurrency = currencyAPI.getLatestCurrencyBase(rate);
        }

        getCurrency.enqueue(new Callback<Currency>() {

            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                if (response != null) {

                    Currency currency = response.body();

                }
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {

            }
        });
    }
}

package registration.testing.firebase.com.retrofitmvp.Core;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import registration.testing.firebase.com.retrofitmvp.Model.AllCountryResponse;
import registration.testing.firebase.com.retrofitmvp.Model.Country;
import registration.testing.firebase.com.retrofitmvp.Model.CountryRes;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ashish on 28-09-2017.
 */

public class Intractor implements GetDataContract.Interactor{
    private GetDataContract.onGetDataListener mOnGetDatalistener;
    List<CountryRes> allcountry = new ArrayList<>();
    List<String> allCountriesData = new ArrayList<>();
    List<String> allPricesData = new ArrayList<>();
    List<CountryRes.Datum> datumList;


    public Intractor(GetDataContract.onGetDataListener mOnGetDatalistener){
        this.mOnGetDatalistener = mOnGetDatalistener;
    }
    @Override
    public void initRetrofitCall(Context context, String url) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        AllCountryResponse request = retrofit.create(AllCountryResponse.class);
        retrofit2.Call<CountryRes> call = request.getCountry();
        call.enqueue(new retrofit2.Callback<CountryRes>() {
            @Override
            public void onResponse(retrofit2.Call<CountryRes> call, retrofit2.Response<CountryRes> response) {
                CountryRes resource = response.body();
                datumList = resource.data;
                for (CountryRes.Datum datum : datumList) {
                    allCountriesData.add(datum.getName());
                    allPricesData.add(datum.getPantoneValue());
                }

                Log.d("Data", "Refreshed");
                mOnGetDatalistener.onSuccess("List Size: " + allCountriesData.size(),allPricesData.size(), datumList);



            }
            @Override
            public void onFailure(retrofit2.Call<CountryRes> call, Throwable t) {
                Log.v("Error",t.getMessage());
                mOnGetDatalistener.onFailure(t.getMessage());
            }
        });
    }
}

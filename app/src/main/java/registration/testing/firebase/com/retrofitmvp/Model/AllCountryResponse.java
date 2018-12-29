package registration.testing.firebase.com.retrofitmvp.Model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ashish on 06-02-2017.
 */

public interface AllCountryResponse {
    @GET("/api/unknown")
    Call<CountryRes> getCountry();
}

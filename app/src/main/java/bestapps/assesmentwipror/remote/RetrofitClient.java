package bestapps.assesmentwipror.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * To send network requests to an API, specify the main URL for the service.
 * Created by Anil on 1/31/2018.
 */
public class RetrofitClient {

    private static Retrofit retrofit = null;
    /**
     * creating retrofit instance through retrofit builder
     * @return : retrofit instance
     */
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiUtils.Main_URL)
                    .addConverterFactory(GsonConverterFactory.create())//directly convert json data to object
                    .build();
        }
        return retrofit;
    }
}
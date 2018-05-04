package bestapps.assesmentwipror.interfaces;

import bestapps.assesmentwipror.model.Wipro;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * WipServiceInterface defines HTTP operations
 */
public interface WipServiceInterface {
    /**
     * @return :Api Endpoints providing callback to enqueue
     * The return value wraps the response in a Call object with the type of the expected(Wipro) result.
     */
    @SuppressWarnings("JavaDoc")
    @GET("facts.json")
    Call<Wipro> getServerData();
 }
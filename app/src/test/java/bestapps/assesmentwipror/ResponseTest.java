package bestapps.assesmentwipror;

import org.junit.Test;

import java.io.IOException;

import bestapps.assesmentwipror.model.Wipro;
import bestapps.assesmentwipror.remote.RetrofitClient;
import bestapps.assesmentwipror.interfaces.WipServiceInterface;
import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ResponseTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    /**
     * Test to validate response
     */
    @Test
    public void apiResponse_Success() {
        WipServiceInterface apiEndpoints = RetrofitClient.getClient().create(WipServiceInterface.class);
        Call<Wipro> call = apiEndpoints.getServerData();
        try {
            Response<Wipro> response = call.execute();
            Wipro authResponse = response.body();
            assertTrue(response.isSuccessful() && authResponse.getTitle().startsWith("About Canada"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
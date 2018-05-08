package bestapps.assesmentwipror;
import org.junit.Test;
import org.mockito.Mock;
import java.io.IOException;
import java.util.List;
import bestapps.assesmentwipror.model.Row;
import bestapps.assesmentwipror.model.Wipro;
import bestapps.assesmentwipror.remote.RetrofitClient;
import bestapps.assesmentwipror.interfaces.WipServiceInterface;
import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ResponseTest {
    @Mock
    Row row;

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
    /**
     * Test to validate Row Count
     */
    @Test
    public void rowsCountCheck() {
        List<Row> mRows;
        WipServiceInterface apiEndpoints = RetrofitClient.getClient().create(WipServiceInterface.class);
        Call<Wipro> call = apiEndpoints.getServerData();
        try {
            Response<Wipro> response = call.execute();
            Wipro authResponse = response.body();
            mRows = authResponse.getRows();
            if (!mRows.isEmpty()) {
                assertEquals(14, authResponse.getRows().size());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test to validate row Description
     */
    @Test
    public void rowDescCheck() {
        List<Row> mRows;
        WipServiceInterface apiEndpoints = RetrofitClient.getClient().create(WipServiceInterface.class);
        Call<Wipro> call = apiEndpoints.getServerData();
        try {
            Response<Wipro> response = call.execute();
            Wipro authResponse = response.body();
            mRows = authResponse.getRows();
            row = mRows.get(10);
            assertEquals("It's really big.", row.getDescription());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
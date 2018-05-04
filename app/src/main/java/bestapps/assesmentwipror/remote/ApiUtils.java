package bestapps.assesmentwipror.remote;


import bestapps.assesmentwipror.interfaces.WipServiceInterface;

/**
 * Created by Anil on 1/31/2018.
 */
@SuppressWarnings("DefaultFileTemplate")
public class ApiUtils {
    public static final String Main_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/";

    /**
     * @return : provide an interface to our application through the getWipService()
     */
    public static WipServiceInterface getWipService() {
        return RetrofitClient.getClient().create(WipServiceInterface.class);
    }

}
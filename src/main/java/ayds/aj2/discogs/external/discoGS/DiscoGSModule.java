package ayds.aj2.discogs.external.discoGS;


import ayds.aj2.discogs.external.ExternalService;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class DiscoGSModule {

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.discogs.com/database/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();

    private static DiscoGSModule instance;

    private final ExternalService externalService;

    private DiscoGSModule() {
        DiscoGSToAlbumResolver discoGSToAlbumResolver = new JsonToAlbumResolver();
         DiscoGSAPI discoGSAPI = retrofit.create(DiscoGSAPI.class);
        externalService = new DiscoGSService(discoGSToAlbumResolver, discoGSAPI);
    }

    public static DiscoGSModule getInstance() {
        if (instance == null) {
            instance = new DiscoGSModule();
        }
        return instance;
    }

    public ExternalService getExternalService() {
        return externalService;
    }
}


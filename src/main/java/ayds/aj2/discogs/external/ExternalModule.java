package ayds.aj2.discogs.external;

import ayds.aj2.discogs.external.discoGS.DiscoGSModule;

public class ExternalModule {

    private static ExternalModule instance;

    private ExternalModule() {
    }

    public static ExternalModule getInstance() {
        if (instance == null) {
            instance = new ExternalModule();
        }
        return instance;
    }

    public ExternalService getExternalService() {
        return DiscoGSModule.getInstance().getExternalService();
    }
}

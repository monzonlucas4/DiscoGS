package ayds.aj2.discogs.external.discoGS;

import ayds.aj2.discogs.external.Album;
import ayds.aj2.discogs.external.ExternalService;
import ayds.aj2.discogs.external.SongSubmodule;
import retrofit2.Response;

class DiscoGSService implements ExternalService {

    private final DiscoGSAPI discoGSAPI;

    private final DiscoGSToAlbumResolver discoGSToAlbumResolver;

    DiscoGSService(DiscoGSToAlbumResolver discoGSToAlbumResolver, DiscoGSAPI discoGSAPI){
        this.discoGSToAlbumResolver = discoGSToAlbumResolver;
        this.discoGSAPI = discoGSAPI;
    }

    @Override
    public Album getAlbum(SongSubmodule song) throws Exception {
        Response<String> callResponse = getAlbumFromService(song);

        return discoGSToAlbumResolver.getAlbumFromExternalData(callResponse.body(), song);
    }

    private Response<String> getAlbumFromService(SongSubmodule song) throws Exception{
       return discoGSAPI.getAlbumInfo(song.getAlbumSubmoduleName(), song.getArtistSubmoduleName()).execute();
    }
}

package ayds.aj2.discogs.external;

public interface ExternalService {

    Album getAlbum(SongSubmodule song) throws Exception;
}

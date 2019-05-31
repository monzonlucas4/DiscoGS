package ayds.aj2.discogs.external.discoGS;


import ayds.aj2.discogs.external.Album;
import ayds.aj2.discogs.external.SongSubmodule;

public interface DiscoGSToAlbumResolver {

    Album getAlbumFromExternalData(String serviceData, SongSubmodule song) throws Exception;
}

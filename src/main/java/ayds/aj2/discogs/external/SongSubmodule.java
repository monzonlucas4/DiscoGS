package ayds.aj2.discogs.external;

public class SongSubmodule {


    private String songName;
    private String artistName;
    private String albumName;
    private String url;

    public SongSubmodule(String songName, String artistName, String albumName, String url) {
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.url = url;
    }

    public void setSongSubmoduleName(String songName) {
        this.songName = songName;
    }

    public String getSongSubmoduleName() {
        return songName;
    }

    public String getArtistSubmoduleName() {
        return artistName;
    }

    public String getAlbumSubmoduleName() {
        return albumName;
    }

    public String getUrlSubmodule() {
        return url;
    }
}



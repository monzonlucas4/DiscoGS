package ayds.aj2.discogs.external;

public class Album {

    private String song;
    private String text;
    private String image_url;

    public Album(String song, String text, String image_url){

        this.song = song;
        this.text = text;
        this.image_url = image_url;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getText() {
        return text;
    }

    public String getImage_url() {
        return image_url;
    }
}

package ayds.aj2.discogs.external.discoGS;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import ayds.aj2.discogs.external.Album;
import ayds.aj2.discogs.external.SongSubmodule;


class JsonToAlbumResolver implements DiscoGSToAlbumResolver {

    private final Gson gson = new Gson();

    @Override
    public Album getAlbumFromExternalData(String serviceData, SongSubmodule song) throws Exception {
        try {
            JsonObject jsonObject = gson.fromJson(serviceData, JsonObject.class);
            JsonArray results = jsonObject.get("results").getAsJsonArray();
            JsonObject first = results.get(0).getAsJsonObject();
            JsonElement extract = first.get("title");
            JsonElement yearE = first.get("year");
            JsonElement image = first.get("cover_image");

            String text = extract.getAsString() + " - year: " + yearE.getAsString();
                return new Album(song.getSongSubmoduleName(), text, image.getAsString());
        }
        catch(Exception e) {
            throw new Exception("No results");
        }
    }
}

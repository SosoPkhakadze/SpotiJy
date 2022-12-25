import java.util.Arrays;
public class SpotiJy {
    public SpotiJy(Artist[] artists) {
        this.artists = artists;
    }

    private Artist[] artists;

    Artist[] getArtists() {
        return artists;
    }
    private Artist[] ArrayAppend(Artist[] artists,Artist temp){
        Artist[] result = new Artist[artists.length+1];
        for (int i = 0; i < artists.length; i++) {
            result[i] = artists[i];
        }
        result[result.length-1]=temp;
        return result;
    }
    public void addArtists(Artist[] artists) {
        if (this.artists == null) {
            this.artists = artists;
        } else
            for (int i = 0; i < artists.length - 1; i++) {
                for (int j = 0; j < this.artists.length; j++) {
                    if (this.artists[i].isEqual(artists[j]))
                        return;
                    else
                        ArrayAppend(this.artists, artists[j]);
                }
            }
    }


    String [] getTopTrendingArtist(){
        int maxliked = artists[0].totalLikes();
        String[] String = new String[2];
        String[0] = artists[0].getFirstName();
        String[1] = artists[1].getLastName();
        for (int i = 0; i < artists.length; i++) {
           if( artists[i].totalLikes()>maxliked){
               maxliked = artists[i].totalLikes();
               String[0] = artists[i].getFirstName();
               String[1] = artists[i].getLastName(); }
        } return new String[]{"['" + String[0] + "','" + String[1] + "']"};
    }
    String getTopTrendingAlbum(){
        int mostlikes = artists[0].getAlbums()[0].getSongs()[0].getLikes();
        String name = artists[0].getAlbums()[0].getSongs()[0].getTitle();
        for (int i = 0; i < artists.length; i++) {
            for (int j = 0; j < artists[i].getAlbums().length; j++) {
                for (int l = 0; l < artists[i].getAlbums()[j].getSongs().length; l++) {
                    if (artists[i].getAlbums()[j].getSongs()[l].getLikes()>mostlikes){
                    mostlikes= artists[i].getAlbums()[j].getSongs()[l].getLikes();
                    name = artists[i].getAlbums()[j].getSongs()[l].getTitle();
                }
            }
            }
        } return name;
    }
    String getTopTrendingSong() {
        int likes = artists[0].mostLikedSong().getLikes();
        String songName = artists[0].mostLikedSong().getTitle();
        for (int i = 0; i < artists.length; i++) {
            if (artists[i].mostLikedSong().getLikes() > likes) {
                likes = artists[i].mostLikedSong().getLikes();
                songName = artists[i].mostLikedSong().getTitle(); }
            }
        return songName; }
    }

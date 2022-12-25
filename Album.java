import java.sql.Array;
import java.util.Arrays;
import java.util.Random;
public class Album {
    private String title;
    private int releaseYear;
    private Song[] Songs;
    public Album(String title, int releaseYear, Song[] songs) {
        this.title = title;
        this.releaseYear = releaseYear;
        Songs = songs;
    }
    public String getTitle() {
        return title;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public Song[] getSongs() {
        return Songs;
    }

    private Song[] arrayAppend(Song[] songs,Song temp){
        Song[] result = new Song[songs.length+1];
        for (int i = 0; i < songs.length; i++) {
            result[i] = songs[i];
        }
        result[result.length-1]=temp;
        return result;
    }
    public int addSongs(Song[] songs){
     int count = 0;
            if (this.Songs==null){
                this.Songs = songs;
                return songs.length;
            } else
          for (int i = 0; i < songs.length - 1; i++) {
            for (int j = 0; j < this.Songs.length; j++) {
              if (this.Songs[i].isEqual(songs[j]))
                return 0;
              else
                  arrayAppend(this.Songs, songs[j]);
              count++; }
          } return count; }

    Song[] shuffle(){
        Random rand = new Random();
        for (int i = 0; i < Songs.length; i++) {
            int randomIndexToSwap = rand.nextInt(Songs.length);
            Song temp = Songs[randomIndexToSwap];
            Songs[randomIndexToSwap] = Songs[i];
            Songs[i] = temp;
        }
        return getSongs();
    }
    Song[] sortByTitle(boolean isAscending){
        if (isAscending == true){
        for (int i = 0; i < getSongs().length; i++) {
            for (int j = i + 1; j < getSongs().length; j++) {
                if (getSongs()[i].getTitle().compareTo(getSongs()[j].getTitle()) > 0) {
                    Song temp = Songs[i];
                    getSongs()[i] = getSongs()[j];
                    getSongs()[j] = temp; }
            }
          }
        } else
            for (int i = 0; i < getSongs().length; i++) {
                for (int j = i + 1; j < getSongs().length; j++) {
                    if (getSongs()[i].getTitle().compareTo(getSongs()[j].getTitle()) < 0) {
                        Song temp = Songs[i];
                        getSongs()[i] = getSongs()[j];
                        getSongs()[j] = temp; }
                }
            } return getSongs(); }
    Song[] sortByDuration(boolean isAscending) {
        if (isAscending == true) {
            for (int i = 0; i < getSongs().length; i++) {
                for (int j = i+1; j < getSongs().length; j++) {
                    if (getSongs()[i].getDuration() > getSongs()[j].getDuration()) {
                        Song temp = Songs[i];
                        getSongs()[i] = getSongs()[j];
                        getSongs()[j] = temp; }
                }
            }
        } else
            for (int i = 0; i < getSongs().length; i++) {
               for (int j = i+1; j < getSongs().length; j++) {
            if (getSongs()[i].getDuration()<getSongs()[j].getDuration()){
                Song temp = Songs[i];
                getSongs()[i] = getSongs()[j];
                getSongs()[j] = temp; }
        }
    } return getSongs(); }
    Song[] sortByReleaseYear(boolean isAscending){
        if (isAscending == true) {
            for (int i = 0; i < getSongs().length; i++) {
                for (int j = i+1; j < getSongs().length; j++) {
                    if (getSongs()[i].getReleaseYear() > getSongs()[j].getReleaseYear()) {
                        Song temp = Songs[i];
                        getSongs()[i] = getSongs()[j];
                        getSongs()[j] = temp; }
                }
            }
        } else
            for (int i = 0; i < getSongs().length; i++) {
                for (int j = i+1; j < getSongs().length; j++) {
                    if (getSongs()[i].getReleaseYear()<getSongs()[j].getReleaseYear()){
                        Song temp = Songs[i];
                        getSongs()[i] = getSongs()[j];
                        getSongs()[j] = temp; }
                }
            } return getSongs(); }
    Song[] sortByPopularity(boolean isAscending){
        if (isAscending == true) {
            for (int i = 0; i < getSongs().length; i++) {
                for (int j = i+1; j < getSongs().length; j++) {
                    if (getSongs()[i].getLikes() > getSongs()[j].getLikes()) {
                        Song temp = Songs[i];
                        getSongs()[i] = getSongs()[j];
                        getSongs()[j] = temp; }
                }
            }
        } else
            for (int i = 0; i < getSongs().length; i++) {
                for (int j = i+1; j < getSongs().length; j++) {
                    if (getSongs()[i].getLikes()<getSongs()[j].getLikes()){
                        Song temp = Songs[i];
                        getSongs()[i] = getSongs()[j];
                        getSongs()[j] = temp; }
                }
            } return getSongs(); }
    static Song[] reverse(Song[] songs){
        for (int i = 0; i < songs.length/2; i++) {
            Song temp = songs[i];
            songs[i] = songs[songs.length-i-1];
            songs[songs.length-i-1] = temp; }
        return songs; }
    public String toString() {
        String tostring = new String();
        if (Songs.length == 0)
            return "Title:" + title + ", Release year:" + releaseYear + ",songs:{}";
        for (int i = 0; i <= getSongs().length - 1; i++) {
            if (Songs.length == 1)
                return "Title:" + title + ", Release year:" + releaseYear + ",songs:{" + getSongs()[0].toString() + "}";
            else if (i == 0)
                tostring += "'Title:'" + title + ", Release year:" + releaseYear + ",songs:{" + getSongs()[0].toString() + "|";
            else if (i < getSongs().length - 1)
                tostring += "'Title:'" + title + ", Release year:" + releaseYear + ",songs:" + getSongs()[i].toString() + "|";
            else if (i == getSongs().length - 1)
                tostring += "'Title:'" + title + ", Release year:" + releaseYear + ",songs:" + getSongs()[getSongs().length - 1].toString() + "}"; }
        return tostring; }

}

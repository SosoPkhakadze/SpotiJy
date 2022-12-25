public class Artist {
    private String firstName;
    private String lastName;
    private int birthYear;
    private Album[] albums;
    private Song[] singles;
    public Artist(String firstName, String lastName, int birthYear, Album[] albums, Song[] singles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.albums = albums;
        this.singles = singles;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getBirthYear() {
        return birthYear;
    }
    public Album[] getAlbums() {
        return albums;
    }
    public Song[] getSingles() {
        return singles;
    }
    public Song mostLikedSong() {
        int likes = albums[0].getSongs()[0].getLikes();
        Song mostlikedSong = albums[0].getSongs()[0];
        for (int i = 0; i < albums.length; i++) {
            if (albums[i].sortByPopularity(false)[0].getLikes() > likes) {
                likes = albums[i].sortByPopularity(false)[0].getLikes();
                mostlikedSong = albums[i].sortByPopularity(false)[0]; }
            for (int j = 0; j < singles.length; j++) {
                if (singles[i].getLikes() > likes) {
                    mostlikedSong = singles[i]; }
            }
        } return mostlikedSong; }
    public Song leastLikedSong() {
        int likes = albums[0].getSongs()[0].getLikes();
        Song mostlikedSong = albums[0].getSongs()[0];
        for (int i = 0; i < albums.length; i++) {
            if (albums[i].sortByPopularity(true)[0].getLikes() > likes) {
                likes = albums[i].sortByPopularity(true)[0].getLikes();
                mostlikedSong = albums[i].sortByPopularity(true)[0]; }
            for (int j = 0; j < singles.length; j++) {
                if (singles[i].getLikes() > likes) {
                    mostlikedSong = singles[i]; }
            }
        } return mostlikedSong; }
    int totalLikes(){
        int total = 0;
        for (int i = 0; i < albums.length; i++) {
            for (int j = 0; j < albums[i].getSongs().length; j++) {
                total += albums[i].getSongs()[j].getLikes(); }
        }
        for (int i = 0; i < singles.length; i++) {
            total += singles[i].getLikes();
        }

        return total; }
    boolean isEqual(Artist other){
        if(this.firstName.equals(other.firstName) && this.lastName.equals(other.lastName) &&
                this.birthYear == other.birthYear){
            return true;
        }
        else return false;
    }
    public String toString(){
        return "Name:"+firstName+lastName+",Birth year:"+birthYear+",Total likes"+
                totalLikes()+".";
    }
}

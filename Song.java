public class Song {
    private String title;
    private int releaseYear;
    private int duration;
    private int likes;
    public Song(String title, int releaseYear, int duration, int likes) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = likes;

    }
    public Song(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = 60;
        this.likes = 0;
    }
    public Song(String title, int releaseYear, int duration) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
    }
    public String getTitle() {
        return title;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public int getDuration() {
        return duration;
    }
    public int getLikes() {
        return likes;
    }
    boolean changeDuration(int duration) {
        if (duration < 0 || duration > 720) {
            return false;
        }else{
           this.duration = duration;
           return true;
        }

    }
    void like(){
           likes+=1;
    }
    void unlike(){
           likes-=1;
        if (likes < 0)
          likes = 0;
    }
    public String toString(){
        return "Title:"+title+",Duration:"+((double)(Math.round(((double)duration/60)*100))/100)+
                " minutes,Release year:"+ releaseYear+",Likes:"+likes+"";
    }
    boolean isEqual(Song other){
        if(this.title.equals(other.title) && this.releaseYear == other.releaseYear &&
           this.duration == other.duration){
            return true;
        }
        else return false;
    }
}

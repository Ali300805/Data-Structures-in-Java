import java.util.LinkedList;
import java.util.List;

public class MusicPlaylist {
    private List<String> songs;

    public MusicPlaylist() {
        this.songs = new LinkedList<>();
    }

    public void addSong(String song) {
        songs.add(song);
        System.out.println("Added: " + song);
    }

    public void removeSong(String song) {
        if (songs.remove(song)) {
            System.out.println("Removed: " + song);
        } else {
            System.out.println("Song not found: " + song);
        }
    }

    public void insertAt(int position, String song) {
        songs.add(position, song);
        System.out.println("Inserted at position " + position + ": " + song);
    }

    public void moveSong(int from, int to) {
        String song = songs.remove(from);
        songs.add(to, song);
        System.out.println("Moved " + song + " to position " + to);
    }

    public void display() {
        System.out.println("\nPlaylist:");
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }
    }

    public static void main(String[] args) {
        MusicPlaylist playlist = new MusicPlaylist();

        playlist.addSong("Song A");
        playlist.addSong("Song B");
        playlist.addSong("Song C");
        playlist.addSong("Song D");

        playlist.removeSong("Song B");

        playlist.insertAt(1, "New Song");

        playlist.moveSong(2, 0);

        playlist.display();
    }
}

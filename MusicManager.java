/*
 * Project 4
 * This program manages a music collection
 * Heather Truong
 * 6/13/23
 * CMSC 256 Section: C01
 */
package cmsc256;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MusicManager {
    //instance variable
    private List<Song> playlist;

    //constructor
    public MusicManager() {
        playlist = new ArrayList<>();
    }

    //addSong method that accepts a single Song object and adds that Song to the playlist
    public void addSong(Song song) {
        playlist.add(song);
    }

    //readPlaylistFile method
    //reads an input file and populates the List of Song
    //input file is a plain text file
    //data is formatted as one song per line with each field of data separated by colons
    //<title as file name> : <artist> : <album> : <playcount>
    public void readPlaylistFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName); //create File object
        Scanner scanner = new Scanner(file); //create Scanner object
        //while loop to reach each line of the file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //split the line using a delimiter ":"
            String[] parts = line.split(":");
            //checks if the line has all the parts (title, artist, album, and playcount)
            if (parts.length == 4) {
                String title = parts[0].trim();
                String artist = parts[1].trim();
                String album = parts[2].trim();
                int playcount = Integer.parseInt(parts[3].trim());//converts the playcount string to an integer
                //creates a new 'Song' object and adds it to the playlist
                Song song = new Song(title, artist, album, playcount);
                addSong(song);
            }
        }
        scanner.close();
    }

    //hasSongsBy method
    //a method that accepts a list of Songs and an artist name and returns true if the list contains any Songs by the given artist
    public boolean hasSongsBy(String artist) {
        for (Song song : playlist) {
            if (song.getArtist().equalsIgnoreCase(artist)) {
                return true;
            }
        }
        return false;
    }

    //getSongsBy method
    //accepts a list of Songs and an artist name and returns a sorted list of all songs by that artist
    //songs are grouped by album and for each album the songs are in alphabetical order by title
    public List<Song> getSongsBy(String artist) {
        List<Song> songsByArtist = new ArrayList<>();
        for (Song song : playlist) {
            if (song.getArtist().equalsIgnoreCase(artist)) {
                songsByArtist.add(song);
            }
        }
        //sorts the 'songsByArtist' list using Collections.sort() and 'Comparator'
        //sorts the songs by album and title
        Collections.sort(songsByArtist, Comparator.comparing(Song::getAlbum).thenComparing(Song::getTitle));

        return songsByArtist;
    }

    //getTop5Songs method
    //returns an array containing the top 5 Song obejcts with the highest playcount ordered from highest to lowest
    public Song[] getTop5Songs() {
        Song[] topSongs = new Song[Math.min(5, playlist.size())];
        playlist.sort(Comparator.comparingInt(Song::getPlaycount).reversed());
        for(int i = 0; i < topSongs.length; i++) {
            topSongs[i] = playlist.get(i);
        }
        return topSongs;
    }

    //main method
    public static void main(String[] args) {
        //test readPlaylistFile method
        MusicManager manager = new MusicManager();
        try {
            manager.readPlaylistFile("playlist.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        //test call to getTop5Songs method
        System.out.println("Top 5 Songs: ");
        for (Song song : manager.getTop5Songs()) {
            System.out.println(song);
        }

        //test call to getSongsBy method
        String artist = "The Smiths";
        System.out.println("\nSongs by " + artist + ":");
        List<Song> songsByArtist = manager.getSongsBy(artist);
        for (Song song : songsByArtist) {
            System.out.println(song);
        }

        //test hasSongsBy method
        String artistToSearch = "Lana Del Rey";
        boolean hasSongs = manager.hasSongsBy(artistToSearch);
        System.out.println("\nAre there any songs by " + artistToSearch + "? " + (hasSongs ? "Yes" : "No"));

        //testing Song class
        //creating Song objects
        Song song1 = new Song("Just Can't Get Enough", "Depeche Mode", "101", 320000);
        System.out.println("Song 1: " + song1);

        Song song2 = new Song("There is a Light That Never Goes Out", "The Smiths", "The Queen is Dead", 20000);
        System.out.println("Song 2: " + song2);

        //testing the equals method
        Song song3 = new Song("There is a Light That Never Goes Out", "The Smiths", "The Queen is Dead", 20000);
        Song song4 = new Song("Title 2", "Artist 2", "Album 2", 20);
        System.out.println("Are song1 and song2 equal? " + song1.equals(song2));
        System.out.println("Are song2 and song3 equal? " + song2.equals(song3));

        //testing the compareTo method
        System.out.println("Comparison between song1 and song2: " + song1.compareTo(song2));
        System.out.println("Comparison between song2 and song3: " + song2.compareTo(song3));

    }
}

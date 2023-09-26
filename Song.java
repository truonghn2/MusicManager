/*
 * Project 4
 * This program implements the 'Song' class
 * Heather Truong
 * 6/13/23
 * CMSC 256 Section: C01
 */
package cmsc256;

public class Song {
    //instance variables
    private String title;
    private String artist;
    private String album;
    private int playcount;

    //default constructor
    public Song() {
        title = "unknown";
        artist = "unknown";
        album = "unknown";
        playcount = 0;
    }

    //parameterized constructor
    public Song(String aTitle, String anArtist, String anAlbum, int aPlayCount) {
        title = aTitle;
        artist = anArtist;
        album = anAlbum;
        playcount = aPlayCount;
    }

    //getters and setters
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getPlaycount() {
        return playcount;
    }

    public void setTitle(String aTitle) {
        if (aTitle == null) {
            throw new IllegalArgumentException("title can't be null");
        }
        title = aTitle;
    }

    public void setArtist(String anArtist) {
        if (anArtist == null) {
            throw new IllegalArgumentException("artist can't be null");
        }
        artist = anArtist;
    }

    public void setAlbum(String anAlbum) {
        if (anAlbum == null) {
            throw new IllegalArgumentException("album can't be null");
        }
        album = anAlbum;
    }

    public void setPlaycount(int aPlayCount) {
        if (aPlayCount < 0) {
            throw new IllegalArgumentException("playcount can't be negative");
        }
        playcount = aPlayCount;
    }

    //toString method
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Album: " + album + ", Playcount: " + playcount;
    }

    //equals method
    //checks if two 'Song' objects are equal by comparing their 'title', 'artist', and 'album' fields
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Song other = (Song) obj;
        return title.equals(other.title) && artist.equals(other.artist) && album.equals(other.album);
    }

    //compareTo method
    //compares two 'Song' objects based on their 'title', 'artist' and 'album' fields
    //returns negative int if current song should be ordered before other song
    //returns positive int if it should be ordered after
    //returns 0 if it is equal
    public int compareTo(Song other) {
        int titleComparison = title.compareTo(other.title);
        if(titleComparison != 0) {
            return titleComparison;
        }
        int artistComparison = artist.compareTo(other.artist);
        if(artistComparison != 0) {
            return titleComparison;
        }
        return album.compareTo(other.album);
    }
}


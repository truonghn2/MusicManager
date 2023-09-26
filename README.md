# MusicManager
This project manages a music collection. It demonstrates knowledge of text file input and output.

addSong Method
  A method that accepts a single Song object and adds that Song to the playlist.

readPlaylistFile method
  Reads an input file and populates the List of Song. The input file is a plain text file. The data is formatted as one song per line with each field of data separated by colons in this format.

hasSongsBy method
  A method that accepts a list of Songs and an artist name and returns true if the list contains any Songs by the given artist.

getSongsBy method
  A method that accepts a list of Songs and an artist name and returns a sorted list of all songs by that artist. The songs are grouped by album and for each album, the songs are in alphabetical order by title.

getTop5Songs method
  A method that returns an array containing the top 5 Song objects with the highest play count ordered from highest to lowest play count.

package Behavioural.Iterator;

import java.util.ArrayList;
import java.util.List;

public class PlayList {

     List<String> songs;

        public PlayList(){
            songs = new ArrayList<>();
        }

        public void addSong(String song){
            songs.add(song);
        }

        public void removeSong(String song){
            songs.remove(song);
        }

        //shuffle songs

}

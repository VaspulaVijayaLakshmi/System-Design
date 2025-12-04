package Behavioural.Iterator;

public class Main {

    public static void main(String[] args) {

        PlayList playList = new PlayList();
        playList.addSong("Drake");
        playList.addSong("Eminem");


        PlayListPlayer playListPlayer = new PlayListPlayer(playList);
        System.out.println("PLay songs:");

        while(playListPlayer.hasNext()){
            System.out.println(playListPlayer.next());
        }

    }
}

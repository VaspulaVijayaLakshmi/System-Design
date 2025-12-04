package Behavioural.Iterator;

public class PlayListPlayer implements PlayListInterator{

    private PlayList playList;
    private int index;

    public PlayListPlayer(PlayList playList){
        this.playList = playList;
        this.index = 0;
    }

    public String next(){
        if(hasNext()){
            index++;
            return playList.songs.get(index);
        }

        else{
            index=0;
            return playList.songs.get(index);
        }
    }


    public boolean hasNext(){
        if(index >= playList.songs.size())
            return false;

        return true;

    }

}

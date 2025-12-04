package Structural.Proxy;

import java.util.HashMap;
import java.util.Map;

public class Proxy {

    VideoPlayer videoPlayer;
    private Map<String, String> cachedVideos = new HashMap<>();
    private Map<String, Integer> requestCounts = new HashMap<>();

    public Proxy(){
        this.videoPlayer = new VideoPlayer();
    }

    //Limit requests to 5 per video
    public boolean limitExceeded(String videoName){
        int count = requestCounts.getOrDefault(videoName, 0);

        if(count>=2){
            System.out.println("Request limit exceeded for video: " + videoName);
            return true;
        }

        else {
            requestCounts.put(videoName, count + 1);
            return false;
        }
    }

    public void play(String videoName) {

        if(limitExceeded(videoName))
            return ;

        if (cachedVideos.containsKey(videoName)) {
            System.out.println("Playing cached video: " + videoName);
        } else {
            videoPlayer.play();
            cachedVideos.put(videoName, "VideoData");
            System.out.println("Caching video: " + videoName);
        }
    }


}

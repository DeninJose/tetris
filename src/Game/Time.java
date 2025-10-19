package Game;

import java.time.LocalTime;

public class Time {
    public static int getCurrentTime(){
        return LocalTime.now().getSecond();
    }
}

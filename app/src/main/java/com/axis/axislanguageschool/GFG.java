package com.axis.axislanguageschool;


import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@RequiresApi(api = Build.VERSION_CODES.O)
public  class GFG {
   public LocalTime time2,time1;

    public GFG() {

    }

    public GFG(LocalTime time2, LocalTime time1) {
        this.time2 = time2;
        this.time1 = time1;
        Log.w("time",String.valueOf(time1));
    }
    // Parsing Time Period in the format HH:MM:SS
    public  void settime(LocalTime time2,LocalTime time1){
        time1 = LocalTime.of(18, 00, 00);
        time2 = LocalTime.of(21, 22, 00);

    }
//    Duration d = Duration.between( time1 , time2 );


        // Calculating the difference in Hours
//        long hours = ChronoUnit.HOURS.between(time1, time2);
//
//        // Calculating the difference in Minutes
//        long minutes
//                = ChronoUnit.MINUTES.between(time1, time2) % 60;
//
//        // Calculating the difference in Seconds
        long seconds
                = ChronoUnit.SECONDS.between(time1, time2) % 60;

        // Printing the difference
    public long getdiff(){

        return seconds;
    }


}
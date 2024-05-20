package Threads;


import java.util.Random;

import GameMap.GameMap;

public class TimerThread implements Runnable{
    private static volatile TimerThread instance = null;

   
    private TimerThread()
    {
    }

    public static TimerThread getInstance() {
        if (instance == null) {
            synchronized (TimerThread.class) {
                if (instance == null) {
                    instance = new TimerThread();
                }
            }
        }
        return instance;
    }

    Random rand = new Random();

    static long dayStart;
    static long tempStart;
    static long nextSunPointTime;
    static long currentTime;


    public static long getDayStart() {
        return dayStart;
    }

    public static long setDayStart(long dayStart) {
        return TimerThread.dayStart = dayStart;
    }

    public static long getTempStart() {
        return tempStart;
    }

    public static long getNextSunPointTime() {
        return nextSunPointTime;
    }

    public static long getCurrentTime() {
        return currentTime;
    }

    public static long setCurrentTime(long currentTime) {
        return TimerThread.currentTime = currentTime;
    }

    boolean gameRunning = true;

    GameMap map = GameMap.getInstance();
    @Override
    public void run()
    {
        boolean gameRunning = true;

        long dayStart = System.currentTimeMillis();
        setDayStart(dayStart);
        // long tempStart = dayStart;
        // long nextSunPointTime = 5 + rand.nextInt(6);
        while (gameRunning)
        {

            if(map.isProtectedBaseCompromised()) //? ini jga sama bisa pake factory cman nanti aja
            {
                // System.out.println("Message from timer thread");
                // System.out.println("Timer say protected Base is compromised! Game Over!");
                break;
            }
            long currentTime = System.currentTimeMillis();
            setCurrentTime(currentTime);

            // System.out.println("Current Time from Timer Thread: " + currentTime);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                // System.out.println("Timer Loop Interrupted");
                setDayStart(0);
                setCurrentTime(0);
                gameRunning = false;
                return;
            }
        }
    }
    
}

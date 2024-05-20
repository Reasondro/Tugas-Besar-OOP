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
    static long globalTimeElapsed;


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

    public static long getGlobalTimeElapsed() {
        return globalTimeElapsed;
    }

    public static void setGlobalTimeElapsed(long globalTimeElapsed) {
        TimerThread.globalTimeElapsed = globalTimeElapsed;
    }

    boolean gameRunning = true;

    GameMap map = GameMap.getInstance();
    @Override
    public void run()
    {
        boolean gameRunning = true;

        long dayStart = System.currentTimeMillis();
        setDayStart(dayStart);
        tempStart = dayStart;

        while (gameRunning)
        {
            long currentTime = System.currentTimeMillis();
            setCurrentTime(currentTime);
            long timeElapsed = (currentTime - tempStart) / 1000;
            setGlobalTimeElapsed(timeElapsed);

            if (timeElapsed >= 200) 
            {
                tempStart = currentTime;
                continue;
            }

            if(ZombieThread.globalIsAllZombiesDead() && (timeElapsed > 21 && timeElapsed <= 160))
            {
                gameRunning = false;
                System.out.println("");
                System.out.println("All zombies are dead, you won!");
                System.out.println("Press any key to go back to main menu");
                map.refreshMap();
                break;
            }

            if(map.isProtectedBaseCompromised()) //? ini jga sama bisa pake factory cman nanti aja
            {
                // System.out.println("Message from timer thread");
                gameRunning = false;
                System.out.println("");
                System.out.println("Protected Base is compromised, you lost!");
                System.out.println("Press any key to go back to main menu");
                map.refreshMap();
                break;
            }
 


           

            // System.out.println("Current Time from Timer Thread: " + currentTime);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println("Timer Loop Interrupted");
                // setDayStart(0);
                // setCurrentTime(0);
                // gameRunning = false;
                return;
            }
        }
    }
    
}

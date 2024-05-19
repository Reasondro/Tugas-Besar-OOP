package Threads;


import java.util.Random;

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
    
    long dayStart;
    long tempStart;
    long nextSunPointTime;
    long currentTime;


    public long getDayStart() {
        return dayStart;
    }

    public long getTempStart() {
        return tempStart;
    }

    public long getNextSunPointTime() {
        return nextSunPointTime;
    }

    public long getCurrentTime() {
        return currentTime;
    }


    @Override
    public void run()
    {
        long dayStart = System.currentTimeMillis();
        long tempStart = dayStart;
        long nextSunPointTime = 5 + rand.nextInt(6);
        while (true)
        {
            long currentTime = System.currentTimeMillis();
            long timeElapsed = (currentTime - tempStart) / 1000; 

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println("Timer Loop Interrupted");
                return;
            }
        }
    }
    
}

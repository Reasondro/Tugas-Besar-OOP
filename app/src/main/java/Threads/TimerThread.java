package Threads;

public class TimerThread implements Runnable{
    private static volatile TimerThread instance = null;

    long  dayStart;

    private TimerThread()
    {
        dayStart = System.currentTimeMillis();
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



    @Override
    public void run()
    {
        long dayStart = System.currentTimeMillis();
        long tempStart = dayStart;
        long nextSunPointTime = 5 + (int)(Math.random() * 6);
        while (true)
        {
            long currentTime = System.currentTimeMillis();
            if (currentTime - tempStart >= 1000)
            {
                tempStart = currentTime;
                System.out.println("Time: " + (currentTime - dayStart) / 1000 + " seconds");
            }
            if (currentTime - dayStart >= nextSunPointTime * 1000)
            {
                System.out.println("Sun points +25");
                nextSunPointTime = 5 + (int)(Math.random() * 6);
            }
        }
    }
    
}

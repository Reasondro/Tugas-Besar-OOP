import java.util.*;

import GameMap.GameMap;

import Threads.*;

public class GameAle{
    public static void main(String[] args)
    {
        GameMap map = GameMap.getInstance();

        long  dayStart = 0;
        boolean isRunning = true;
        Scanner input = new Scanner(System.in);
        String userInput;

        Thread plantThread = new Thread(new PlantThread());
        Thread zombieThread = new Thread(new ZombieThread());

        while(isRunning)
        {
            userInput = input.nextLine();
            if(userInput.equals("exit"))
            {
                plantThread.interrupt();
                zombieThread.interrupt();
                map.resetMap();
            }
            else if(userInput.equals("start"))
            {
                plantThread = new Thread(new PlantThread());
                zombieThread =new Thread(new ZombieThread());

                dayStart = System.currentTimeMillis();
                plantThread.start();
                zombieThread.start();
            }
            else if(userInput.equals("print"))
            {
                final long currentTime = System.currentTimeMillis() - dayStart;
                final long elapsedSeconds = currentTime/1000;
                final long secondsDisplay = elapsedSeconds % 60;
                final long minutesDisplay = elapsedSeconds / 60;
                System.out.println("Time right now "+ minutesDisplay + ":" + secondsDisplay);
                map.printMap();
            }
            else
            {
                System.out.println("Hello " + userInput + "!");
            }

        }
        input.close();
}
}



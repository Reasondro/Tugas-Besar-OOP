import java.util.*;


public class Game {
    public static void main(String[] args) {
        Game concurrency = new Game();
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    concurrency.gameLoop();
                    Thread.sleep(1000); // Sleep for 1 second
                }
            } catch (InterruptedException e) {
                System.out.println("Game Loop Interrupted");
            }
        });
        thread.start();

        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while (isRunning) {
            userInput = scanner.nextLine();
            if (userInput.equals("exit")) {
                isRunning = false;
                thread.interrupt();
                break;
            } else {
                System.out.println("Hello " + userInput + "!");
            }
        }

        scanner.close();
    }

    public void gameLoop() {
        // System.out.println("Game Loop");
    }
}
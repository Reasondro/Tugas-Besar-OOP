package Menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Zombies.Zombie;

public class Menu {
    private static ArrayList<Zombie> listZombies = new ArrayList<Zombie>();
    private static boolean isGameStarted = false;
    // private static Zombie currentZombie;
    private static Scanner input = new Scanner(System.in);
    private static boolean isAddZombie = false;
    // private static boolean isStart = true;

    public static void start() {
        // addZombie();
        isGameStarted = true;
        while (isGameStarted) {
            showInGameMenu();
        }
    }

    public static void addZombie(Zombie z) {
        listZombies.add(z);
    }

    public static void clearTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setAddZombie(boolean isAddZombie) {
        Menu.isAddZombie = isAddZombie;
    }

    public static void showGameMenu() {
        try {
            System.out.println("Selamat datang di Plant VS Zombie!");
            System.out.println("Silakan pilih menu yang tersedia:");
            System.out.println("1. Start Game");
            System.out.println("2. Help");
            System.out.println("0. Exit Game");
            System.out.print("Masukkan pilihan Anda (angka saja) : ");
            int input1 = input.nextInt();
            input.nextLine();
            System.out.print("Masukkan pilihan Anda (1/2/0): ");
            
            switch (input1) {
                case 1:
                    clearTerminal();
                    NewGameOrLoadGame();
                    break;
                case 2:
                    clearTerminal();
                    help();
                    showGameMenu();
                    break;
                case 0:
                    clearTerminal();
                    System.out.println("Terima kasih telah bermain Plant VS Zombie!");
                    System.exit(0);
                    break;
                default:
                    clearTerminal();
                    System.out.println("Pilihan tidak tersedia.");
                    System.out.println("Tekan Enter untuk melanjutkan...");
                    input.nextLine();
                    clearTerminal();
                    showGameMenu();
                    break;
            }
        } catch (InputMismatchException e) {
            clearTerminal();
            System.out.println("Masukan tidak valid. Silakan masukkan angka.");
            System.out.println("Tekan Enter untuk melanjutkan...");
            input.nextLine();
            clearTerminal();
            showGameMenu();
        }
        input.close();
    }

    public static void NewGameOrLoadGame() {
        try {
            System.out.println("Silakan pilih menu yang tersedia :");
            System.out.println("1. New Game");
            System.out.println("2. Load Game");
            System.out.println("0. Kembali");
            System.out.print("Masukkan pilihan Anda (Angka saja) : ");
            int input2 = input.nextInt();
            input.nextLine(); // hati-hati
            switch (input2) {
                case 1:
                    clearTerminal();
                    // addZombie();
                    System.out.println("Tekan Enter untuk melanjutkan...");
                    input.nextLine();
                    clearTerminal();
                    showInGameMenu();
                    break;
                case 2:
                    // AllData.load() --> kalo mau ada fungsi load
                    showInGameMenu();
                    break;
                case 0:
                    clearTerminal();
                    showGameMenu();
                    break;
                default:
                    clearTerminal();
                    System.out.println("Pilihan tidak tersedia.");
                    System.out.println("Tekan Enter untuk melanjutkan...");
                    input.nextLine();
                    input.nextLine();
                    clearTerminal();
                    NewGameOrLoadGame();
                    break;
            }
        } catch (InputMismatchException e) {
            clearTerminal();
            System.out.println("Masukan tidak valid. Silakan masukkan angka.");
            System.out.println("Tekan Enter untuk melanjutkan...");
            input.nextLine();
            input.nextLine();
            clearTerminal();
            NewGameOrLoadGame();
        }
    }

    public static void showInGameMenu(){
        try{ 
            System.out.println("Silakan pilih menu yang tersedia :");
            for (int i = 1; i <= 10; i++) {
                System.out.printf("%2d. %-25s", i, getMenuOption(i));
                if (i + 10 <= 19) {
                    System.out.printf("%2d. %s", i + 10, getMenuOption(i + 10));
                }
                System.out.println();
            }
            System.out.print("Masukkan pilihan Anda (Angka saja) : ");
            int input3 = input.nextInt();
            input.nextLine();

            switch (input3) {
                case 1:
                    clearTerminal();
                    // sesuaiin sama getMenuoption
                    System.out.println("Tekan Enter untuk melanjutkan...");
                    input.nextLine();
                    clearTerminal();
                    showInGameMenu();
                    break;
                case 2 : //tanya dulu
                default:
                        clearTerminal();
                        System.out.println("Pilihan tidak tersedia.");
                        System.out.println("Tekan Enter untuk melanjutkan...");
                        input.nextLine();
                        clearTerminal();
                        showInGameMenu();
                        break;
                }
            } catch (InputMismatchException e) {
                clearTerminal();
                System.out.println("Input harus berupa angka!");
                System.out.println("Tekan Enter untuk melanjutkan...");
                input.nextLine();
                clearTerminal();
                showInGameMenu();
            }
        }
            

    public static String getMenuOption(int option) {
        switch (option) {
            case 1:
                return "...";
            case 2:
                return "...";
            case 3:
                return "...";
            case 4:
                return "...";
            case 5:
                return "...";
            case 6:
                return "...";
            // masih banyak bentar blom tanya di game bisa apa aja
            default:
                return "";
        }
    }

    public static void help() {
        boolean end = false;
        int input4;

        while (!end) {
            System.out.println("Silakan pilih menu yang tersedia :");
            System.out.println("1. Apa itu Plant vs Zombie?");
            System.out.println("2. Bagaimana cara memulai game ini?");
            System.out.println("3. Tentang Zombie");
            System.out.println("4. Tentang Plant");
            System.out.println("0. Close\n");

            System.out.print("Masukkan pilihan Anda (Angka saja) : ");
            input4 = input.nextInt();
            if (input4 == 1){
                System.out.println("jelasin pvz");
            }else if (input4 == 2) {
                System.out.println("tulis tutor game");
            } else if (input4 == 3) {
                System.out.println("mention all zombies n desc");
            } else if (input4 == 4) {
                System.out.println("mention all plants n desc");
            } else if (input4 == 0) {
                end = true;
            }
        }
    }

    public static void exit() {
        System.out.println("Terima kasih telah memainkan Plant VS Zombie");
        System.exit(0);
    }
}

public class Title {
    public static void Main() {
        // Call the method to print ASCII art with color
        Welcome.to();
        Michael.printMichael();
        Vs.printVs();
        Lalapan.printLalapan();
        Border.to();
    }
}

class AsciiArtWithColor {
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";

    public static void welcome() { // Corrected method name to lower case
        String[] art = {
            " __      _____________.____   _________  ________      _____  ___________._.",
            "/  \\    /  \\_   _____/|    |  \\_   ___ \\ \\_____  \\    /     \\ \\_   _____/| |",
            "\\   \\/\\/   /|    __)_ |    |  /    \\  \\/  /   |   \\  /  \\ /  \\ |    __)_ | |",
            " \\        / |        \\|    |__\\     \\____/    |    \\/    Y    \\|        \\ \\|",
            "  \\__/\\  / /_______  /|_______ \\______  /\\_______  /\\____|__  /_______  / __",
            "       \\/          \\/         \\/      \\/         \\/         \\/        \\/  \\/"
        };

        String[] colors = {RED, GREEN, YELLOW, BLUE, PURPLE, CYAN};

        for (int i = 0; i < art.length; i++) {
            System.out.println(colors[i % colors.length] + art[i] + RESET);
        }
    }
}

class Michael {
    // ANSI escape codes for colors
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String WHITE = "\033[0;37m";

    public static void printMichael() {
        String[] asciiArt = {
            " _   .-')                       ('-. .-.   ('-.       ('-.            ",
            "( '.( OO )_                    ( OO )  /  ( OO ).-. _(  OO)           ",
            " ,--.   ,--.) ,-.-')   .-----. ,--. ,--.  / . --. /(,------.,--.      ",
            " |   `.'   |  |  |OO) '  .--./ |  | |  |  | \\-.  \\  |  .---'|  |.-')  ",
            " |         |  |  |  \\ |  |('-. |   .|  |.-'-'  |  | |  |    |  | OO ) ",
            " |  |'.'|  |  |  |(_//_) |OO  )|       | \\| |_.'  |(|  '--. |  |`-' | ",
            " |  |   |  | ,|  |_.'||  |`-'| |  .-.  |  |  .-.  | |  .--'(|  '---.' ",
            " |  |   |  |(_|  |  (_'  '--'\\ |  | |  |  |  | |  | |  `---.|      |  ",
            " `--'   `--'  `--'     `-----' `--' `--'  `--' `--' `------'`------'  "
        };

        // Print the ASCII art with colors
        for (String line : asciiArt) {
            // Split each line into characters to add color alternation
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                // Alternate between white and red
                if (i % 2 == 0) {
                    System.out.print(WHITE + ch);
                } else {
                    System.out.print(RED + ch);
                }
            }
            // Reset color and move to the next line
            System.out.println(RESET);
        }
    }
}

class Vs {
    public static void printVs() {
        String[] asciiArt = {
            "                           _  _  ____",
            "                          / )( \\/ ___)",
            "                          \\ \\/ /\\___ \\",
            "                           \\__/ (____/"
        };
        final String RESET = "\033[0m";
        final String WHITE = "\033[0;37m";

        // Print the ASCII art with white color
        for (String line : asciiArt) {
            System.out.println(WHITE + line + RESET);
        }
    }
}

class Lalapan {
    public static void printLalapan() {
        String[] asciiArt = {
            "           _       ____  _       ____  ____   ____  ____  ",
            "          | |     /    || |     /    ||    \\ /    ||    \\ ",
            "          | |    |  o  || |    |  o  ||  o  )  o  ||  _  |",
            "          | |___ |     || |___ |     ||   _/|     ||  |  |",
            "          |     ||  _  ||     ||  _  ||  |  |  _  ||  |  |",
            "          |     ||  |  ||     ||  |  ||  |  |  |  ||  |  |",
            "          |_____||__|__||_____||__|__||__|  |__|__||__|__|"
        };

        // Gradasi warna hijau
        String[] colors = {
            "\033[0;32m", "\033[0;32m", "\033[0;32m", "\033[0;32m", "\033[0;32m", "\033[0;32m", "\033[0;32m"
        };

        final String RESET = "\033[0m";

        // Print ASCII art dengan gradasi warna hijau
        for (int i = 0; i < asciiArt.length; i++) {
            System.out.println(colors[i] + asciiArt[i] + RESET);
        }
    }
}

class Welcome {
    public static void to() {
        String white = "\u001B[37m";
        String reset = "\u001B[0m";
        
        String[] art = {
            " ╦ ╦┌─┐┬  ┌─┐┌─┐┌┬┐┌─┐  ╔╦╗┌─┐",
            " ║║║├┤ │  │  │ ││││├┤    ║ │ │",
            " ╚╩╝└─┘┴─┘└─┘└─┘┴ ┴└─┘   ╩ └─┘",
            " ================================================================== "
        };

        // Adjust the ASCII art position
        int consoleWidth = 80; // Assuming console width of 80 characters
        int shiftLeft = 8; // Shift 8 characters to the left
        for (String line : art) {
            int padding = (consoleWidth - line.length()) / 2 - shiftLeft;
            System.out.print(white); // Set color to white
            System.out.println(" ".repeat(Math.max(padding, 0)) + line);
        }
        System.out.print(reset); // Reset color
    }

    public static void main(String[] args) {
        to();
    }
}

class Border {
    public static void to() {
        String white = "\u001B[37m";
        String reset = "\u001B[0m";
        
        String[] art = {
            " ================================================================== "
        };

        // Adjust the ASCII art position
        int consoleWidth = 80; // Assuming console width of 80 characters
        int shiftLeft = 8; // Shift 8 characters to the left
        for (String line : art) {
            int padding = (consoleWidth - line.length()) / 2 - shiftLeft;
            System.out.print(white); // Set color to white
            System.out.println(" ".repeat(Math.max(padding, 0)) + line);
        }
        System.out.print(reset); // Reset color
    }

    public static void main(String[] args) {
        to();
    }
}
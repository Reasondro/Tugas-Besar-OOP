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

class Welcome {
    public static void to() {
        String[] asciiArt = {
            " _    _      _                            _____     ",
            "| |  | |    | |                          |_   _|    ",
            "| |  | | ___| | ___ ___  _ __ ___   ___    | | ___  ",
            "| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\   | |/ _ \\ ",
            "\\  /\\  /  __/ | (_| (_) | | | | | |  __/   | | (_) |",
            " \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|   \\_/\\___/ ",
            "                                                    ",
            "                                                    ",
            "============================================================================ "
        };

        int consoleWidth = 80; // lebar konsol
        int shiftLeft = 4; // jumlah karakter untuk menggeser ke kiri
        for (String line : asciiArt) {
            int padding = (consoleWidth - line.length()) / 2 - shiftLeft;
            if (padding < 0) padding = 0;
            for (int i = 0; i < padding; i++) {
                System.out.print(" ");
            }
            System.out.println(line);
        }
    }
}

<<<<<<< HEAD
=======


>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b
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

<<<<<<< HEAD
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
=======
// class Welcome {
//     public static void to() {
//         String white = "\u001B[37m";
//         String reset = "\u001B[0m";
        
//         String[] art = {
//             " ╦ ╦┌─┐┬  ┌─┐┌─┐┌┬┐┌─┐  ╔╦╗┌─┐",
//             " ║║║├┤ │  │  │ ││││├┤    ║ │ │",
//             " ╚╩╝└─┘┴─┘└─┘└─┘┴ ┴└─┘   ╩ └─┘",
//             " ================================================================== "
//         };

//         // Adjust the ASCII art position
//         int consoleWidth = 80; // Assuming console width of 80 characters
//         int shiftLeft = 8; // Shift 8 characters to the left
//         for (String line : art) {
//             int padding = (consoleWidth - line.length()) / 2 - shiftLeft;
//             System.out.print(white); // Set color to white
//             System.out.println(" ".repeat(Math.max(padding, 0)) + line);
//         }
//         System.out.print(reset); // Reset color
//     }

//     public static void main(String[] args) {
//         to();
//     }
// }
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b

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
<<<<<<< HEAD
}







=======
}
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b

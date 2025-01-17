package cwq.cliui;

import java.util.Scanner;

/**
 * Ui class deals with interactions with users
 */
public class Ui {
    private static final String SPLIT_LINE = "*".repeat(80);
    private final Scanner sc = new Scanner(System.in);

    /**
     * Says hi to the user.
     */
    public void startGreeting() {
        System.out.println(Ui.SPLIT_LINE);
        System.out.println("Hello, I'm Duke. What can I do for you?");
        System.out.println(Ui.SPLIT_LINE);
    }

    /**
     * Prints the given text.
     * @param s message to be prompted
     */
    public void respond(String s) {
        System.out.println(s);
    }

    /**
     * Gets user's choice for command.
     * @return user's input command
     */
    public String inputCommand() {
        return sc.nextLine();
    }

    /**
     * Prints the split line.
     */
    public void showSplitLine() {
        System.out.println(Ui.SPLIT_LINE);
    }

    public void continueChat() {
        System.out.println("Hi, what can I do for you?");
    }
}

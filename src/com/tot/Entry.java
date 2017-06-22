package com.tot;

import java.util.regex.Pattern;

public class Entry {
    private ConsoleInputOutput console;
    private Universe universe;

    public Entry(ConsoleInputOutput console, Universe universe) {
        this.console = console;
        this.universe = universe;
    }

    public void start() {
        console.displayMessage(ConsoleMessages.WELCOME_MSG);
        console.displayMessage(ConsoleMessages.INSTRUCTIONS);
        console.displayMessage(ConsoleMessages.CONFIRM_GAME);
        String input = console.getUserInput();

        while (ConsoleMessages.YES.equalsIgnoreCase(input)) {
            MessageFromBallot();
            console.displayMessage("Wish to continue (Y/N) ??");
            input = console.getUserInput();
        }
        universe.findRuler();
        console.displayMessage(universe.showRulerName());
        console.displayMessage(universe.showRulerAllies());
    }

    private void MessageFromBallot() {
        console.displayMessage(ConsoleMessages.ENTER_MESSAGE);
        String msg = console.getUserInput();
        String[] msgParts = msg.split(Pattern.quote("|"));
        while ( msgParts.length != 3 ){
            console.displayMessage("Ballot msg is not in proper format.");
            return;
        }

        String sender = msgParts[0];
        String receiver = msgParts[1];
        String secretMsg = msgParts[2];

        if (!universe.isValidKingdom(sender.toLowerCase()) && !universe.isValidKingdom(sender.toLowerCase())) {
            console.displayMessage("Kingdom name is not valid!!!");
            return;
        }

        universe.send(
                sender.toLowerCase(),
                receiver.toLowerCase(),
                secretMsg.toLowerCase()
        );
    }

}

package com.naveenkumarrm.moveX;

import com.naveenkumarrm.moveX.feature.dashboard.DashboardView;
import com.naveenkumarrm.moveX.feature.signin.SignInView;
import com.naveenkumarrm.moveX.feature.signup.SignUpView;
import com.naveenkumarrm.moveX.util.ConsoleInput;

public class MoveXApplication {
    private final ConsoleInput consoleInput = ConsoleInput.getInstance();

    public void start() {
        printBanner();
        boolean running = true;
        while (running) {
            System.out.println("1. Sign In");
            System.out.println("2. Sign Up");
            System.out.println("0. Exit");
            int option = consoleInput.readInt("Choose option: ");
            switch (option) {
                case 1:
                    boolean success = new SignInView().init();
                    if (success) {
                        new DashboardView().init();
                    }
                    break;
                case 2:
                    new SignUpView().init();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting MoveX. Bye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
            System.out.println();
        }
    }

    private void printBanner() {
        System.out.println("============================");
        System.out.println("      MoveX Console App     ");
        System.out.println("============================");
    }
}

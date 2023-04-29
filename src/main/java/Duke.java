import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Scanner command = new Scanner(System.in);


        while(true) {
          System.out.println("\nDuke: What can I do for you?\n");
  
          String commandReceived = command.nextLine();
  
          if (commandReceived.equals("bye")) {
            System.out.println("Duke: Bye. Hope to see you again soon!");
            break;
          }

          System.out.println("Duke: " + commandReceived);
      }
    }
}

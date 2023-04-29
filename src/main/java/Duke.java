import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        String[] userList = new String[100];

        Scanner command = new Scanner(System.in);


        while(true) {
          System.out.println("\nDuke: What can I do for you?\n");
  
          String commandReceived = command.nextLine();
  
          if (commandReceived.equals("bye")) {
            System.out.println("Duke: Bye. Hope to see you again soon!");
            break;
          }

          if (commandReceived.equals("list")) {
            for (int i = 0; i < userList.length; i++) {
              if (userList[i] == null) {
                break;
              };
              System.out.println(i + 1 + ". " + userList[i]);
            }
            continue;
          }

          for (int i = 0; i < userList.length; i++) {
            if (userList[i] == null) {
              userList[i] = commandReceived;
              break;
            };
          }

          System.out.println("Duke added: " + commandReceived);
      }
    }
}

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Task[] userList = new Task[100];

        Scanner command = new Scanner(System.in);


        while(true) {
          System.out.println("\nDuke: What can I do for you?\n");
  
          String commandReceived = command.nextLine();
  
          String[] checkForMark = commandReceived.split(" ");

          if (checkForMark[0].equals("mark")) {
            int taskNumber = Integer.parseInt(checkForMark[1]) - 1;
            userList[taskNumber].mark();
            System.out.println("Nice! I've marked this task as done:\n" + "[" + userList[taskNumber].getStatusIcon() + "] " + userList[taskNumber].getDescription());
            continue;
          }

          if (checkForMark[0].equals("unmark")) {
            int taskNumber = Integer.parseInt(checkForMark[1]) - 1;
            userList[taskNumber].unmark();
            System.out.println("OK, I've marked this task as not done yet:\n" + "[" + userList[taskNumber].getStatusIcon() + "] " + userList[taskNumber].getDescription());
            continue;
          }

          if (commandReceived.equals("bye")) {
            System.out.println("Duke: Bye. Hope to see you again soon!");
            break;
          }

          if (commandReceived.equals("list")) {
            for (int i = 0; i < userList.length; i++) {
              if (userList[i] == null) {
                break;
              };
              System.out.println(i + 1 + ". " + "[" + userList[i].getStatusIcon() + "] " + userList[i].getDescription());
            }
            continue;
          }

          for (int i = 0; i < userList.length; i++) {
            if (userList[i] == null) {
              Task t = new Task(commandReceived);
              userList[i] = t;
              break;
            };
          }

          System.out.println("Duke added: " + commandReceived);
      }
    }
}

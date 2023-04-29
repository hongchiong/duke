import java.util.Scanner;
import java.util.Arrays;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        int numberOfTask = 0;

        Task[] userList = new Task[100];

        Scanner command = new Scanner(System.in);


        while(true) {
          System.out.println("\nDuke: What can I do for you?\n");
  
          String commandReceived = command.nextLine();
  
          String[] commandStrArray = commandReceived.split(" ");

          if (commandStrArray[0].equals("mark")) {
            int taskNumber = Integer.parseInt(commandStrArray[1]) - 1;
            userList[taskNumber].mark();
            System.out.println("Nice! I've marked this task as done:\n" + userList[taskNumber].toString());
            continue;
          }

          if (commandStrArray[0].equals("unmark")) {
            int taskNumber = Integer.parseInt(commandStrArray[1]) - 1;
            userList[taskNumber].unmark();
            System.out.println("OK, I've marked this task as not done yet:\n" + userList[taskNumber].toString());
            continue;
          }

          if (commandStrArray[0].equals("todo")) {
            String[] todoStrArr = Arrays.copyOfRange(commandStrArray, 1, commandStrArray.length);
            String todo = String.join(" ", todoStrArr);
            
            Todo t = new Todo(todo);
            userList[numberOfTask] = t;
            numberOfTask = numberOfTask + 1;

            System.out.println("Got it. I've added this task:\n" + t.toString() + "\nNow you have " + numberOfTask + " tasks in the list.");
            continue;
          }

          if (commandStrArray[0].equals("deadline")) {
            int indexOfBy = commandStrArray.length;

            for (int i = 0; i < commandStrArray.length; i++) {
              if (commandStrArray[i].equals("/by")) {
                indexOfBy = i;
              }
            }

            String[] deadlineStrArr = Arrays.copyOfRange(commandStrArray, 1, indexOfBy);
            String[] byStrArr = Arrays.copyOfRange(commandStrArray, indexOfBy + 1, commandStrArray.length);
            String deadline = String.join(" ", deadlineStrArr);
            String by = String.join(" ", byStrArr);
            
            Deadline t = new Deadline(deadline, by);
            userList[numberOfTask] = t;
            numberOfTask = numberOfTask + 1;

            System.out.println("Got it. I've added this task:\n" + t.toString() + "\nNow you have " + numberOfTask + " tasks in the list.");
            continue;
          }

          if (commandStrArray[0].equals("event")) {
            int indexOfFrom = commandStrArray.length;
            int indexOfTo = commandStrArray.length;

            for (int i = 0; i < commandStrArray.length; i++) {
              if (commandStrArray[i].equals("/from")) {
                indexOfFrom = i;
              }
              
              if (commandStrArray[i].equals("/to")) {
                indexOfTo = i;
              }
            }

            String[] eventStrArr = Arrays.copyOfRange(commandStrArray, 1, indexOfFrom);
            String[] fromStrArr = Arrays.copyOfRange(commandStrArray, indexOfFrom + 1, indexOfTo);
            String[] toStrArr = Arrays.copyOfRange(commandStrArray, indexOfTo + 1, commandStrArray.length);

            String event = String.join(" ", eventStrArr);
            String from = String.join(" ", fromStrArr);
            String to = String.join(" ", toStrArr);

            
            Event t = new Event(event, from, to);
            userList[numberOfTask] = t;
            numberOfTask = numberOfTask + 1;

            System.out.println("Got it. I've added this task:\n" + t.toString() + "\nNow you have " + numberOfTask + " tasks in the list.");
            continue;
          }

          if (commandReceived.equals("bye")) {
            System.out.println("Duke: Bye. Hope to see you again soon!");
            break;
          }

          if (commandReceived.equals("list")) {
            for (int i = 0; i < numberOfTask; i++) {
              System.out.println(i + 1 + ". " + userList[i].toString());
            }
            continue;
          }

          Task t = new Task(commandReceived);
          userList[numberOfTask] = t;
          numberOfTask = numberOfTask + 1;

          System.out.println("Got it. I've added this task:\n" + t.toString() + "\nNow you have " + numberOfTask + " tasks in the list.");
      }
    }
}

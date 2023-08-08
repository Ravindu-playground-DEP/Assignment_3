import java.util.Scanner;

public class Assignment_3 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        final String COLOR_RED_BOLD = "\u001B[1;31m";
        final String COLOR_BLUE_BOLD = "\u001B[1;34m";
        final String COLOR_YELLOW_BOLD = "\u001B[1;33m";
        final String COLOR_GREEN_BOLD = "\u001B[1;32m";
        final String RESET = "\u001B[0m";
        
        String name;
        int age;
        String subject1;
        String subject2;
        String subject3;
        double marks1;
        double marks2;
        double marks3;

        final String ERROR_MSG = String.format ("%s%s%s \n", COLOR_RED_BOLD, "%s", RESET);

        app:{
            System.out.print("Enter your name:");
            name = scanner.nextLine().strip();

            if(name.length() == 0){
                System.out.printf(ERROR_MSG, "Name cannot be Empty");
                break app;
            }

            System.out.print("Enter your age: ");
            age = scanner.nextInt();
            scanner.nextLine();
            // scanner.skip(System.lineSeparator());

            if (age<10 || age>18){
                System.out.printf(ERROR_MSG, "Invalid age");
                break app;
            }
            /*Subject 1 */
            System.out.print("Enter subject1: ");
            subject1 = scanner.nextLine().strip();
            if(subject1.isBlank()){
                System.out.printf(ERROR_MSG, "Subject 1 cannot be empty");
                break app;
            } else if(!subject1.startsWith("SE-")) {
                System.out.printf(ERROR_MSG, "Invalid subject 1");
                break app;
            }

            System.out.printf("Enter marks for %s: ", subject1);
            marks1 = scanner.nextDouble();
            scanner.nextLine();

            if (marks1 < 0 || marks1 > 100){
                System.out.printf(ERROR_MSG, "Invalid marks for subject 1");
                break app;
            }

            /*Subject 2 */
            System.out.print("Enter subject2: ");
            subject2 = scanner.nextLine().strip();
            if(subject2.isBlank()){
                System.out.printf(ERROR_MSG, "Subject 2 cannot be empty");
                break app;
            } else if(!subject1.startsWith("SE-")) {
                System.out.printf(ERROR_MSG, "Invalid subject 2");
                break app;
            } else if(subject2 == subject1){
                System.out.printf(ERROR_MSG, "Invalid subject: subject already exist ");
                break app;
            }

            System.out.printf("Enter marks for %s: ", subject2);
            marks2 = scanner.nextDouble();
            scanner.nextLine();

            if (marks2 < 0 || marks2 > 100){
                System.out.printf(ERROR_MSG, "Invalid marks for subject 2");
                break app;
            }

            /*Subject 3 */
            System.out.print("Enter subject3: ");
            subject3 = scanner.nextLine().strip();
            if(subject3.isBlank()){
                System.out.printf(ERROR_MSG, "Subject 3 cannot be empty");
                break app;
            } else if(!subject3.startsWith("SE-")) {
                System.out.printf(ERROR_MSG, "Invalid subject 3");
                break app;
            } else if (subject3 == subject1 || subject3 == subject2){
                System.out.printf(ERROR_MSG, "Invalid subject: subject already exist ");
                break app;
            }

            System.out.printf("Enter marks for %s: ", subject3);
            marks3 = scanner.nextDouble();
            scanner.nextLine();

            if (marks3 < 0 || marks3 > 100){
                System.out.printf(ERROR_MSG, "Invalid marks for subject 3");
                break app;
            }

                Double total = marks1 + marks2 + marks3;
            double avg = total/3;

            String status;          //overall status
            String subject1status;
            String subject2status;
            String subject3status;

            final String DISTINGUISHED_PASS = COLOR_BLUE_BOLD + "Distinguished pass (DP)" + RESET;
            final String CREDIT_PASS = COLOR_GREEN_BOLD + "Credit pass (CP)" + RESET;
            final String PASS = COLOR_YELLOW_BOLD + "Pass (P)" + RESET;
            final String FAIL = COLOR_RED_BOLD + "Fail (F)" + RESET;

            /*Determine overall status*/
            if (avg > 75) status = "Distinguished pass (DP)";
            else if (avg >=65) status = "Credit pass (CP)";
            else if (avg >= 55) status = "Pass (P)";
            else status = "Fail (F)";

            /*subject 1 status*/
            if (marks1 > 75) subject1status = DISTINGUISHED_PASS;
            else if (marks1 >=65) subject1status = CREDIT_PASS;
            else if (marks1 >= 55) subject1status = PASS;
            else subject1status = FAIL;

            /*subject 2 status*/
            if (marks2 > 75) subject2status = DISTINGUISHED_PASS;
            else if (marks2 >=65) subject2status = CREDIT_PASS;
            else if (marks2 >= 55) subject2status = PASS;
            else subject2status = FAIL;

            /*subject 3 status*/
            if (marks3 > 75) subject3status = DISTINGUISHED_PASS;
            else if (marks3 >=65) subject3status = CREDIT_PASS;
            else if (marks3 >= 55) subject3status = PASS;
            else subject3status = PASS;

            subject1 = String.format("SE-%03d",Integer.valueOf(subject1.substring(3)));
            subject2 = String.format("SE-%03d",Integer.valueOf(subject2.substring(3)));
            subject3 = String.format("SE-%03d",Integer.valueOf(subject3.substring(3)));

            name = String.format("%s%s%s",COLOR_BLUE_BOLD, name.toUpperCase(), RESET);

            /*Generate the table*/
            System.out.println("+".concat("-".repeat(50)).concat("+"));
            System.out.printf("|%10s: %-49s|\n", "Name", name);
            System.out.printf("|%10s: %-38s|\n", "Age", age + " Years old");
            System.out.printf("|%10s: %-38s|\n", "Status", status.toUpperCase());
            System.out.printf("|%10s: %-38s|\n", "Total", String.format("%.2f", total));
            System.out.printf("|%10s: %-38s|\n", "Average", String.format("%.2f", avg).concat("%"));

            final String LINE = "+".concat("-".repeat(7).concat("+"))
                                .concat("-".repeat(12).concat("+"))
                                .concat("-".repeat(29).concat("+"));
            System.out.println(LINE);

            System.out.printf("|%-7s|%-12s|%-29s| \n", "Subject", "Marks", "Grade");
            System.out.println(LINE);
            System.out.printf("|%-7s|%-12.2f|%-40s| \n", subject1, marks1, subject1status);
            System.out.printf("|%-7s|%-12.2f|%-40s| \n", subject2, marks2, subject2status);
            System.out.printf("|%-7s|%-12.2f|%-40s| \n", subject3, marks3, subject3status);

            System.out.println("+".concat("-".repeat(50)).concat("+"));
    }


        }
        
    }
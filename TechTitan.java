//Imported Libraries
import java.util.Scanner;
import java.io.*;
import static java.lang.System.*;
import java.util.Vector;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.*;
//main class
class TechTitan{
    public static void main(String args[]){
        //Size of an ArrayList
        Account[] account = new Account[100];
        //Variables being used such as strings, double, and int
        String a, b, c;
        double z;
        int cha;
        do{
            //The menu to choose
            Scanner s = new Scanner(System.in);
            System.out.println("Hello there my name is Josh your virtual assistant!");
            System.out.println("Please choose the following options: ");
            System.out.println("1. Add/Display Students/Calculate GPA");
            System.out.println("2. Calculator");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            cha = s.nextInt();
            elem e = new elem();
            //Switch Statements to redirect people
            switch (cha){
                case 1:
                e.add();
                break;
                case 2:
                Calculator calc = new Calculator();
                break;
                case 3:
                e.endD();
                break;
            }//end of switch
        }while(cha != 3);
        System.out.println("Ending Transmission...");//main
    } //end of class atm
}
class Account{
    String firstname, lastname, id;
    double gpa;
    //Constructor with parameters to store into variables
    Account(String f, String l, String i, double g)
    {
        firstname = f;
        lastname = l;
        id = i;
        gpa = g;

    }
    //Default Constructor
    Account()
    {
        firstname = "";
        lastname = "";
        id = "";
        gpa = 0;
    }
}

class Calculator implements ActionListener
{
    //Created the JFrame's object called framework
    JFrame framework;
    //label names
    JLabel Num1, Num2, Num3;

    //Field names
    JTextField text1, text2, text3;

    //Button names
    JButton plusOperation, multiplicationOperation, minusOperation, divisionOperation;

    // setting layout
    public void GUI()
    {
        //Create frame heading
        framework = new JFrame("TitanTech Calculator");
        //Create two labels asking to input number 1
        //and input number 2
        Num1 = new JLabel("1st Number:");
        Num2 = new JLabel("2nd Number:");
        Num3 = new JLabel("Result");

        //Create two text fields which takes input number 1 and number 2
        text1 = new JTextField(9);
        text2 = new JTextField(9);
        text3 = new JTextField(15);


        plusOperation = new JButton("+");
        plusOperation.setPreferredSize(new Dimension(42, 25));
        multiplicationOperation = new JButton("*");
        multiplicationOperation.setPreferredSize(new Dimension(40, 25));
        minusOperation = new JButton("-");
        minusOperation.setPreferredSize(new Dimension(40, 25));
        divisionOperation = new JButton("/");
        divisionOperation.setPreferredSize(new Dimension(40, 25));
        //Created a container called get
        Container get = framework.getContentPane();
        get.setLayout(new FlowLayout());
        //Add labels buttons and texts
        get.add(Num1);
        get.add(text1);
        get.add(Num2);
        get.add(text2);
        get.add(plusOperation);
        get.add(multiplicationOperation);
        get.add(minusOperation);
        get.add(divisionOperation);
        get.add(Num3);
        get.add(text3);
        //Calls the whole addActionListener method
        plusOperation.addActionListener(this);
        multiplicationOperation.addActionListener(this);
        minusOperation.addActionListener(this);
        divisionOperation.addActionListener(this);
        framework.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Setting the size of the frame
        framework.setSize(225, 220);
        framework.setVisible(true);
        framework.setResizable(false);
    }

    //Default constructor
    public Calculator()
    {
        GUI();
    }
    //Definition of actionPerformed
    public void actionPerformed(ActionEvent event)
    {
        String op, r;
        int a, b, c;
        //Addition operation
        if (event.getSource() == plusOperation)
        {
            op = text1.getText();
            a = Integer.parseInt(op);
            op = text2.getText();
            b = Integer.parseInt(op);
            c = a + b;
            r = c + "";
            text3.setText(r);
        }
        //Division operation
        else if (event.getSource() == divisionOperation)
        {
            op = text1.getText();
            a = Integer.parseInt(op);
            op = text2.getText();
            b = Integer.parseInt(op);
            c = a / b;
            r = c + "";
            text3.setText(r);
        }
        //Multiplication operation
        else if (event.getSource() == multiplicationOperation)
        {
            op = text1.getText();
            a = Integer.parseInt(op);
            op = text2.getText();
            b = Integer.parseInt(op);
            c = a * b;
            r = c + "";
            text3.setText(r);
        }
        //Subtraction operation
        else if (event.getSource() == minusOperation)
        {
            op = text1.getText();
            a = Integer.parseInt(op);
            op = text2.getText();
            b = Integer.parseInt(op);
            c = a - b;
            r = c + "";
            text3.setText(r);
        }
    }
}
//class elem that inherits from Account class
class elem extends Account{
    //Variables such as int a, double y, double count and double total
    int a;
    double y;
    double count = 1;
    double total = 0;
    //Function that returns a sentence
    void endD()
    {
        System.out.println("\nI hope you have a nice day");
    }
    //Add Function
    void add()
    {
        //Created an counter
        int counter = 0;
        Scanner sc = new Scanner(System.in);
        //Ask the user how many students they want to create
        System.out.println("How many student want to create: ");
        int n = sc.nextInt();
        //Stores the information such as firstname, lastname, id and their gpa inside of an array
        Account[] accounts = new Account[n];
        for(int i=0; i<n; i++)
        {
            System.out.println("Enter details of student "+(i+1));
            System.out.print("First Name: ");
            firstname = sc.next();
            System.out.print("Last Name: ");
            lastname = sc.next();
            System.out.print("ID: ");
            id = sc.next();
            System.out.print("GPA (1-4): ");
            gpa = sc.nextDouble();
            accounts[i] = new Account(firstname, lastname, id, gpa);
            //Created a counter that will put the amount of times ran
            counter++;

            //Here's a test case that I used to check if the array was working
            //Used C++ to prototype my idea
            //System.out.println(accounts[i].firstname);
        }
        //Another do while loop :)
        do {
            //Created a scanner and asks the user if they want to print out the names with gpa or just the gpa or if they want neither exit
            Scanner s = new Scanner(System.in);
            System.out.println("Do you wish to print out the names/id/gpa (1) or Calculate the overall GPA (2) or Exit (3)");

            a = s.nextInt();
            //Switch Statements to pprint or calculate
            switch (a){
                case 1:
                for (int x = 0; x < counter ; x++ )
                {
                    System.out.println("Firstname: "+ accounts[x].firstname + ", Lastname: " + accounts[x].lastname +", ID: " + accounts[x].id + ", GPA: " +accounts[x].gpa);
                }
                break;
                case 2:
                {
                    //In case their is one student
                    if (counter == 1)
                    {
                        System.out.println("The Average GPA: " + accounts[0].gpa);
                    }
                    else {
                        //If their is more than one student this code will execute and print out the gpa by using my formula to spit out the actually average gpa.
                        for(int x = 0; x < counter ; x++)
                        {
                            total += accounts[x].gpa;
                            count++;
                        }
                        y = y + (total/count);
                        System.out.println("The Average GPA: " + y);
                    }
                }
                break;
                //Case three breaks the code
                case 3:
                break;
            }
        } while (a!= 3);
    }
}

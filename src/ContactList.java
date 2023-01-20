import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick & Damian Villarreal-Ayala
 * @version: 2022-2023
 */

public class ContactList
{
    // TODO: Create your array contacts
    private ArrayList<Person> contactList;

    // TODO: Write a Constructor
    public ContactList()
    {
        contactList = new ArrayList<Person>();
    }



    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact() {
        // TODO: Complete the addContact method
        Scanner s = new Scanner(System.in);
        System.out.println("Select a type of contact to add: ");
        System.out.println("1. Student");
        System.out.println("2. Employee");
        int input = s.nextInt();
        s.nextLine();
        if (input == 1)
        {
            System.out.println("Please fill in the following information.");
            System.out.println("First Name: ");
            String firstName = s.nextLine();
            System.out.println("Last Name: ");
            String lastName = s.nextLine();
            System.out.println("Phone Number: ");
            String number = s.nextLine();
            System.out.println("Grade: ");
            int grade = s.nextInt();
            s.nextLine();
            Person student = new Student(firstName, lastName, number, grade);
            contactList.add(student);
        }
        else
        {
            System.out.println("Please fill in the following information.");
            System.out.println("First Name: ");
            String firstName = s.nextLine();
            System.out.println("Last Name: ");
            String lastName = s.nextLine();
            System.out.println("Phone Number: ");
            String number = s.nextLine();
            System.out.println("Work: ");
            String work = s.nextLine();
            Person employee = new Employee(firstName, lastName, number, work);
            contactList.add(employee);

        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        // TODO: Complete the printContacts method
        for (int i = 0; i < contactList.size(); i++)
        {
            System.out.println(contactList.get(i));
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy)
    {
        // TODO: Complete the sort method
        int size = contactList.size();

        if (sortBy == 0)
        {
            for(int pass = 1; pass < size; pass++)
            {
                for(int comp = 0; comp < size - pass; comp++)
                {
                    if (contactList.get(comp).getFirstName().compareTo(contactList.get(comp + 1).getFirstName()) > 0)
                    {
                        contactList.add(comp, contactList.get(comp + 1));
                        contactList.remove(comp + 2);
                    }
                }
            }
            this.printContacts();
        }

        else if (sortBy == 1)
        {
            for(int pass = 1; pass < size; pass++)
            {
                for(int comp = 0; comp < size - pass; comp++)
                {
                    if (contactList.get(comp).getLastName().compareTo(contactList.get(comp + 1).getLastName()) > 0)
                    {
                        contactList.add(comp, contactList.get(comp + 1));
                        contactList.remove(comp + 2);
                    }
                }
            }
            this.printContacts();
        }

        if (sortBy == 2)
        {
            for(int pass = 1; pass < size; pass++)
            {
                for(int comp = 0; comp < size - pass; comp++)
                {
                    if (contactList.get(comp).getPhoneNumber().compareTo(contactList.get(comp + 1).getPhoneNumber()) > 0)
                    {
                        contactList.add(comp, contactList.get(comp + 1));
                        contactList.remove(comp + 2);
                    }
                }
            }
            this.printContacts();
        }
    }
    // TODO: Write searchByFirstName
    public Person searchByFirstName(String firstName)
    {
        for (int i = 0; i < contactList.size(); i++)
        {
            if(contactList.get(i).getFirstName().equals(firstName))
            {
                return contactList.get(i);
            }
        }
        return null;
    }
    // TODO: Write searchByLastName
    public Person searchByLastName(String lastName)
    {
        for (int i = 0; i < contactList.size(); i++)
        {
            if(contactList.get(i).getLastName().equals(lastName))
            {
                return contactList.get(i);
            }
        }
        return null;
    }
    // TODO: Write searchByPhoneNumber
    public Person searchByPhoneNumber(String phoneNumber)
    {
        for (int i = 0; i < contactList.size(); i++)
        {
            if(contactList.get(i).getPhoneNumber().equals(phoneNumber))
            {
                return contactList.get(i);
            }
        }
        return null;
    }
    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        // TODO: Complete the listStudents method
        for (int i = 0; i < contactList.size(); i++)
        {
            if (contactList.get(i) instanceof Student)
            {
                System.out.println(contactList.get(i));
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();

        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        s.nextLine();

        //As long as 0 isn't inputted the code will continue running.
        while (choice != 0)
        {
            //Determines which option exactly to run.
            if (choice == 1)
            {
                this.addContact();
            }
            else if (choice == 2)
            {
                this.sort(0);
            }
            else if (choice == 3)
            {
                this.sort(1);
            }
            else if (choice == 4)
            {
                this.sort(2);
            }
            else if(choice == 5)
            {
                this.listStudents();
            }
            else if(choice == 6)
            {
                System.out.println("Enter a first name: ");
                String string = s.nextLine();
                if (this.searchByFirstName(string) == null)
                {
                    System.out.println(string + " is not in the list.");
                }
                else
                {
                    System.out.println(this.searchByFirstName(string));
                }
            }
            else if(choice == 7)
            {
                System.out.println("Enter a last name: ");
                String string = s.nextLine();
                if (this.searchByLastName(string) == null)
                {
                    System.out.println(string + " is not in the list.");
                }
                else
                {
                    System.out.println(this.searchByLastName(string));
                }
            }
            else if (choice == 8)
            {
                System.out.println("Enter a phone number: ");
                String string = s.nextLine();
                if (this.searchByPhoneNumber(string) == null)
                {
                    System.out.println(string + " is not in the list.");
                }
                else
                {
                    System.out.println(this.searchByPhoneNumber(string));
                }
            }
            printMenuOptions();
            choice = s.nextInt();
            s.nextLine();
        }
        // TODO: Complete the run method
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}

/**
        * A subclass of Person that represents an Employee/Worker
        *
        * Created for Menlo School CS2
        *
        * @author: Damian Villarreal-Ayala
        * @version: 2022-2023
        */
public class Employee extends Person{
    private String job;

    public Employee(String firstName, String lastName, String phoneNumber, String work)
    {
        super(firstName, lastName, phoneNumber);
        job = work;
    }
    public String getJob()
    {
        return job;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Job: " + job;
    }
}

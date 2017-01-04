package com.company;

import java.util.ArrayList;

interface Compareable1<T>
{
    int compareTo(T t);
    void print();
}
class Employee implements Compareable1<Employee>,Cloneable
{
    private String Id=new String ();
    private String Name=new String();
    public Employee(String Id,String Name)
    {
        this.Id=Id;
        this.Name=Name;
    }
    public String getId()
    {
        return Id;
    }
    public int compareTo(Employee e)
    {
        return e.getId().compareTo(Id);
    }
    public void print()
    {
        System.out.println(Id+" "+Name);
    }
    public Employee clone() throws CloneNotSupportedException
    {
        return (Employee) super.clone();
    }
}
class SortMethod
{
    public void Sort(ArrayList<Compareable1> t)
    {
        for(int i=t.size()-1;i>0;i--)
            for(int j=0;j<i;j++)
                if (t.get(j).compareTo(t.get(j + 1)) < 0) {
                    Compareable1 temp = t.get(j);
                    t.set(j, t.get(j + 1));
                    t.set(j + 1, temp);
                }
    }
    public void PrintArrayList(ArrayList<Compareable1> t)
    {
        for(Compareable1 e:t)
        {
            e.print();
        }
    }
}
public class Main
{

    public static void main(String[] args) throws CloneNotSupportedException {
	// write your code here
        ArrayList<Compareable1>  employee=new ArrayList<Compareable1>();
        employee.add(new Employee("005","5"));
        employee.add(new Employee("002","2"));
        employee.add(new Employee("003","3"));
        SortMethod sortm=new SortMethod();
        sortm.Sort(employee);
        sortm.PrintArrayList(employee);
        //Compareable1 t=employee.get(1);
        Class C=employee.get(1).getClass();
        Employee ttt=(Employee) employee.get(1);
        ((Employee) employee.get(1)).getId();

        System.out.println(ttt.getId());
        System.out.println(employee.get(2).getClass());
        Employee s=((Employee) employee.get(1)).clone();

    }
}

/**
 * Created by wb-pc on 2017/1/3.
 */
class InnerData
{
    private double salary=0;
    void setSalary(double salary){this.salary=salary;}
    double getSalary() {return salary;}
    InnerData(double salary){this.salary=salary;}
    InnerData(){}
}
public class Employee extends Person implements Cloneable
{
    private String title=new String();
    private InnerData innerSalary=null;
    Employee(String name,String idCard,String sex,int age,String title,double salary)
    {
        super(idCard,name,age,sex);
        innerSalary=new InnerData(salary);
        this.title=title;
    }
    class InnerClass
    {
        private int innerVal=0;
        public void setInnerVal(int innerVal){this.innerVal=innerVal;}
        public void changeName(String name){Employee.super.SetName(name);}
    }
    void setNameThroughInnerClass(String name){new InnerClass().changeName(name);}
    public Employee clone()
    {
        Employee eClone= null;
        try
        {
            eClone = (Employee) super.clone();
            eClone.innerSalary=new InnerData(innerSalary.getSalary());
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return eClone;
    }
    public void setSalary(double salary){innerSalary.setSalary(salary);}
    public void PrintMessage()
    {
        Employee.super.PrintMessage();
        System.out.println(super.GetidCard()+" "+super.GetName()+" "+super.GetSex()+" "+super.GetAge()+" "+title+" "+innerSalary.getSalary());
    }
}
class TestResult
{
    public static void main(String [] args)
    {
        Employee emp1=new Employee("jack","001","male",25,"Employee",400);
        Employee emp2=new Employee("Mick","002","male",25,"Employee",800);
        Employee emp1Clone=emp1.clone();
        emp1Clone.setSalary(90000);
        emp1Clone.SetName("Lucy");
      /*  emp1.PrintMessage();
        emp2.PrintMessage();
        emp1Clone.PrintMessage();*/

        System.out.println(emp1.equals(emp1Clone));

        PrintMessage printMess=emp1;
        printMess.PrintMessage();
        printMess=emp2;
        printMess.PrintMessage();
        printMess=emp1Clone;
        printMess.PrintMessage();


        emp1.setNameThroughInnerClass("hello");
        Person per=emp1;
        per.PrintMessage();
    }
}

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.io.PrintWriter;

/**
 * Created by wb-pc on 2017/1/3.
 */
interface PrintMessage
{
    public void PrintMessage();
}
class Person implements PrintMessage
{
    private String idCard=new String();
    private String name=new String();
    private int age = 0;
    private String sex=new String("unknown");
    Person(String idCard,String name,int age,String sex)
    {
        this.idCard=idCard;
        this.name=name;
        this.age=age;
        this.sex=sex;
    }
    Person()
    {
        System.out.println("Init with default data!");
    }
    void SetidCard(String idCard)
    {
        this.idCard=idCard;
    }
    void SetName(String name)
    {
        this.name=name;
    }
    void SetAge(int age)
    {
        this.age=age;
    }
    void SetSex(String sex)
    {
        this.sex=sex;
    }
    String GetidCard(){return idCard;}
    String GetName(){return name;}
    int  GetAge(){return age;}
    String GetSex(){return sex;}

    @Override
    public void PrintMessage() {
        System.out.println(idCard + " " + name+" "+age+" "+sex);
    }
}

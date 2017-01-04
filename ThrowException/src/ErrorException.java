/**
 * Created by wb-pc on 2017/1/3.
 */
class ErrorEx extends Exception
{
    public ErrorEx() {}
    public ErrorEx(String gripe)
    {
        super(gripe);
    }
}
class ErrorTest
{
    int [] arr=new int [10];
    ErrorTest()
    {
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=i;
        }
    }
    public int getData(int index) throws ErrorEx
    {
        if(index<0 || index>=arr.length)
            throw new ErrorEx("try to access wrong array index!");
        return arr[index];
    }
}
class ErrorExcetion
{
    public static void main(String args []) throws ErrorEx
    {
        ErrorTest err=new ErrorTest();
        for(int i=-1;i<=10;i++) {
            try {
                System.out.println(err.getData(i));
            } catch (ErrorEx errorEx) {
                System.out.println(errorEx.toString());
                //errorEx.printStackTrace();
            }
        }
    }
}

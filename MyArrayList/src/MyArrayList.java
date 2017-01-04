import java.util.logging.Logger;

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
interface MyIterator<T>
{
    public boolean hasNext();
    public T next();
    public void remove();
}
interface MyList<T>
{
    void add(T t);
    void PrintList();
    MyIterator<T> myIterator();
}
class MyLinkNode<T>
{
    public T val=null;
    public MyLinkNode<T> next=null;
    public MyLinkNode<T> pre=null;
}
public class MyArrayList<T> implements MyList<T>
{

    @Override
    public void add(T t)
    {

    }

    @Override
    public void PrintList()
    {

    }

    @Override
    public MyIterator<T> myIterator()
    {
        return null;
    }
}
class MyLinkList <T> implements MyList<T>
{
    private MyLinkNode<T> headNode=null;
    private MyLinkNode<T> tailNode=null;
    private int size=0;
    @Override
    public void add(T t)
    {
        if(headNode==null)
        {
            headNode = new MyLinkNode<T>();
            headNode.val=t;
            headNode.next=tailNode;
            headNode.pre=tailNode;
      //      headNode.pre=headNode;
            tailNode=headNode;
        }
        else
        {
            tailNode.next=new MyLinkNode<T>();
            tailNode.next.val=t;
            tailNode.next.pre=tailNode;
            tailNode=tailNode.next;
            tailNode.next=headNode;
            headNode.pre=tailNode;
        }
        size++;
    }

    @Override
    public void PrintList()
    {
        MyLinkNode temp=headNode;
        for(int i=0;i<size;i++)
        {
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public int Size(){return size;}
    public MyIterator<T> myIterator()
    {

        MyIterator<T> iterator=new MyIterator<T>()
        {
            private int count=0;
            private MyLinkNode<T> thisNode=headNode;
            @Override
            public boolean hasNext()
            {
                if(count<size)
                    return true;
                else
                    return false;
            }

            @Override
            public T next()
            {
                if(hasNext())
                {
                    thisNode=thisNode.next;
                    count++;
                    return thisNode.pre.val;
                }
                else
                {
                    Logger.getGlobal().info("next error");
                }
                return null;
            }

            @Override
            public void remove()
            {
                if(thisNode!=null&&thisNode.pre!=null&&size>1)
                {
                    thisNode.pre.pre.next=thisNode;
                    thisNode.pre=thisNode.pre.pre;
                    count--;
                    size--;
                }
                if(size==1)
                {
                    headNode=null;
                    tailNode=null;
                }
                else
                {
                    Logger.getGlobal().info("remove出现错误,表为空");
                }
            }
        };
        return iterator;
    }
}
class Test
{
    public static void main(String [] args)
    {
        MyList<Integer> list=new MyLinkList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.PrintList();
        MyIterator<Integer> iter=list.myIterator();
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
    }
}

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by wb-pc on 2017/1/3.
 */
public class Test
{
    static void printList(List<Integer> list)
    {
        Iterator<Integer> iter=list.iterator();
        while(iter.hasNext())
            System.out.print(iter.next()+" ");
        System.out.println();
    }
    public static void main(String [] args)
    {
        LinkedList <Integer> linkList=new LinkedList<>();
        linkList.add(1);
        linkList.add(2);
        linkList.add(3);
        linkList.add(4);
        ListIterator<Integer> iter=linkList.listIterator();
        iter.next();
        iter.next();
        iter.remove();
        iter.add(3);
        iter.add(5);
        printList(linkList);

    }
}

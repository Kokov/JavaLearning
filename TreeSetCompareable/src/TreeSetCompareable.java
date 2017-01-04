import apple.laf.JRSUIUtils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by wb-pc on 2017/1/4.
 */
class Data
{

}
class NameCompare implements Comparator<TreeSetCompareable>
{

    @Override
    public int compare(TreeSetCompareable o1, TreeSetCompareable o2)
    {
        return o1.name.compareTo(o2.name);
    }
}
class NumCompare implements Comparator<TreeSetCompareable>
{

    @Override
    public int compare(TreeSetCompareable o1, TreeSetCompareable o2)
    {
        return Integer.compare(o1.num,o2.num);
    }
}
public class TreeSetCompareable implements Comparable<TreeSetCompareable>
{
    public int num=0;
    public String name="unknown";
    public String sex="unknown";
    TreeSetCompareable(){}
    TreeSetCompareable(int num,String name,String sex)
    {
        this.num=num;
        this.name=name;
        this.sex=sex;
    }
    @Override
    public int compareTo(TreeSetCompareable o)
    {
        int result=Integer.compare(this.num,o.num);
        if(result==0)
            result=name.compareTo(o.name);
        if(result==0)
            result=sex.compareTo(o.sex);
        return result;
    }
}
class test
{
    public static void main(String [] args)
    {
        SortedSet<TreeSetCompareable> treeSet=new TreeSet<>();
        treeSet.add(new TreeSetCompareable(1,"koko","male"));
        treeSet.add(new TreeSetCompareable(1,"hello","male"));
        treeSet.add(new TreeSetCompareable(1,"koko","female"));
        treeSet.add(new TreeSetCompareable(2,"aello","male"));
        treeSet.add(new TreeSetCompareable(3,"cello","male"));
        treeSet.add(new TreeSetCompareable(4,"bello","male"));
        Iterator<TreeSetCompareable> iter=treeSet.iterator();
        for(TreeSetCompareable s:treeSet)
        {
            System.out.println(s.num+" "+s.name+" "+s.sex);
        }

    }
}

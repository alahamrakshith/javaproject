import java.util.*;

abstract class Details                                                  // Abstract Class used here
{ static int count=0;
  String name;
  int age;
  int id;
  Details()
  {
    count++;
    this.id=count;
  }
  abstract void set_info(String name,int age);                        // Abstract method used here
  abstract void show_info();
}
public class Bleh extends Details
{
  public static void main(String args[])
  { int t=0;
    Details d[]=new Details[100];                                   // Array of objects used here
    Scanner sc=new Scanner(System.in);
    while(true)
    {
      System.out.println("Enter the number of guests");
      int numofguests=sc.nextInt();                                    // Wrapper class used here
      for(int i=1;i<=numofguests;i++)
      {
        d[count]=new Bleh();
        System.out.println("Enter name and age");
        String tempname=sc.next();
        int tempage=sc.nextInt();
        d[count-1].set_info(tempname,tempage);
      }
      System.out.println("Details of all the guests are");
      for(int i=0;i<count;i++)
      {
        d[i].show_info();
      }
    }
  }
  void set_info(String name,int age)                                // Method Overriding used here
  {
    this.name=name;
    this.age=age;
  }
  void show_info()
  {
    System.out.println(" "+name+" "+age+" "+id+" ");
  }
}

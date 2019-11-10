import java.util.*;
import java.io.*;
import detailspackage.Details;           // Custom package which includes an abstract class of the blueprint of customer details

class Bleh extends Details
{
  public static void main(String args[])
  { int t=0;
    Details d[]=new Details[100];                                   // Array of objects used here
    try{
    Scanner sc=new Scanner(System.in);
    FileOutputStream fout=new FileOutputStream("Database.txt");
    System.out.println("Enter the number of guests");
    int numofguests=sc.nextInt();                                    // Wrapper class used here
    for(int i=1;i<=numofguests;i++)
    {
      d[count]=new Bleh();
      System.out.println("Enter name and age");
      String tempname=sc.next();
      int tempage=sc.nextInt();
      d[count-1].set_info(tempname,tempage);
      String strage= Integer.toString(tempage);
      String addedstrings=(tempname+" "+strage);
      for(int j=0;j<addedstrings.length();j++)// Name and age of all pushed in to a database txt file using FileOutputStream
      {
        fout.write(addedstrings.charAt(j));
      }
      fout.write('\n');
    }
    fout.close();
    }catch(Exception e){System.out.println(e);}
    System.out.println("Details of all the guests are");
    for(int i=0;i<count;i++)
    {
      d[i].show_info();
    }
  }
  @Override
  public void set_info(String name,int age)                          // Method Overriding used here
  {
    this.name=name;
    this.age=age;
  }
  @Override
  public void show_info()
  {
    System.out.println(" "+name+" "+age+" "+id+" ");
  }

}

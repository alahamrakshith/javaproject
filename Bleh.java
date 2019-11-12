import java.util.*;
import java.io.*;
import detailspackage.Details;           // Custom package which includes an abstract class of the blueprint of customer details

class InvalidAgeExcpetion extends Exception   //Custom Exception created
{
  InvalidAgeExcpetion(String s){
    super(s);
  }
}

class Rides extends Details                       //Outer Class used here
{
  private static final int time = 10000;
  public void run()
  {
    try{
      System.out.println(this.name+" started taking the ride");
      Thread.sleep(this.time);
      this.numofridesallowed--;
      System.out.println(this.name+" finished riding the ride");
    }catch(InterruptedException e){System.out.println(e);}
  }
  class Rollercoaster                             //Innerclass used here
  {
    int minage=18;
    int ridecount;
    int rideguestid[]=new int[100];
  }
  class Bumpercars
  {
    int minage=12;
    int ridecount;
    int rideguestid[]=new int[100];
  }
  class Ferriswheel
  {
    int minage=10;
    int ridecount;
    int rideguestid[]=new int[100];
  }
  class Waterpark
  {
    int minage=7;
    int ridecount;
    int rideguestid[]=new int[100];
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

class Bleh extends Rides
{
  public static void main(String args[])
  { int t=0;
    Rides d[]=new Rides[100];
    Scanner sc=new Scanner(System.in);                                // Array of objects used here
    try{
    FileOutputStream fout=new FileOutputStream("Database.txt");
    System.out.println("Enter the number of guests");
    int numofguests=sc.nextInt();                                    // Wrapper class used here
    for(int i=1;i<=numofguests;i++)
    {
      d[count]=new Rides();
      sc.nextLine();
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
    Rides.Rollercoaster rollcoast = d[0].new Rollercoaster();             // Objects of Innerclass Created
    Rides.Bumpercars bumpcars = d[0].new Bumpercars();
    Rides.Ferriswheel wheel= d[0].new Ferriswheel();
    Rides.Waterpark watergame = d[0].new Waterpark();
    System.out.println("Details of all the guests are");
    for(int i=0;i<count;i++)
    {
      d[i].show_info();
    }
    System.out.println("Each of you are allowed to take 10 Rides from our amusment park");
    System.out.println("1.rides\n");
    int ch=sc.nextInt();
    switch (ch)
    {
      case 1: System.out.println("Which Ride do you want to take?\n1.Rollercoaster\n2.Bumpercars\n3.Ferriswheel\n4.Waterpark");
              int choice=sc.nextInt();
              System.out.println("Enter the number of guests taking the ride");
              int ridenum=sc.nextInt();
              int temp[]=new int[ridenum];
              System.out.println("Enter the id's of the guests taking the ride");
              for(int i=0;i<ridenum;i++)
              {
                temp[i]=sc.nextInt();
              }
              try{
              for(int i=0;i<ridenum;i++)
              {
                if(choice==1)
                {
                  if(d[temp[i]-1].age<rollcoast.minage)
                    throw new InvalidAgeExcpetion("Guest "+d[temp[i]-1].name+"'s age is under permitted age limit");
                  else
                  {
                    if(d[temp[i]-1].numofridesallowed>0)
                    {
                      rollcoast.ridecount++;
                      d[temp[i]-1].start();                               // Thread sleep function used
                    }
                  }
                }
                else if(choice==2)
                {
                  if(d[temp[i]-1].age<bumpcars.minage)
                    throw new InvalidAgeExcpetion("Guest "+d[temp[i]-1].name+"'s age is under permitted age limit");
                  else
                  {
                    if(d[temp[i]-1].numofridesallowed>0)
                    {
                      bumpcars.ridecount++;
                      d[temp[i]-1].start();
                    }
                  }
                }
                }
              }catch(Exception e){System.out.println(e);}
              break;

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

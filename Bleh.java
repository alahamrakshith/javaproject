import java.util.*;
import java.io.*;
import detailspackage.Details;           // Custom package which includes an abstract class of the blueprint of customer details
import adminpackage.Admin;

class InvalidAgeExcpetion extends Exception   //Custom Exception created
{
  InvalidAgeExcpetion(String s){
    super(s);
  }
}

class InvalidPassword extends Exception   //Custom Exception created
{
  InvalidPassword(String s){
    super(s);
  }
}

class Rides extends Details implements Admin                       //Outer Class used here
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
  { boolean state= true;
    int minage=18;
    int ridecount;
    int rideguestid[]=new int[100];
  }
  class Bumpercars
  { boolean state= true;
    int minage=12;
    int ridecount;
    int rideguestid[]=new int[100];
  }
  class Ferriswheel
  { boolean state= true;
    int minage=10;
    int ridecount;
    int rideguestid[]=new int[100];
  }
  class Waterpark
  { boolean state= true;
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
      System.out.println("Name: "+name+" Age: "+age+" Id: "+id+" ");
  }
}

class Bleh extends Rides implements Admin
{
  public static void main(String args[])
  { int t=0;
    Rides d[]=new Rides[100];
    Admin moderator=new Rides();
    count--;
    Scanner sc=new Scanner(System.in);                                // Array of objects used here
    d[0]=new Rides();
    Rides.Rollercoaster rollcoast = d[0].new Rollercoaster();             // Objects of Innerclass Created
    Rides.Bumpercars bumpcars = d[0].new Bumpercars();
    Rides.Ferriswheel wheel= d[0].new Ferriswheel();
    Rides.Waterpark watergame = d[0].new Waterpark();
    while(true){
    System.out.println("1.Guest\n2.Admin\n3.exit");
    int identity= sc.nextInt();
    if(identity==1){
    try{
    FileOutputStream fout=new FileOutputStream("Database.txt");
    System.out.println("Enter the number of guests");
    int numofguests=sc.nextInt();
    for(int i=1;i<=numofguests;i++)
    { if(i>1)
        d[count]=new Rides();
      sc.nextLine();
      System.out.println("Enter name and age");
      String tempname=sc.next();
      int tempage=sc.nextInt();
      d[count-1].set_info(tempname,tempage);
      String strage= Integer.toString(tempage);                  // Wrapper class used here
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
                { if(rollcoast.state==true){
                  if(d[temp[i]-1].age<rollcoast.minage)
                    throw new InvalidAgeExcpetion("Guest "+d[temp[i]-1].name+"'s age is under permitted age limit");
                  else
                  {
                    if(d[temp[i]-1].numofridesallowed>0)
                    {
                      rollcoast.ridecount++;
                      d[temp[i]-1].start();                               // Thread sleep function used here
                      try{
                        d[temp[i]-1].join();                              // Thread join fucntion used here
                      }catch(Exception e){System.out.println(e);}
                    }
                    else
                      System.out.println("You have used the number of rides allowed");
                  }
                  }
                  else
                    {System.out.println("Ride is currently closed");
                      break;}
                }
                else if(choice==2)
                { if(bumpcars.state==true){
                  if(d[temp[i]-1].age<bumpcars.minage)
                    throw new InvalidAgeExcpetion("Guest "+d[temp[i]-1].name+"'s age is under permitted age limit");
                  else
                  {
                    if(d[temp[i]-1].numofridesallowed>0)
                    {
                      bumpcars.ridecount++;
                      d[temp[i]-1].start();
                    }
                    else
                      System.out.println("You have used the number of rides allowed");
                  }
                  }
                  else
                    {System.out.println("Ride is currently closed");
                      break;}
                }
                if(choice==3)
                { if(wheel.state==true){
                  if(d[temp[i]-1].age<wheel.minage)
                    throw new InvalidAgeExcpetion("Guest "+d[temp[i]-1].name+"'s age is under permitted age limit");
                  else
                  {
                    if(d[temp[i]-1].numofridesallowed>0)
                    {
                      wheel.ridecount++;
                      d[temp[i]-1].start();                               // Thread sleep function used here
                    }
                    else
                      System.out.println("You have used the number of rides allowed");
                  }
                  }
                  else
                    {System.out.println("Ride is currently closed");
                      break;}
                }
                if(choice==4)
                { if(watergame.state==true){
                  if(d[temp[i]-1].age<watergame.minage)
                    throw new InvalidAgeExcpetion("Guest "+d[temp[i]-1].name+"'s age is under permitted age limit");
                  else
                  {
                    if(d[temp[i]-1].numofridesallowed>0)
                    {
                      watergame.ridecount++;
                      d[temp[i]-1].start();                               // Thread sleep function used here
                    }
                    else
                      System.out.println("You have used the number of rides allowed");
                  }
                  }

                }
              }
            }catch(Exception e){System.out.println(e);}
              break;
            }
            }
      else if(identity==2)
      {
        System.out.println("Please Enter the admin password");
        String passwordcheck=sc.next();
        if(passwordcheck.equals(moderator.password)==true)
          System.out.println("Welcome moderator");
        else
          {
            System.out.println("Incorrect password please enter the password again");
            passwordcheck=sc.next();
            if(passwordcheck.equals(moderator.password)==true)
              System.out.println("Welcome moderator");
            else
            {
              try
              {
                throw new InvalidPassword("Entered wrong password twice");
              }catch(Exception e){System.out.println(e);}
            }
          }
        System.out.println("1.Manage Rides\n2.View Customer Database");
        int ch= sc.nextInt();
        switch(ch)
        {
          case 1: System.out.println("Select the ride");
                  System.out.println("1.Rollercoaster\n2.Bumpercars\n3.Ferriswheel\n4.Waterpark");
                  int ch1=sc.nextInt();
                  System.out.println("1.Turn on ride\n2.Turn off ride");
                  ch=sc.nextInt();
                  if(ch==1)
                  {
                    if(ch1==1)
                    {
                      if(rollcoast.state==true)
                        System.out.println("Already on");
                      else
                        rollcoast.state=true;
                    }
                    if(ch1==2)
                    {
                      if(bumpcars.state==true)
                        System.out.println("Already on");
                      else
                        bumpcars.state=true;
                    }
                    if(ch1==3)
                    {
                      if(wheel.state==true)
                        System.out.println("Already on");
                      else
                        wheel.state=true;
                    }
                    if(ch1==4)
                    {
                      if(watergame.state==true)
                        System.out.println("Already on");
                      else
                        watergame.state=true;
                    }
                  }
                  if(ch==2)
                  {
                    if(ch1==1)
                    {
                      if(rollcoast.state==false)
                        System.out.println("Already off");
                      else
                        rollcoast.state=false;
                    }
                    if(ch1==2)
                    {
                      if(bumpcars.state==false)
                        System.out.println("Already on");
                      else
                        bumpcars.state=false;
                    }
                    if(ch1==3)
                    {
                      if(wheel.state==false)
                        System.out.println("Already on");
                      else
                        wheel.state=false;
                    }
                    if(ch1==4)
                    {
                      if(watergame.state==false)
                        System.out.println("Already on");
                      else
                        watergame.state=false;
                    }
                  }
                  break;
        }
      }
      else if(identity==3)
        System.exit(1);
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
    System.out.println("Name: "+name+"Age: "+age+"Id: "+id+" ");
  }

}

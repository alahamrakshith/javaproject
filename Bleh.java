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

class Rides extends Details implements Admin                      //Outer Class used here
{ public Rides(String meh){System.out.println("Admin "+meh+" created");}
  Rides(){}
  int time = 3000;
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
  public void set_info(String name)                          // Method Overriding used here
  {
    this.name=name;
  }
  @Override
  public void show_info()
  {
      System.out.println("Name: "+name+" Age: "+age+" Id: "+id+" ");
  }
}

class Bleh extends Rides implements Admin
{
  public static void main(String args[]) throws IOException
  { int t=0,tempcount1=0,tempcount2=0,tempcount3=0,tempcount4=0;
    Boolean temp2=false;
    Rides d[]=new Rides[100];
    Admin moderator=new Rides("Batman");
    count--;
    Scanner sc=new Scanner(System.in);                                // Array of objects used here
    d[0]=new Rides();
    System.out.println("                   ******WELCOME TO THE AMUSMENT PARK***********              ");
    Rides.Rollercoaster rollcoast = d[0].new Rollercoaster();             // Objects of Innerclass Created
    Rides.Bumpercars bumpcars = d[0].new Bumpercars();
    Rides.Ferriswheel wheel= d[0].new Ferriswheel();
    Rides.Waterpark watergame = d[0].new Waterpark();
    while(true){
    System.out.println("1.Guest\n2.Admin\n3.exit");
    System.out.println("Enter Input");
    int identity= sc.nextInt();
    if(identity==1){
    System.out.println("1.NewGuest\n2.Oldguest");
    System.out.println("Enter Input");
    int temp1=sc.nextInt();
    if(temp1==1){
    try{
    FileOutputStream fout=new FileOutputStream(("Database.txt"),true);
    System.out.println("Enter the number of guests");
    int numofguests=sc.nextInt();
    for(int i=1;i<=numofguests;i++)
    { if(temp2==true)
        d[count]=new Rides();
      temp2=true;
      sc.nextLine();
      System.out.println("Enter name and age");
      String tempname=sc.next();
      int tempage=sc.nextInt();
      d[count-1].set_info(tempname,tempage);
      String strage= Integer.toString(tempage);                  // Wrapper class used here
      String addedstrings=(tempname+"-"+strage+"-"+(count));
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
  }
    System.out.println("1.rides\n");
    int ch=sc.nextInt();
    switch (ch)
    {
      case 1: System.out.println("Which Ride do you want to take?\n1.Rollercoaster\n2.Bumpercars\n3.Ferriswheel\n4.Waterpark");
              System.out.println("Enter Input");
              int choice=sc.nextInt();
              System.out.println("Enter the number of guests taking the ride");
              int ridenum=sc.nextInt();
              int temp[]=new int[ridenum];
              System.out.println("Enter the id's of the guests taking the ride");

              for(int i=0;i<ridenum;i++)
              {
                temp[i]=sc.nextInt();
              }

              for(int i=0;i<ridenum;i++)
              {
                if(choice==1)
                { if(rollcoast.state==true){
                  if(d[temp[i]-1].age<rollcoast.minage)
                  {try{throw new InvalidAgeExcpetion("Guest "+d[temp[i]-1].name+"'s age is under permitted age limit"); //Custom Exception Thrown here
                }catch(Exception e){System.out.println(e);}}
                  else
                  {
                    if(d[temp[i]-1].numofridesallowed>0)
                    { try{
                      FileOutputStream fout= new FileOutputStream(("Rollercoaster.txt"),true);
                      for(int j=0;j<d[temp[i]-1].name.length();j++)
                      {
                        fout.write(d[temp[i]-1].name.charAt(j));
                      }
                      fout.write('\n');
                      fout.close();
                    }catch(Exception e){System.out.println(e);}
                      rollcoast.ridecount++;
                      if(tempcount1==0)
                        d[temp[i]-1].start();
                      tempcount1=1;
                      d[temp[i]-1].run();                    // Thread sleep function used here

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
                if(choice==2)
                { if(bumpcars.state==true){
                  if(d[temp[i]-1].age<bumpcars.minage)
                  {try{throw new InvalidAgeExcpetion("Guest "+d[temp[i]-1].name+"'s age is under permitted age limit");
                }catch(Exception e){System.out.println(e);}}
                  else
                  {
                    if(d[temp[i]-1].numofridesallowed>0)
                    {
                      try{
                        FileOutputStream fout= new FileOutputStream(("Bumpercars.txt"),true);
                        for(int j=0;j<d[temp[i]-1].name.length();j++)
                        {
                          fout.write(d[temp[i]-1].name.charAt(j));
                        }
                        fout.write('\n');
                        fout.close();
                      }catch(Exception e){System.out.println(e);}
                      bumpcars.ridecount++;
                      if(tempcount2==0)
                        d[temp[i]-1].start();
                      tempcount2=1;
                      d[temp[i]-1].run();

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
                  {try{throw new InvalidAgeExcpetion("Guest "+d[temp[i]-1].name+"'s age is under permitted age limit");
                }catch(Exception e){System.out.println(e);}}
                  else
                  {
                    if(d[temp[i]-1].numofridesallowed>0)
                    {
                      try{
                        FileOutputStream fout= new FileOutputStream(("Ferriswheel.txt"),true);
                        for(int j=0;j<d[temp[i]-1].name.length();j++)
                        {
                          fout.write(d[temp[i]-1].name.charAt(j));
                        }
                        fout.write('\n');
                        fout.close();
                      }catch(Exception e){System.out.println(e);}
                      wheel.ridecount++;
                      if(tempcount3==0)
                        d[temp[i]-1].start();
                      tempcount3=1;
                      d[temp[i]-1].run();                        // Thread sleep function used here
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
                    {try{throw new InvalidAgeExcpetion("Guest "+d[temp[i]-1].name+"'s age is under permitted age limit"); // Custom Exception thrown here
                  }catch(Exception e){System.out.println(e);}}
                  else
                  {
                    if(d[temp[i]-1].numofridesallowed>0)
                    {
                      try{
                        FileOutputStream fout= new FileOutputStream(("Waterpark.txt"),true);
                        for(int j=0;j<d[temp[i]-1].name.length();j++)
                        {
                          fout.write(d[temp[i]-1].name.charAt(j));
                        }
                        fout.write('\n');
                        fout.close();
                      }catch(Exception e){System.out.println(e);}
                      watergame.ridecount++;
                      if(tempcount4==0)
                        d[temp[i]-1].start();
                      tempcount4=1;
                      d[temp[i]-1].run();                               // Thread sleep function used here
                    }

                    else
                      System.out.println("You have used the number of rides allowed");
                  }
                  }
                }
              }
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
        System.out.println("1.Manage Rides\n2.View Customer Database\n3.Edit ride time\n4.Rollercoaster Database\n5.Bumpercars Database\n6.Ferriswheel Database\n7. Waterpark Database\n8.Delete all databases");
        int ch= sc.nextInt();
        switch(ch)
        {
          case 1: System.out.println("Select the ride");
                  System.out.println("1.Rollercoaster\n2.Bumpercars\n3.Ferriswheel\n4.Waterpark");
                  System.out.println("Enter Input");
                  int ch1=sc.nextInt();
                  System.out.println("1.Turn on ride\n2.Turn off ride");
                  System.out.println("Enter Input");
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
            case 2: FileInputStream fstream = new FileInputStream("Database.txt");             // BufferedReader used here
                    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                    String strLine;
                    System.out.println("Name-Age-ID");
                    while((strLine=br.readLine())!=null)
                    {
                      System.out.println(strLine);
                    }
                    fstream.close();
                    System.out.println("Total number of guests = "+(count));
                    break;
          case 3: System.out.println("Enter the new ride time");
                  int ridetime= sc.nextInt();
                  d[0].time=ridetime;
                  break;
          case 4: FileInputStream fstream1 = new FileInputStream("Rollercoaster.txt");             // BufferedReader used here
                  BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
                  System.out.println("Name");
                  while((strLine=br1.readLine())!=null)
                  {
                    System.out.println(strLine);
                  }
                  fstream1.close();
                  break;
          case 5: FileInputStream fstream2 = new FileInputStream("Bumpercars.txt");             // BufferedReader used here
                  BufferedReader br2 = new BufferedReader(new InputStreamReader(fstream2));
                  System.out.println("Name");
                  while((strLine=br2.readLine())!=null)
                  {
                    System.out.println(strLine);
                  }
                  fstream2.close();
                  break;
          case 6:  FileInputStream fstream3 = new FileInputStream("Ferriswheel.txt");             // BufferedReader used here
                  BufferedReader br3 = new BufferedReader(new InputStreamReader(fstream3));
                  System.out.println("Name");
                  while((strLine=br3.readLine())!=null)
                  {
                    System.out.println(strLine);
                  }
                  fstream3.close();
                  break;
          case 7:  FileInputStream fstream4 = new FileInputStream("Waterpark.txt");             // BufferedReader used here
                  BufferedReader br4 = new BufferedReader(new InputStreamReader(fstream4));
                  System.out.println("Name");
                  while((strLine=br4.readLine())!=null)
                  {
                    System.out.println(strLine);
                  }
                  fstream4.close();
                  break;
          case 8: PrintWriter pw = new PrintWriter("Database.txt");
                  PrintWriter pw1 = new PrintWriter("Ferriswheel.txt");
                  PrintWriter pw2 = new PrintWriter("Rollercoaster.txt");
                  PrintWriter pw3 = new PrintWriter("Bumpercars.txt");
                  PrintWriter pw4 = new PrintWriter("Waterpark.txt");
                  pw.close();
                  pw1.close();
                  pw2.close();
                  pw3.close();
                  pw4.close();
                  break;
          default: System.out.println("Invalid Input");
        }
      }
      else if(identity==3)
        {
          try{}
            finally{                                               // Finally used here
              System.out.println("Thank you for visiting THE AMUSMENT PARK");
            }
        }
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

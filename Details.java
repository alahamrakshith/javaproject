
package detailspackage;
public abstract class Details                                             // Abstract Class used here
{
  public static int count=0;                                                  // Static variable used here
  public String name;
  public int age;
  public int id;
  public Details()
  {
    count++;
    this.id=count;
  }
  public abstract void set_info(String name,int age);                        // Abstract method used here
  public abstract void show_info();
  public static void main(String args[])
  {System.out.println("w");}
}

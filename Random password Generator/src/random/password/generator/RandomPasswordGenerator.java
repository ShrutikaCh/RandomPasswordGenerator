
package random.password.generator;
import java.util.Scanner;

public class RandomPasswordGenerator {

   
    public static void main(String[] args) {
      Scanner ln = new Scanner(System.in);
      System.out.println("How many Passwords do you want to Generate ? ");
      int total = ln.nextInt();
      System.out.println("How many character long do you want your Password to be?");
      int length = ln.nextInt();
      
      String[] randomPasswords = new String[total];
      for (int i=0;i<total;i++)
      {
        String randomPassword ="";
        for ( int j=0;j<length;j++)
        {
          randomPassword += randomCharacter();
        
        }
          randomPasswords[i] =  randomPassword ;
      }
      
         printPasswords(randomPasswords); 
         
         System.out.println(getPasswordStrength(length));
    }
    
    public static String getPasswordStrength(int length)
    {
      if (length< 5 )
      {
         return "Weak"; 
      }
      
      else if(length < 10)
      {
         return "Medium";
      }
      
      else
      {
         return "Strong";
      }
    
    }
    
    public static void printPasswords(String[] arr)
    {
      
     for (int i = 0 ; i<arr.length ;i++)
     {
       System.out.println(arr[i]);
     
     }
    }
    public static char randomCharacter ()
    {
       int rand =(int)( Math.random()* 62);
       
       if (rand <= 9)
       {
          int ascii = rand + 48;
          return (char)(ascii);
       
       }
       else if(rand <= 35)
       {
          int ascii = rand + 55;
          return (char)(ascii);
       }
       else
       {
          int ascii = rand + 61;
          return (char)(ascii);
       }

    }
}

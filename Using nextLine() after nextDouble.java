import java.util.Scanner;

public class main{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int     i  = sc.nextInt();
        double d  = sc.nextDouble();  //This nextDouble takes input but doesnot moves the cursor to the next line 
                                      //As a result Our next call to the nextLine() consumes the now empty second line
        sc.nextLine();                                      //To FIX this we have to call nextLine() falsely before taking our actual input 
        String  str = sc.nextLine();
        sc.close();

        System.out.println("My name is: "+str);
        System.out.println("My D size is: "+d);
        System.out.println("My Age is: "+i);
    }
}

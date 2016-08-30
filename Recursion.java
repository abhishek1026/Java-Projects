import java.util.*;

public class Recursion{

    static int a=1,b = 1;

    public static void main(String[] args){

       Scanner s = new Scanner(System.in);

       boolean keep = false;

       do{

            System.out.print("How many integers of this fibonacci sequence do you wish to see? ");

            int choice = s.nextInt();

            if(choice<=0){
                System.out.println("POSITIVE INTEGERS ONLY!!!");
                keep = true;
                continue;
            }

            fib(a,b,choice);

            System.out.print("type 1 to continue running: ");

            if(s.nextInt() == 1)
                keep = true;
            else
                keep = false;


            }while(keep);

       
       s.close();

    }

    public static void fib(int a, int b, int num){

        if(num == 1){
            System.out.println(a);
        }
        else if (num == 2){
            System.out.println(a + " " + b);
        }
        else{
            System.out.print(a + " " + b + " ");
            a+=b;
            b+=a;
            fib(a,b,num-2);
        }
    }

   
}
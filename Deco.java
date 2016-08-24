import java.util.Scanner;

public class Deco
{ 
   //Scanner in = new Scanner(System.in);
   //StringHandler sh = new StringHandler();

   public static void main (String[] sdfa)
   {
      Scanner in = new Scanner(System.in);
      StringHandler sh = new StringHandler();
      Display dis = new Display();

      System.out.println("\nEste Programa traduce una frase de lenguaje natural al simbolico\n**usar solo minusculas");


      sh.changeForSymbols(in.nextLine());
//      System.out.println("\nsh.getCadWithSymbols = " + sh.getCadWithSymbols());///
//      System.out.println("\nsh.getCadForSplit = " + sh.getCadForSplit());///
      dis.displaying(sh.getCadWithSymbols(), sh.getCadForSplit());
   }

   
}

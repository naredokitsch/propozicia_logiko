import java.util.Scanner;
public class Test
{
   public static void main (String zsdfafs[])
   {
      String entrada;

      Meths meths = new Meths();
      Scanner in = new Scanner(System.in);

      System.out.println("\n\t¬\t⋀\t⋁\t⟶\t⇌\n");

      entrada = in.nextLine();
      System.out.println("FINAL = " + meths.develop(entrada));
      
   }
}

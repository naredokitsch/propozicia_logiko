public class StringHandler
{
   //quitarespaciossiesnecesario
   private static String conj = " ~AND~ ";
   private static String disj = " ~OR~ ";
   private static String neg = " ~7~ ";
   private static String cond = " ~=~ ";
   private static String bic = " ~==~ ";
   //quitarespaciossiesnecesario
   private String cad;
   private String cadForSplit;

   void setString(String cadena)
   {
      cad = new String(cadena);
      cadForSplit = new String();
   }
   
   public void changeForSymbols(String cat)
   {
      setString(cat);
      
      disjHandler();//manteneresteorden
      negHandler();
      bicHandler();
      condHandler();
      conjHandler();//manteneresteorden

       //quitarespaciossiesnecesario                                   
      cadForSplit = cad.replaceAll(neg," @ ");
      cadForSplit = cadForSplit.replaceAll(conj," @ ");
      cadForSplit = cadForSplit.replaceAll(disj," @ ");
      cadForSplit = cadForSplit.replaceAll(cond," @ ");
      cadForSplit = cadForSplit.replaceAll(bic," @ ");
      //quitarespaciossiesnecesario

      //System.out.println(cad);
   }

   private void negHandler()
   {
      cad = cad.replaceAll("no es cierto que",neg);
      cad = cad.replaceAll("no ocurre que",neg);
      cad = cad.replaceAll("no es el caso que",neg);
      cad = cad.replaceAll("es falso que",neg);
      cad = cad.replaceAll(" no ",neg);//poneratencionenelorden
      if (cad.contains("no "))
      {
         cad = cad.replaceAll("no ",neg);
         //cad = cad.replaceAll("\\(no ",neg);
      }
      else
      {}
      cad = cad.replaceAll(" ni ",neg);
   }

   private void conjHandler()
   {
      cad = cad.replaceAll(" y ",conj);
      cad = cad.replaceAll("pero",conj);
      cad = cad.replaceAll("aunque",conj);
      cad = cad.replaceAll("sin embargo",conj);
      cad = cad.replaceAll("no obstante",conj);
      cad = cad.replaceAll("a pesar de",conj);
      cad = cad.replaceAll("a pesar de que",conj);
      cad = cad.replaceAll("a pesar que",conj);
      cad = cad.replaceAll(",",conj);
   }

   private void disjHandler()
   {
      cad = cad.replaceAll(" o ", disj);
      cad = cad.replaceAll("a menos que", disj);
   }

   private void condHandler()
   {
      cad = cad.replaceAll("solo si",cond);
      cad = cad.replaceAll("entonces",cond);
      cad = cad.replaceAll("es suficiente para que",cond);
      cad = cad.replaceAll("es suficiente para",cond);
      cad = cad.replaceAll("es necesario para que",cond);
      cad = cad.replaceAll("es necesario para",cond);
      cad = cad.replaceAll(" si ",cond);
   }

   private void bicHandler()
   {
      cad = cad.replaceAll("si y solo si",bic);
      cad = cad.replaceAll("es necesario y suficiente para",bic);
   }

   public String getCadForSplit()
   {
      cadForSplit = cadForSplit.replaceAll("\\(","");
      cadForSplit = cadForSplit.replaceAll("\\)","");
      return(cadForSplit);
   }

   public String getCadWithSymbols()
   {
      cad = cad.replaceAll("\\(","OPEN");
      cad = cad.replaceAll("\\)","CLOSE");
      return(cad);
   }
}  

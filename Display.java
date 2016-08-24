import java.util.StringTokenizer;

public class Display
{
   private String cadWithSymbols = new String();
   private String cadForSplit = new String();
   private String onePremise = new String();
   private String allPremises = new String("");
   private String conclusion;
   private String caseResult = "";
   private String tableResult;
   private String eachPremise[];
   private String premiseLetter[];
   private String propFormula = new String();
   private int numberOfPremises = 0;
   private int A = 65;
   private int h = 0;
   private int i = 0;

   public void displaying(String utytututu, String bdhsouirn)
   {
      cadWithSymbols = utytututu;
      cadForSplit = bdhsouirn;

      displayAtomics();
   }

   private void displayAtomics()
   {
      /////////SEPARACION DE PREMISAS//////////////////////////////////////

      String justPremises[] = cadForSplit.split("@");
      for (i = 0; i<=(justPremises.length - 1); i++)
      {
         if (justPremises[i].startsWith(" ") && justPremises[i].endsWith(" "))
            justPremises[i] = justPremises[i].trim();

         if (justPremises[i].startsWith(" "))
            justPremises[i] = justPremises[i].replaceFirst(" ","");
         else{}

         if(!allPremises.contains(justPremises[i]))
         {
            allPremises = allPremises + justPremises[i];
            numberOfPremises++;
         }
         else{}
      }

      eachPremise = new String[numberOfPremises];
      premiseLetter = new String[numberOfPremises];

      allPremises = "";

      System.out.println("\n" + numberOfPremises + " Proposiciones");

      for (i = 0; i<=(justPremises.length - 1); i++)
      {
         if(!allPremises.contains(justPremises[i]))
         { 
            eachPremise[h] = justPremises[i];
            premiseLetter[h] = "" + ((char)(A++));
            System.out.println("Premisa " + premiseLetter[h] + ": " + eachPremise[h++]);
            allPremises = allPremises + justPremises[i];
         }
         else{}
      }

      for (i = 0 ; i < premiseLetter.length ; i++)
      {
         eachPremise[i] = eachPremise[i].trim();
      }

      ////////FORMULA PROPOSICIONAL////////////////////////////////////////
      
///      System.out.println("\ncadWithSymboooools: " + cadWithSymbols + "\n\n");
      for (i = 0; i < numberOfPremises; i++)//reeemplazapreposicionesconletras
      {  
///         System.out.println(cadWithSymbols.contains(eachPremise[i]));
///         System.out.println(eachPremise[i] + "\t" + premiseLetter[i]);////
         cadWithSymbols = cadWithSymbols.replaceAll(eachPremise[i],premiseLetter[i]);
///         System.out.println(cadWithSymbols.contains(eachPremise[i]));
///         System.out.println("cadWithSymbols: " + cadWithSymbols + "\n");///
      }
      propFormula = cadWithSymbols;
      

      propFormula = propFormula.replaceAll(" ","");

      String propFormulaToDisplay = new String(propFormula);

      propFormulaToDisplay = propFormulaToDisplay.replaceAll("~7~","¬");
      propFormulaToDisplay = propFormulaToDisplay.replaceAll("~AND~","⋀");
      propFormulaToDisplay = propFormulaToDisplay.replaceAll("~OR~","⋁");
      propFormulaToDisplay = propFormulaToDisplay.replaceAll("~=~","⟶ ");
      propFormulaToDisplay = propFormulaToDisplay.replaceAll("~==~","⇌ ");
      

      propFormulaToDisplay = propFormulaToDisplay.replaceAll("OPEN","(");
      propFormulaToDisplay = propFormulaToDisplay.replaceAll("CLOSE",")");

      System.out.println("Formula Proposicional: " + propFormulaToDisplay + "\n");
    
      /////////////TABLA DE VERDAD////////////////////
      String letras = "";

      for (i = 0;i < premiseLetter.length ;i++)
      {
         letras = letras + premiseLetter[i];
      }

      System.out.println(" #\t" + letras);

      for(i = 0;i < Math.pow(2,numberOfPremises);i++)
      {
        CaseHandler ch0 = new CaseHandler(propFormulaToDisplay,premiseLetter,i,(int)Math.pow(2,numberOfPremises));
        tableResult = tableResult + ch0.caseResult;
      }

     /////////CONCLUSION DE LA TABLA

     if (!tableResult.contains("F"))
        conclusion = "Tautologia";
     else
     {
        if (!tableResult.contains("T"))
           conclusion = "Contradiccion";
        else
           conclusion = "Contingencia";
     }

     System.out.println("\nEl resultado es una " + conclusion);

   }

     private void deleteLastChar(String cadena)
     {
        char[] charArray = cadena.toCharArray();
     }
}

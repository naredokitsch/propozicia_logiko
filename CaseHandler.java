
/*
Crea objetos que reciben cadWithSymbols, con un numero de asignado y la cadena de variables a tratar. 
Cada objeto corresponde a un caso de la tabla de verdad.
*/
public class CaseHandler
{
  int id;//util
  int reverseID;//util
  String cadena;//util
  String binario;//util
  private char[] binArr;
  private Integer ent;
  private int i;
  private String bin;
  String TyF;//util
  private String tmp;
  private int totalCases;
  String caseResult = new String("");
   
  CaseHandler(String kadena, String[] var,int num, int num2)
  {
    id = num; //el numero es ahora su id
    totalCases = num2;
    reverseID = totalCases - id - 1;
    ent = new Integer(num);
    binario = ent.toBinaryString(num);
    binArr = binario.toCharArray();
    Meths meths = new Meths();
    //el numero se convierte en binario en un array de chars

    char[] binFin;
    binFin = new char[var.length];
    
    for(i = 0;i < binFin.length;i++)
    {
      binFin[i] = '0';
      //System.out.println(binFin[i]);
    }
    
    int nm = 0;
    for(i = ((binFin.length - 1) - (binArr.length - 1));i < binFin.length;i++)
    {
      binFin[i] = binArr[nm++];
    }

    for(i = 0; i < binFin.length; i++)
    {
      if(binFin[i] == '0')
      {
        binFin[i] = 'T';
      }

      if(binFin[i] == '1')
      {
        binFin[i] = 'F';
      }

      else{}
    }
    

    bin= binario.copyValueOf(binFin);//static
    TyF = bin;
    
    cadena = kadena;

    for(i = 0;i < var.length; i++)
    {
      String temp1 = "" + binFin[i];
      cadena = cadena.replaceAll(var[i],temp1);
    }

    caseResult = meths.develop(cadena);
    System.out.println("[" + reverseID + "]\t"  + TyF + "\t" + cadena + "\t" + caseResult);

  }
}

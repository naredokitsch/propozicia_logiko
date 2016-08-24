public class Meths
{
   public String innerString(String fullString)
   {
      if (fullString.contains("(") && fullString.contains(")"))
      {
         int closeParentheses = fullString.indexOf(')');
         int openParentheses = fullString.lastIndexOf('(',closeParentheses);
         return (fullString.substring(openParentheses + 1,closeParentheses));
      }
      else 
      {
         return null;
      }
   }

   public char notOp(char arr[])
   {
      if (arr[1] == 'T')
         return 'F';
      if (arr[1] == 'F')
         return 'T';
      else
         return 'e';
   }

   public char andOp(char arr[])
   {
      if (arr[0] == 'T' && arr[2] == 'T')
         return 'T';
      else
         return 'F'; 
   }
   
   public char orOp(char arr[])
   {
      if (arr[0] == 'T' || arr[2] == 'T')
         return 'T';
      else
         return 'F'; 
   }

   public char condOp(char arr[])//Espacio
   {
      if (arr.length == 4)
            arr[2] = arr[3];
       else{}

      if (arr[0] == 'T' && arr[2] == 'F')
         return 'F';
      else
         return 'T';
   }

   public char bicOp(char arr[])
   {
      if (arr.length == 4)
         arr[2] = arr[3];
      else{}     

      if (arr[0] == arr[2])
         return 'T';
      else
         return 'F';
   }

   public char operador(String cadena)
   {
      if (cadena.contains("¬"))
         return notOp(cadena.toCharArray());
      if (cadena.contains("⋀"))
         return andOp(cadena.toCharArray());
      if (cadena.contains("⋁"))
         return orOp(cadena.toCharArray());
      if (cadena.contains("⟶"))
         return condOp(cadena.toCharArray());
      if (cadena.contains("⇌"))
         return bicOp(cadena.toCharArray());
      else
         return 'e';
   } 
//////////////
   public String develop(String fullString)
   {
      String cadena = "";

      while (fullString.contains("(") || fullString.contains(")"))
      {
         cadena = innerString(fullString);
         fullString = fullString.replace("(" + cadena + ")",cadena.valueOf(operador(cadena)));
      }                                                                //Ya no hay parentesis
      
      while (fullString.contains("¬"))
      {
         cadena = fullString.substring(fullString.indexOf("¬"),fullString.indexOf("¬") + 2);
         fullString = fullString.replace(cadena,cadena.valueOf(notOp(cadena.toCharArray())));
      }
      
      while (fullString.contains("⋀"))
      {
         cadena = fullString.substring(fullString.indexOf("⋀") - 1,fullString.indexOf("⋀") + 2);
         fullString = fullString.replace(cadena,cadena.valueOf(andOp(cadena.toCharArray())));
      }

      while (fullString.contains("⋁"))
      {
         cadena = fullString.substring(fullString.indexOf("⋁") - 1,fullString.indexOf("⋁") + 2);
         fullString = fullString.replace(cadena,cadena.valueOf(orOp(cadena.toCharArray())));
      }

      while (fullString.contains("⟶"))
      {
         if (fullString.charAt(fullString.indexOf('⟶') + 1) == ' ')
            cadena = fullString.substring(fullString.indexOf("⟶") - 1,fullString.indexOf("⟶") + 3);
         if (fullString.charAt(fullString.indexOf('⟶') + 1) != ' ')
            cadena = fullString.substring(fullString.indexOf("⟶") - 1,fullString.indexOf("⟶") + 2);
         else{}
         fullString = fullString.replace(cadena,cadena.valueOf(condOp(cadena.toCharArray())));
      }

      while (fullString.contains("⇌"))
      {
         if (fullString.charAt(fullString.indexOf('⇌') + 1) == ' ')
            cadena = fullString.substring(fullString.indexOf("⇌") - 1,fullString.indexOf("⇌") + 3);
         if (fullString.charAt(fullString.indexOf('⇌') + 1) != ' ')
            cadena = fullString.substring(fullString.indexOf("⇌") - 1,fullString.indexOf("⇌") + 2);

         else{}
         fullString = fullString.replace(cadena,cadena.valueOf(bicOp(cadena.toCharArray())));
      }
      return fullString;
   }
}

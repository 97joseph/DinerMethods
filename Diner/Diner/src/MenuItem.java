enum MenuItem {
   STARTER, MAIN, PUDDING, SIDE, DRINK;

   static MenuItem called (String s) {
     if  (  s == null  )  return null;
     else if  (   Character.toUpperCase(s.charAt(0)) == 'S'  )
        if  (  s.length() == 1  )  return null;
        else
           return
             switch (Character.toUpperCase(s.charAt(1)) ) {
               case 'T' -> STARTER;
               case 'I' -> SIDE;
               default -> null;
             };
      else
        return
          switch (Character.toUpperCase(s.charAt(0))) {
            case 'M' -> MAIN;
            case 'P' -> PUDDING;
            case 'D' -> DRINK;
            default -> null;
          };
   }
//Call method
   public String toString() {
     return name().charAt(0)+name().substring(1).toLowerCase();
   }

}

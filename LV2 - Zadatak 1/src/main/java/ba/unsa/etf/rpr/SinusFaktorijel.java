package ba.unsa.etf.rpr;

public class SinusFaktorijel {

    public static void main( String[] args ){
        if (args.length != 2){
            System.err.println("Neispravan broj argumenata");
        } else if (!args[0].equals("sinus") && !args[0].equals("faktorijel")) {
            System.err.println("Neispravna funkcija");
        } else{
            try {
                String funkcija = args[0];
                double unos = Double.parseDouble(args[1]);
                switch (funkcija){
                    case "sinus":
                        System.out.println("sinus("+unos+")="+Math.sin(unos));
                        break;
                    case "faktorijel":
                        System.out.println("faktorijel("+unos+")="+Math.faktorijel((int)unos));
                        break;
                }
            } catch (Exception e){
                System.err.println("Neispravan argument");
            }
        }
    }
}
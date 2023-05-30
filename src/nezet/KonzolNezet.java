package nezet;

import java.util.ArrayList;
import modell.Kert;
import modell.Noveny;

public class KonzolNezet {
    public static void main(String[] args) {
        ArrayList<Noveny> novenyek = new ArrayList();
        Noveny n1 = new Noveny("no01", "piros növény", 1000, 1);
        Noveny n2 = new Noveny("no02", "kék növény", 2000, 2);
        Noveny n3 = new Noveny("no03", "sárga növény", 3000, 3);
        Noveny n4 = new Noveny("no04", "fehér növény", 4000, 4);
        novenyek.add(n1);
        novenyek.add(n2);
        novenyek.add(n3);
        novenyek.add(n4);
        Kert kert1 = new Kert(novenyek);
        
        kert1.NovenyekKiir();
        kert1.StatisztikaMentes("kert.bin");
        kert1.Frissites("kert.bin");
    }
}

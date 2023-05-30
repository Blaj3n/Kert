package modell;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class Kert {

    private ArrayList<Noveny> novenyek = new ArrayList<Noveny>();

    public Kert() {
        Noveny n1 = new Noveny("no01", "piros növény", 1000, 1);
        Noveny n2 = new Noveny("no02", "kék növény", 2000, 2);
        Noveny n3 = new Noveny("no03", "sárga növény", 3000, 3);
        novenyek.add(n1);
        novenyek.add(n2);
        novenyek.add(n3);
    }

    public Kert(ArrayList<Noveny> novenyek) {
        this.novenyek = novenyek;
    }

    public void novenyBeszerez(Noveny noveny) {
        novenyek.add(noveny);
    }

    public void NovenyekKiir() {
        for (Noveny noveny : novenyek) {
            System.out.println("------------------");
            System.out.print("Növény Azonosító: ");
            System.out.println(noveny.getAzonosito());
            System.out.print("Növény Név: ");
            System.out.println(noveny.getNev());
            System.out.print("Növény Ár: ");
            System.out.println(noveny.getAr());
            System.out.print("Növény Kor: ");
            System.out.println(noveny.getKor());
        }
    }

    public void StatisztikaMentes(String fajl) {
        try {
            FileOutputStream fajlKi = new FileOutputStream("kert.bin");
            ObjectOutputStream objKi = new ObjectOutputStream(fajlKi);
            objKi.writeObject(novenyek);
            objKi.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Kert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Kert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Frissites(String fajl) {
        try {
            FileInputStream beFajl;
            beFajl = new FileInputStream("kert.bin");
            ObjectInputStream beObj = new ObjectInputStream(beFajl);
            novenyek = (ArrayList<Noveny>) beObj.readObject();
            beObj.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Kert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Kert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

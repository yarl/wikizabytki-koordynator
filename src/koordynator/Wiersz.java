package koordynator;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 *
 * @author Pawel
 */
public class Wiersz {
    String wiersz;
    boolean koordynaty, zdjecie, commons;
    
    public Wiersz(String wiersz) {
        this.wiersz = wiersz;
        Pattern p,q;
        
        p = Pattern.compile("koordynaty");
        q = Pattern.compile("szerokość");
        koordynaty = (p.matcher(wiersz).find() || q.matcher(wiersz).find()) ? true : false;
        
        if(koordynaty) {
            p = Pattern.compile("koordynaty *= *\n");
            q = Pattern.compile("szerokość *= *\n");
            koordynaty = (p.matcher(wiersz).find() || q.matcher(wiersz).find()) ? false : true;
        }

//        p = Pattern.compile("koordynaty *= *\n");
//        q = Pattern.compile("szerokość *= *\n");
//        koordynaty = (p.matcher(wiersz).find() || q.matcher(wiersz).find()) ? false : true;
//        if(koordynaty) {
//            p = Pattern.compile("koordynaty");
//            koordynaty = (p.matcher(wiersz).find()) ? true : false;
//        }
        
        p = Pattern.compile("zdjęcie *= *\n");
        zdjecie = (p.matcher(wiersz).find()) ? false : true;
        if(zdjecie) {
            p = Pattern.compile("zdjęcie");
            zdjecie = (p.matcher(wiersz).find()) ? true : false;
        }
        
        p = Pattern.compile("commons *= *\n");
        commons = (p.matcher(wiersz).find()) ? false : true;
        if(commons) {
            p = Pattern.compile("commons");
            commons = (p.matcher(wiersz).find()) ? true : false;
        }
    }

    /*
     * 
     */
    public boolean jestKoordynaty() {
        return koordynaty;
    }
    
    public boolean jestZdjecie() {
        return zdjecie;
    }
    
    public boolean jestCommons() {
        return commons;
    }
    
    
    /*
     * 
     */
    public String zwrocWiersz() {
        return wiersz;
    }
        
    public String zwrocCommons() {
        String temp[] = wiersz.split("\n");
        for(String i : temp) {
            if(i.contains("commons")) {
                i = i.replaceAll(" *\\| *commons *= *", "");
                return i;
            }
        }
        return "";
    }
    
    public String zwrocZdjecie() {
        String temp[] = wiersz.split("\n");
        for(String i : temp) {
            if(i.contains("zdjęcie")) {
                i = i.replaceAll(" *\\| *zdjęcie *= *", "");
                return i;
            }
        }
        return "";
    }
    
    /*
     * 
     */
    public void zapiszKoordynaty(float N, float E) throws Exception {
        if(wiersz.contains("koordynaty")) {
            wiersz = wiersz.replaceAll(" *\\| *koordynaty *= *", "| szerokość = " + N + "\n| długość   = " + E);
//                String temp[] = wiersz.split("\n");
//                for(String i : temp) {
//                    if(i.contains("koordynaty")) {
//                        i = i.replaceAll(" *\\| *commons *= *", "");
//                        break;
//                    }
//                }
        } else if(wiersz.contains("szerokość") && wiersz.contains("długość")) {
            wiersz = wiersz.replaceAll(" *\\| *szerokość *= *", "| szerokość = " + N);
            wiersz = wiersz.replaceAll(" *\\| *długość *= *", "| długość   = " + N);
        } else
            throw new Exception("Brak parametru w szablonie");
    }
}

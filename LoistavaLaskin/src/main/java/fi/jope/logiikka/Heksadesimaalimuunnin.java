package fi.jope.logiikka;

public class Heksadesimaalimuunnin {

    
    public long heksadesimaalistaDesimaal(String hd) {
        return Long.parseLong(hd, 16);
    }
    
    public String desimaalistaHeksadesimaali(long desimaali) {
        return Long.toHexString(desimaali);
    }
}

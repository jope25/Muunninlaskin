package fi.jope.logiikka;

public class LampotilaMuunnin implements Toiminto {

    private double lampotila;

    public LampotilaMuunnin(double lampotila) {
        this.lampotila = lampotila;
    }

// suunta: 1 = celsius muutetaan toiseksi, kelvin fahrenheitiks    

    public void celsiusFahrenheit(int suunta) {
        if (suunta == 1) {
            lampotila *= 1.8;
            lampotila += 32;
        } else if (suunta == -1) {
            lampotila -= 32;
            lampotila /= 1.8;
        }
    }

    public void celsiusKelvin(int suunta) {
        if (suunta == 1) {
            lampotila += 273.15;
        } else if (suunta == -1) {
            lampotila -= 273.15;
        }
    }

    public void kelvinFahrenheit(int suunta) {
        if (suunta == 1) {
            celsiusKelvin(-1);
            celsiusFahrenheit(1);
        } else if (suunta == -1) {
            celsiusFahrenheit(-1);
            celsiusKelvin(-1);
        }
    }

    @Override
    public double getArvo() {
        return this.lampotila;
    }

}

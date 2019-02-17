package br.com.philippesis.geoloccalc.main;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {

        //
        double latitudeInicial = 23.550939;
        double longitudeInicial = 46.634254;
        //
        double latitudeFinal = 23.553898;
        double longitudeFinal = 46.632327;

        // Formatação saída
        DecimalFormat df = new DecimalFormat("###,##0.0000");
        // Aredonda para cima
        df.setRoundingMode(RoundingMode.UP);
        // Imprime formatando
        System.out.println(df.format((calcDistancia(latitudeInicial, longitudeInicial, latitudeFinal,
                longitudeFinal)))+"KM");

    }

    // Método que calcula distância entre cordenadas
    private static double calcDistancia(double lat_inicial, double long_inicial, double lat_final, double long_final) {

        double d2r = 0.017453292519943295769236;

        double dlong = (long_final - long_inicial) * d2r;
        double dlat = (lat_final - lat_inicial) * d2r;

        double temp_sin = sin (dlat/2.0);
        double temp_cos = cos(lat_inicial * d2r);
        double temp_sin2 = sin(dlong/2.0);

        double a = (temp_sin * temp_sin) + (temp_cos * temp_cos) * (temp_sin2 * temp_sin2);
        double c = 2.0 * atan2(sqrt(a), sqrt(1.0 - a));

        return 6368.1 * c;
    }


}

package ar.com.ada.api.noaa.utils;

public class UbicacionesUtils {

    public static boolean validarLatitud(double latitud) {
        // -93

        // -100 -90 -80 -70 -60 -50 -40 -30 -10 0 10 20 30 40 50 60 70 80 90 100
        // 0 10 20 30 40 50 60 70 80 90 100
        // valor absoluto: |n| >= 0
        // if (latitud >= -90 && latitud <= 90) {
        if (Math.abs(latitud) >= 0 && Math.abs(latitud) <= 90) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean validarLongitud(double longitud) {
        if (Math.abs(longitud) <= 180) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarCoordenadas(double longitud, double latitud) {
        if (validarLatitud(latitud) && validarLongitud(longitud)) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean validarCoordenadasFueraDelPlaneta(double longitud, double latitud) {
        /*
         * if (validarLatitud(latitud) && validarLongitud(longitud)){ return false;
         * }else { return true; }
         */
        return !validarCoordenadas(longitud, latitud);

    }

    public static boolean validarSiEsHemisferioNorte(double latitud, double longitud){

        if (!validarCoordenadas(longitud, latitud))
            return false;
        if(latitud>=0 && latitud<=90) {
            return true;
        } else {
            return false;
        }

    }
}

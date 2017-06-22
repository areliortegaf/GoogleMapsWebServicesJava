/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asortega.mavenwebservices;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author asortega
 */
public class Geocoding {

    //FIELDS
    private static final long TWO_SECONDS = 2 * 1000;
    private GeoApiContext contexto;
    private static final String GOOGLE_MEXICO = "ChIJU1NoiDs6BIQREZgJa760ZO0";//PLace Id de mexico

    //Imprime la direccion o direcciones posibles en varios formatos, string de la direccion
    public void geocodingAll(String pDireccion) {
        //IMPRIME TODAS LAS DIRECCIONES POSIBLES
        System.out.println("--------------Geocoding con direccion varios resultados------------------");
        GeocodingApiRequest req = GeocodingApi.newRequest(contexto).address(pDireccion);
        try {
            GeocodingResult[] result = req.await();
            System.out.println("RESULTADOS: " + result.length);
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i].formattedAddress);
                AddressComponent[] ac = result[i].addressComponents;
                for (AddressComponent acSingle : ac) {
                    System.out.println(acSingle.longName + " " + acSingle.shortName);
                }
            }

        } catch (Exception e) {

        }
    }

    //regresa una sola direccion ingresando un string
    public void geocoding(String pDireccion) {
        System.out.println("--------------Geocoding con direccion 1 solo resultado------------------");
        try {

            GeocodingResult[] results = GeocodingApi.geocode(contexto,
                    pDireccion).await();
            System.out.println("Resultado: " + results[0].formattedAddress);
        } catch (ApiException | InterruptedException | IOException e) {
            System.out.println(e);
        }
    }

    //Lanza todos los resultados con Coordenadas (agregar parametros)
    public void geocodingLatLngAll(double pLat, double pLng) {
        System.out.println("--------------Geocoding con coordenadas varios resultados------------------");
        //GeoApiContext context = new GeoApiContext().setApiKey(API);//contiene la llave

        LatLng coordenadas = new LatLng(pLat, pLng);
        GeocodingApiRequest req = GeocodingApi.newRequest(contexto).latlng(coordenadas);
        try {
            GeocodingResult[] result = req.await();
            System.out.println("RESULTADOS: " + result.length);
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i].formattedAddress);
                AddressComponent[] ac = result[i].addressComponents;
                for (AddressComponent acSingle : ac) {
                    System.out.println(acSingle.longName + " " + acSingle.shortName);
                }
            }

        } catch (Exception e) {

        }
    }

    //regresa una sola direccion ingresando coordenadas
    public void geocodingLatLng(double pLat, double pLng) {
        System.out.println("--------------Geocoding con coordenadas 1 solo resultado------------------");
        LatLng coordenadas = new LatLng(pLat, pLng);
        GeocodingApiRequest req = GeocodingApi.newRequest(contexto).latlng(coordenadas);
        try {
            GeocodingResult[] result = req.await();
            System.out.println("Resultado: " + result[0].formattedAddress);
            AddressComponent[] ac = result[0].addressComponents;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Geocoding(GeoApiContext context) {
        this.contexto = context
                .setConnectTimeout(2, TimeUnit.SECONDS)
                .setReadTimeout(2, TimeUnit.SECONDS)
                .setWriteTimeout(2, TimeUnit.SECONDS);
        /*
        double Latitud = 40.714224;
        double Longitud = -73.961452;
        geocodingAll("walter scott 906 alamedas chihuahua");
        geocoding("walter scott 906 alamedas chihuahua");
        geocodingLatLng(Latitud, Longitud);
        geocodingLatLngAll(Latitud, Longitud);
         */
    }

}

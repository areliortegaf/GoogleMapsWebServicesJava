/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asortega.mavenwebservices;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import java.io.IOException;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.PlaceAutocompleteRequest;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.GeocodingResult;
//
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
import java.io.IOException;

/**
 *
 * @author asortega
 */
public class WebServices implements Llave {
    //FIELDS NECESARIOS PARA ARRANCAR

    GeoApiContext contexto = Llave.context;
    //PRUEBAS
    //PROBAR CON DIRECCIONES:
    String vDireccion1 = "Chihuahua, Mexico";
    String vDireccion2 = "Guadalajara, Jalisco, Mexico";

    //PROBAR CON COORDENADAS
    double Latitud1 = 28.64924820;
    double Longitud1 = -106.06472320;

    double Latitud2 = 19.38225490;
    double Longitud2 = -99.13171700;

    public void probarPlaces() {
        System.out.println("--------------------------------PRUEBA PLACES-----------------------------------");
        Places pruebaPlaces = new Places(contexto);
        pruebaPlaces.placesLatLng("Pizza del Rey", "Chihuahua Mexico");
        System.out.println("----------------OBTIENE COORDENADAS DEL LUGAR----------------------");
        String probarLat = pruebaPlaces.obtenerLatitud();
        String probarLng = pruebaPlaces.obtenerLongitud();
        System.out.println(probarLat);
        System.out.println(probarLng);
        System.out.println("---------------------------------------------------------------------------------");

    }

    public void probarGeocoding() {
        System.out.println("--------------------------------PRUEBA GEOCODING-----------------------------------");
        Geocoding pruebaGeocoding = new Geocoding(contexto);
        System.out.println("----------------GEOCODING CON DIRECCION----------------------");
        pruebaGeocoding.geocoding(vDireccion1);
        System.out.println("----------------GEOCODING CON DIRECCION/VARIAS FORMAS----------------------");
        pruebaGeocoding.geocodingAll(vDireccion1);
        System.out.println("----------------GEOCODING CON COORDENADAS----------------------");
        pruebaGeocoding.geocodingLatLng(Latitud1, Longitud1);
        System.out.println("----------------GEOCODING CON COORDENADAS/VARIAS FORMAS----------------------");
        pruebaGeocoding.geocodingLatLngAll(Latitud1, Longitud1);
        System.out.println("---------------------------------------------------------------------------------");
    }

    public void probarDirections() {
        System.out.println("--------------------------------PRUEBA DIRECTIONS-----------------------------------");
        Directions pruebaDirections = new Directions(contexto);
        System.out.println("----------------DIRECTIONS CON DIRECCION----------------------");
        pruebaDirections.direcciones(vDireccion1, vDireccion2);
        System.out.println("----------------DIRECTIONS CON COORDENADAS----------------------");
        pruebaDirections.direccionesLatLng(Latitud1, Longitud1, Latitud2, Longitud2);
        System.out.println("---------------------------------------------------------------------------------");
    }

    public void probarAutocomplete() {
        System.out.println("--------------------------------PRUEBA AUTOCOMPLETE-----------------------------------");
        Autocomplete pruebaAutocomplete = new Autocomplete(contexto);
        pruebaAutocomplete.predicciones(vDireccion1);
        System.out.println("---------------------------------------------------------------------------------");
    }

    //CONSTRUCTOR
    public WebServices() {
        probarPlaces();
        probarGeocoding();
        probarDirections();
        probarAutocomplete();

    }

    public static void main(String[] args) {
        new WebServices();
    }
}

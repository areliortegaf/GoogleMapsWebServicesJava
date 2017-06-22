/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asortega.mavenwebservices;

import com.google.maps.GeoApiContext;
import com.google.maps.PlaceAutocompleteRequest;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.PlacesSearchResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.text.View;

/**
 *
 * @author asortega
 */
public class Autocomplete {

    private static final long TWO_SECONDS = 2 * 1000;
    private GeoApiContext contexto;
    private static final String GOOGLE_MEXICO = "ChIJU1NoiDs6BIQREZgJa760ZO0";//PLace Id de mexico
    double Latitud = 40.714224;
    double Longitud = -73.961452;
    int tamano;

    public void predicciones(String pBusqueda) {
        try {
            //Seguir patron
            PlaceAutocompleteRequest autocomplete = PlacesApi.placeAutocomplete(contexto, pBusqueda);
            autocomplete.offset(4);
            AutocompletePrediction[] auto = autocomplete.await();

            //System.out.println("a ver placeId " + auto[0].placeId);//si trai el place Id del luega
            //System.out.println("descripcion " + auto[0].description);//trae el nombre del lugar
            for (int i = 0; i <= auto.length; i++) {
                System.out.println("descripcion " + auto[i].description);
            }

        } catch (ApiException | InterruptedException | IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Fin de la busqueda");
        }
    }

    public Autocomplete(GeoApiContext context) {
        this.contexto = context
                .setConnectTimeout(2, TimeUnit.SECONDS)
                .setReadTimeout(2, TimeUnit.SECONDS)
                .setWriteTimeout(2, TimeUnit.SECONDS);

        // predicciones("Chihuahua Chihuahua");
    }

}

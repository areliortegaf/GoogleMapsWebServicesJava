/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asortega.mavenwebservices;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;

import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.ComponentFilter;
import com.google.maps.model.LatLng;
import com.google.maps.model.Photo;
import com.google.maps.model.PhotoResult;
import com.google.maps.model.PlaceAutocompleteType;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlaceIdScope;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

/**
 *
 * @author asortega
 */
public class Places {

    //FIELDS
    private static final long TWO_SECONDS = 2 * 1000;
    private GeoApiContext context;
    private static final String GOOGLE_MEXICO = "ChIJU1NoiDs6BIQREZgJa760ZO0";//PLace Id de mexico
//CONSTRUCTOR

    public Places(GeoApiContext context) {
        this.context = context
                .setConnectTimeout(2, TimeUnit.SECONDS)
                .setReadTimeout(2, TimeUnit.SECONDS)
                .setWriteTimeout(2, TimeUnit.SECONDS);

        //placesLatLng("pizza del rey", "mexico");//Lugar a buscar y pais
    }

    //TRAE SEGUN LA BUSQUEDA LA LAT Y LANG DEL LUGAR BUSCADO
    String cord[] = new String[2];

    public String[] placesLatLng(String uni, String pais) {

        boolean status = true;
        uni = Utilit.format(uni);
        System.out.println(">>>>>> Consultando valor normalizado a-> " + uni);
        //String cord[] = new String[2];
        try {
            
            PlacesSearchResponse result = PlacesApi.textSearchQuery(context, uni).await();
            context.setRetryTimeout(2, TimeUnit.DAYS);
            if (result.results != null) {

                cord[0] = "" + result.results[0].geometry.location.lat;
                cord[1] = "" + result.results[0].geometry.location.lng;
                System.out.println("Ok encontrado en: ");
                System.out.println("LAT " + cord[0]);
                System.out.println("LNG " + cord[1]);
            } else {
                System.out.println("Sin resultados");
                return null;
            }

        } catch (java.lang.IllegalStateException e) {
            System.out.println("Revise su API no es valida");
            status = false;
        } catch (Exception ex) {
            System.out.println("ERROR al recuperar del server");
            Logger.getLogger(Places.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cord;
    }

    public String obtenerLatitud() {
        return cord[0];
    }

    public String obtenerLongitud() {
        return cord[1];
    }

}

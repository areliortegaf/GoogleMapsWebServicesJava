/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asortega.mavenwebservices;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.google.maps.model.TrafficModel;
import com.google.maps.model.TravelMode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

//para el departuretime
import org.joda.time.ReadableInstant;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;

/**
 *
 * @author asortega
 */
public class Distance {

    String vDireccion = "walter scott 906 alamedas chihuahua";
    
    GeoApiContext contexto = Llave.context;
    double Latitud = 28.723624;
    double Longitud = -106.119651;
    double Latitud2 = 28.719821;
    double Longitud2 = -106.093650;
    int tamano;

    public Distance() {
        prueba();
    }
//cambiar a la fecha del envio o usar la actual
    Date date = new Date();
    DateTime dateTime = new DateTime(date);

    public void prueba() {

        try {
            LatLng origen = new LatLng(Latitud, Longitud);
            LatLng destino = new LatLng(Latitud2, Longitud2);
            DistanceMatrixApiRequest matrix = DistanceMatrixApi.newRequest(contexto)
                    .origins(origen)
                    .destinations(destino)
                    .mode(TravelMode.DRIVING)
                    .trafficModel(TrafficModel.PESSIMISTIC)
                    .departureTime(dateTime);
            DistanceMatrix dm = matrix.await();
            System.out.println("Destination Adress: " + dm.destinationAddresses.toString());
            System.out.println("Origin Adress: " + dm.originAddresses);
            System.out.println("Rows: " + dm.rows);
           
        } catch (ApiException | InterruptedException | IOException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
    
    public void prueba2(){
        try {
            
            int i = 0;
            String origen[] = new String[i];
            String destino[] = new String[i];
            
            origen[0]="chihuahua, chihuahua";
            destino[0]="ciudad de mexico";
            
            DistanceMatrixApiRequest matrix = DistanceMatrixApi.getDistanceMatrix(contexto, origen, destino)
                    .mode(TravelMode.DRIVING)
                    .trafficModel(TrafficModel.PESSIMISTIC)
                    .departureTime(dateTime);
            DistanceMatrix dm = matrix.await();
            for (i = 0; i <= origen.length ; i++){
                System.out.println("??????" + dm.rows[i]);
            }
            
            
            //System.out.println("Destination Adress: " + Arrays.toString(dm.destinationAddresses));
            //System.out.println("Origin Adress: " + Arrays.toString(dm.originAddresses));
            //System.out.println("Rows: " + Arrays.toString(dm.rows));
           
        } catch (ApiException | InterruptedException | IOException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    

}

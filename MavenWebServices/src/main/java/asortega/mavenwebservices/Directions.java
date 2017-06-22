/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asortega.mavenwebservices;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.DirectionsStep;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.GeocodedWaypoint;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
import com.squareup.okhttp.Route;
import java.io.IOException;
import static java.lang.Math.toIntExact;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Calendar.*;
import java.util.HashMap;
import java.util.List;
import java.util.logging.LogManager;
import org.joda.time.DateTime;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.joda.time.ReadableInstant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author asortega
 */
public class Directions {
//arreglar que no traiga el objeto

    private static final long TWO_SECONDS = 2 * 1000;
    private GeoApiContext contexto;
    private static final String GOOGLE_MEXICO = "ChIJU1NoiDs6BIQREZgJa760ZO0";//PLace Id de mexico
    double Latitud = 28.649169;
    double Longitud = -106.064628;
    double Latitud2 = 19.382260;
    double Longitud2 = -99.131950;

    //Para los metodos
    ReadableInstant tiempo;
    java.util.Date salida = new java.util.Date();

    //Se asigna una fecha
    //conversion de tipos  a jodatime
    AsignarFecha nuevaFecha = new AsignarFecha();
    //se asignal la fecha
    DateTime horaSalida = nuevaFecha.asignarHoraDeSalida(2020, "enero", 1, 10, 00);
    org.joda.time.Instant instantaneo = horaSalida.toInstant();
    ReadableInstant vSalida = instantaneo;

    public void direcciones(String pOrigen, String pDestino) {
        try {

            DirectionsResult result = DirectionsApi.newRequest(contexto)
                    .origin(pOrigen)
                    .destination(pDestino)
                    .mode(TravelMode.DRIVING)
                    .departureTime(vSalida)
                    .await();

            for (DirectionsRoute route : result.routes) {

                String formateoFecha = vSalida.toString();
                DateTime conFormato = new DateTime(formateoFecha);

                long segundosLong = route.legs[0].duration.inSeconds;
                int segundosInt = toIntExact(segundosLong);

                java.time.LocalTime segFormateados = java.time.LocalTime.MIN.plusSeconds(segundosInt);//se formatearon los segundos al formato

                Date fecha = conFormato.toDate(); //fecha larga

                Calendar cal = Calendar.getInstance();
                cal.setTime(fecha);
                cal.add(Calendar.SECOND, segundosInt);
                cal.getTime();

                Date fechaDeEntrega = cal.getTime();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd : HH.mm");
                String fechaFormato = formatoFecha.format(fechaDeEntrega);
                String fechaDeSalida = formatoFecha.format(fecha);

                System.out.println("------------------DETALLES DEL ENVIO----------------------------");
                System.out.println("Distancia: " + route.legs[0].distance);
                System.out.println("------------------HORA--------------------");
                System.out.println("Hora de Salida: " + fechaDeSalida);
                System.out.println("Duracion : " + segFormateados);
                System.out.println("Tiempo de llegada: " + fechaFormato);
                System.out.println("------------------TRAFICO-------------------");
                System.out.println("Duracion en el Trafico: " + route.legs[0].durationInTraffic);
                System.out.println("------------------ORIGEN---------------------");
                System.out.println("Direccion Inicial: " + route.legs[0].startAddress);
                System.out.println("Coordenadas: " + route.legs[0].startLocation);
                System.out.println("------------------DESTINO--------------------");
                System.out.println("Direccion final: " + route.legs[0].endAddress);
                System.out.println("Coordenadas: " + route.legs[0].endLocation);

            }
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }

    public void direccionesLatLng(double pLatOrigen, double pLngOrige, double pLatDestino, double pLngDestino) {
        LatLng origen = new LatLng(pLatOrigen, pLngOrige);
        LatLng destino = new LatLng(pLatDestino, pLngDestino);
        try {
            DirectionsResult result = DirectionsApi.newRequest(contexto)
                    .origin(origen)
                    .destination(destino)
                    .mode(TravelMode.DRIVING)
                    .departureTime(vSalida)
                    .await();

            for (DirectionsRoute route : result.routes) {

                String formateoFecha = vSalida.toString();
                DateTime conFormato = new DateTime(formateoFecha);

                long segundosLong = route.legs[0].duration.inSeconds;
                int segundosInt = toIntExact(segundosLong);

                java.time.LocalTime segFormateados = java.time.LocalTime.MIN.plusSeconds(segundosInt);//se formatearon los segundos al formato

                Date fecha = conFormato.toDate(); //fecha larga

                Calendar cal = Calendar.getInstance();
                cal.setTime(fecha);
                cal.add(Calendar.SECOND, segundosInt);
                cal.getTime();

                Date fechaDeEntrega = cal.getTime();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd : HH.mm");
                String fechaFormato = formatoFecha.format(fechaDeEntrega);
                String fechaDeSalida = formatoFecha.format(fecha);

                System.out.println("------------------DETALLES DEL ENVIO----------------------------");
                System.out.println("Distancia: " + route.legs[0].distance);
                System.out.println("------------------HORA--------------------");
                System.out.println("Hora de Salida: " + fechaDeSalida);
                System.out.println("Duracion : " + segFormateados);
                System.out.println("Tiempo de llegada: " + fechaFormato);
                System.out.println("------------------TRAFICO-------------------");
                System.out.println("Duracion en el Trafico: " + route.legs[0].durationInTraffic);
                System.out.println("------------------ORIGEN---------------------");
                System.out.println("Direccion Inicial: " + route.legs[0].startAddress);
                System.out.println("Coordenadas: " + route.legs[0].startLocation);
                System.out.println("------------------DESTINO--------------------");
                System.out.println("Direccion final: " + route.legs[0].endAddress);
                System.out.println("Coordenadas: " + route.legs[0].endLocation);

            }
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public Directions(GeoApiContext context) {
        this.contexto = context
                .setConnectTimeout(2, TimeUnit.SECONDS)
                .setReadTimeout(2, TimeUnit.SECONDS)
                .setWriteTimeout(2, TimeUnit.SECONDS);

        /*
        System.out.println("-----------Con String----------------");
        direcciones("Chihuahua,Chihuahua", "Gudalajara,Jalisco");
        System.out.println("----------con Lat y Lang---------------");
        direccionesLatLng(Latitud, Longitud, Latitud2, Longitud2);
         */
    }

}

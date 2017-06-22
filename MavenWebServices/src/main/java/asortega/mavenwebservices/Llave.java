/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asortega.mavenwebservices;

import com.google.maps.GeoApiContext;

/**
 *
 * @author asortega
 */
public interface Llave {

    String API = "AIz...........................";
    GeoApiContext context = new GeoApiContext().setApiKey(API);

}

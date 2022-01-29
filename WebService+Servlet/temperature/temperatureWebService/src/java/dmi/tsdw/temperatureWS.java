/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmi.tsdw;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.*;

/**
 *
 * @author longo
 */
@WebService(serviceName = "temperatureWS")
public class temperatureWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTemperature")
    public Double getTemperature(@WebParam(name = "city") final String city) {
        ArrayList<String> ct = new ArrayList<String>();
        ArrayList<Double> temperature = new ArrayList<Double>();
        ct.add("Catania");
        ct.add("Palermo");
        ct.add("Milano");
        ct.add("Roma");
        ct.add("Torino");
        ct.add("Udine");
        ct.add("Cagliari");
        ct.add("Napoli");
        temperature.add(25.6);
        temperature.add(24.9);
        temperature.add(22.3);
        temperature.add(23.8);
        temperature.add(23.0);
        temperature.add(21.7);
        temperature.add(26.1);
        temperature.add(24.5);
        for(int i=0; i<ct.size(); i++) {
            if(ct.get(i).compareTo(city)==0) {
                return temperature.get(i);
            }
        }
        return 0.0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllTemperature")
    public String getAllTemperature() {
        ArrayList<String> ct = new ArrayList<String>();
        ArrayList<Double> temperature = new ArrayList<Double>();
        ct.add("Catania");
        ct.add("Palermo");
        ct.add("Milano");
        ct.add("Roma");
        ct.add("Torino");
        ct.add("Udine");
        ct.add("Cagliari");
        ct.add("Napoli");
        temperature.add(25.6);
        temperature.add(24.9);
        temperature.add(22.3);
        temperature.add(23.8);
        temperature.add(23.0);
        temperature.add(21.7);
        temperature.add(26.1);
        temperature.add(24.5);
        String req = "";
        for(int i=0; i<ct.size(); i++) {
            req+=ct.get(i) + ": " + temperature.get(i)+"; <br> ";
        }
        return req;
    }
}

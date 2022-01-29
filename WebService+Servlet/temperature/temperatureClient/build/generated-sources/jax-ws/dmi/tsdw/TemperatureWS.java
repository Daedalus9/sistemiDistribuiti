
package dmi.tsdw;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "temperatureWS", targetNamespace = "http://tsdw.dmi/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TemperatureWS {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllTemperature", targetNamespace = "http://tsdw.dmi/", className = "dmi.tsdw.GetAllTemperature")
    @ResponseWrapper(localName = "getAllTemperatureResponse", targetNamespace = "http://tsdw.dmi/", className = "dmi.tsdw.GetAllTemperatureResponse")
    @Action(input = "http://tsdw.dmi/temperatureWS/getAllTemperatureRequest", output = "http://tsdw.dmi/temperatureWS/getAllTemperatureResponse")
    public String getAllTemperature();

    /**
     * 
     * @param city
     * @return
     *     returns java.lang.Double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTemperature", targetNamespace = "http://tsdw.dmi/", className = "dmi.tsdw.GetTemperature")
    @ResponseWrapper(localName = "getTemperatureResponse", targetNamespace = "http://tsdw.dmi/", className = "dmi.tsdw.GetTemperatureResponse")
    @Action(input = "http://tsdw.dmi/temperatureWS/getTemperatureRequest", output = "http://tsdw.dmi/temperatureWS/getTemperatureResponse")
    public Double getTemperature(
        @WebParam(name = "city", targetNamespace = "")
        String city);

}

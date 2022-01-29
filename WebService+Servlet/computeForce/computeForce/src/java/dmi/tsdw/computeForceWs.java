/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmi.tsdw;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author longo
 */
@WebService(serviceName = "computeForceWs")
public class computeForceWs {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "computeForce")
    public double computeForce(@WebParam(name = "f") final double f, @WebParam(name = "m") final double m, @WebParam(name = "a") final double a) {
        if(f==0.0) return m*a;
        else if(m==0.0) return f/a; 
        return f/m;
    }
}

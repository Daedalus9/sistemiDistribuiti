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
@WebService(serviceName = "wsReverseService")
public class wsReverseService {

    /**
     * Web service operation
     * @param s
     * @return 
     */
    @WebMethod(operationName = "reverse")
    public String reverse(@WebParam(name = "s") final String s) {
        String reversed="";
        for(int i=s.length(); i>0; i--) {
            //reversed+=s.charAt((s.length()-i)-1);
            reversed+=s.charAt(i-1);
        }
        
        return reversed;
    }
}


package dmi.tsdw;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dmi.tsdw package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ComputeForceResponse_QNAME = new QName("http://tsdw.dmi/", "computeForceResponse");
    private final static QName _ComputeForce_QNAME = new QName("http://tsdw.dmi/", "computeForce");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dmi.tsdw
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ComputeForceResponse }
     * 
     */
    public ComputeForceResponse createComputeForceResponse() {
        return new ComputeForceResponse();
    }

    /**
     * Create an instance of {@link ComputeForce }
     * 
     */
    public ComputeForce createComputeForce() {
        return new ComputeForce();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComputeForceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tsdw.dmi/", name = "computeForceResponse")
    public JAXBElement<ComputeForceResponse> createComputeForceResponse(ComputeForceResponse value) {
        return new JAXBElement<ComputeForceResponse>(_ComputeForceResponse_QNAME, ComputeForceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComputeForce }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tsdw.dmi/", name = "computeForce")
    public JAXBElement<ComputeForce> createComputeForce(ComputeForce value) {
        return new JAXBElement<ComputeForce>(_ComputeForce_QNAME, ComputeForce.class, null, value);
    }

}

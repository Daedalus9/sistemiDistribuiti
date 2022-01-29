
package dmi.tsdw;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per computeForce complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="computeForce">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="f" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="m" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "computeForce", propOrder = {
    "f",
    "m",
    "a"
})
public class ComputeForce {

    protected double f;
    protected double m;
    protected double a;

    /**
     * Recupera il valore della proprietà f.
     * 
     */
    public double getF() {
        return f;
    }

    /**
     * Imposta il valore della proprietà f.
     * 
     */
    public void setF(double value) {
        this.f = value;
    }

    /**
     * Recupera il valore della proprietà m.
     * 
     */
    public double getM() {
        return m;
    }

    /**
     * Imposta il valore della proprietà m.
     * 
     */
    public void setM(double value) {
        this.m = value;
    }

    /**
     * Recupera il valore della proprietà a.
     * 
     */
    public double getA() {
        return a;
    }

    /**
     * Imposta il valore della proprietà a.
     * 
     */
    public void setA(double value) {
        this.a = value;
    }

}

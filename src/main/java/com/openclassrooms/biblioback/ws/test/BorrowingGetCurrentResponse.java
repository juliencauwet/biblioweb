
package com.openclassrooms.biblioback.ws.test;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="borrowingGetCurrent" type="{http://test.ws.biblioback.openclassrooms.com}borrowing" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "borrowingGetCurrent"
})
@XmlRootElement(name = "borrowingGetCurrentResponse")
public class BorrowingGetCurrentResponse {

    protected List<Borrowing> borrowingGetCurrent;

    /**
     * Gets the value of the borrowingGetCurrent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the borrowingGetCurrent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBorrowingGetCurrent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Borrowing }
     * 
     * 
     */
    public List<Borrowing> getBorrowingGetCurrent() {
        if (borrowingGetCurrent == null) {
            borrowingGetCurrent = new ArrayList<Borrowing>();
        }
        return this.borrowingGetCurrent;
    }

}

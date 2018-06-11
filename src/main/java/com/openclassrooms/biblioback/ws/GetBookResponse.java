
package com.openclassrooms.biblioback.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="bookEntity" type="{http://ws.biblioback.openclassrooms.com}bookEntity"/>
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
    "bookEntity"
})
@XmlRootElement(name = "getBookResponse")
public class GetBookResponse {

    @XmlElement(required = true)
    protected BookEntity bookEntity;

    /**
     * Obtient la valeur de la propriété bookEntity.
     * 
     * @return
     *     possible object is
     *     {@link BookEntity }
     *     
     */
    public BookEntity getBookEntity() {
        return bookEntity;
    }

    /**
     * Définit la valeur de la propriété bookEntity.
     * 
     * @param value
     *     allowed object is
     *     {@link BookEntity }
     *     
     */
    public void setBookEntity(BookEntity value) {
        this.bookEntity = value;
    }

}

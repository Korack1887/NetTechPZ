
package com.company.entityJAXB;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for category complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="category">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://net-tech/pz}id"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="price" type="{http://net-tech/pz}price"/>
 *         &lt;element name="animators" type="{http://net-tech/pz}animator" maxOccurs="5"/>
 *         &lt;element name="costumes" type="{http://net-tech/pz}costume" maxOccurs="8"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "category", namespace = "http://net-tech/pz", propOrder = {
    "id",
    "name",
    "price",
    "animators",
    "costumes"
})
public class Category {

    @XmlElement(namespace = "http://net-tech/pz")
    protected int id;
    @XmlElement(namespace = "http://net-tech/pz", required = true)
    protected String name;
    @XmlElement(namespace = "http://net-tech/pz", required = true)
    protected BigDecimal price;
    @XmlElement(namespace = "http://net-tech/pz", required = true)
    protected List<Animator> animators;
    @XmlElement(namespace = "http://net-tech/pz", required = true, nillable = true)
    protected List<Costume> costumes;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the animators property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the animators property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnimators().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Animator }
     * 
     * 
     */
    public List<Animator> getAnimators() {
        if (animators == null) {
            animators = new ArrayList<Animator>();
        }
        return this.animators;
    }
    public void addAnimator(Animator animator){
        getAnimators().add(animator);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", animators=" + animators +
                ", costumes=" + costumes +
                '}';
    }

    /**
     * Gets the value of the costumes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the costumes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCostumes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Costume }
     * 
     * 
     */
    public List<Costume> getCostumes() {
        if (costumes == null) {
            costumes = new ArrayList<Costume>();
        }
        return this.costumes;
    }
    public void addCostume(Costume costume){
        getCostumes().add(costume);
    }
}

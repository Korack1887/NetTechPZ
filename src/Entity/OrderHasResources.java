
package Entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orderHasResources complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderHasResources">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="animator" type="{}animator" minOccurs="0"/>
 *         &lt;element name="order" type="{}order" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "ordersList")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderHasResources", propOrder = {
    "animator",
    "order",
    "price"
})
public class OrderHasResources {

    protected Animator animator;
    protected Order order;
    protected int price;

    /**
     * Gets the value of the animator property.
     * 
     * @return
     *     possible object is
     *     {@link Animator }
     *     
     */
    public Animator getAnimator() {
        return animator;
    }

    /**
     * Sets the value of the animator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Animator }
     *     
     */
    public void setAnimator(Animator value) {
        this.animator = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link Order }
     *     
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link Order }
     *     
     */
    public void setOrder(Order value) {
        this.order = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */

    public void setPrice(int value) {
        this.price = value;
    }

    @Override
    public String toString() {
        return "OrderHasResources{" +
                "animator=" + animator +
                ", order=" + order +
                ", price=" + price +
                '}';
    }
}

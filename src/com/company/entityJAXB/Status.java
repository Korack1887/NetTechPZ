
package com.company.entityJAXB;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for status.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="status">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NEW"/>
 *     &lt;enumeration value="IN_PROGRESS"/>
 *     &lt;enumeration value="DONE"/>
 *     &lt;enumeration value="REJECTED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "status", namespace = "http://net-tech/pz")
@XmlEnum
public enum Status {

    NEW,
    IN_PROGRESS,
    DONE,
    REJECTED;

    public String value() {
        return name();
    }

    public static Status fromValue(String v) {
        return valueOf(v);
    }

}

@XmlSchema(
        namespace = "http://net-tech/pz",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix="ntpz", namespaceURI="http://net-tech/pz")
        }
)
package com.company.entityJAXB;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
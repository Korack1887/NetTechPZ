package com.company.parsers.unmarshall;

import com.company.entityJAXB.Orders;
import org.xml.sax.SAXException;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXParser {
    public static Orders getOrdersFromXML(String filename) {

        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Orders.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (Orders) jaxbUnmarshaller.unmarshal(new File("src/com/company/XMLs/orders.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.company.parsers.marshall;

import com.company.entityJAXB.Orders;
import com.company.parsers.unmarshall.JAXParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;

public class JAXBMarshaller {
    public static void marshall(String fileName){
        try {
        JAXBContext context = JAXBContext.newInstance(Orders.class);
        Marshaller mar= null;
        mar = context.createMarshaller();
        try {
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (PropertyException e) {
            e.printStackTrace();
        }
        mar.marshal(JAXParser.getOrdersFromXML(fileName), new File("./testJAXBxml.xml"));
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

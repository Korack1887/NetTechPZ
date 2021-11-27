package com.company;

import com.company.entityJAXB.Orders;
import com.company.parsers.marshall.DOMMarshaller;
import com.company.parsers.marshall.JAXBMarshaller;
import com.company.parsers.unmarshall.CustomSAXParser;
import com.company.parsers.unmarshall.DOMParser;
import com.company.parsers.unmarshall.JAXParser;

public class Main {
    private static final String FILENAME = "src/com/company/XMLs/orders.xml";
    public static void main(String[] args) {
        Orders ordersDOM = DOMParser.getOrdersFromXml(FILENAME);
        Orders ordersJAXB = JAXParser.getOrdersFromXML(FILENAME);
        Orders ordersSAX = CustomSAXParser.getOrdersFromXML(FILENAME);
        //System.out.println(ordersDOM);
        JAXBMarshaller.marshall(FILENAME);
        DOMMarshaller.marshall(DOMParser.getOrdersFromXml(FILENAME));
    }
}

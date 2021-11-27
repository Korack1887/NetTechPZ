package com.company;

import com.company.entityJAXB.Orders;
import com.company.parsers.unmarshall.DOMParser;

public class Main {
    private static final String FILENAME = "src/com/company/XMLs/orders.xml";
    public static void main(String[] args) {
        Orders orders = DOMParser.getOrdersFromXml(FILENAME);
        System.out.println(orders);
    }
}

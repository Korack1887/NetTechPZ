package Parsers;

import Entity.OrderHasResources;
import Entity.Orders;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JAXBParser {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(OrderHasResources.class);
        OrderHasResources order = (OrderHasResources) context.createUnmarshaller().unmarshal(new FileReader("src/com/company/XMLs/Orders.xml"));
        System.out.println(order);
    }
}

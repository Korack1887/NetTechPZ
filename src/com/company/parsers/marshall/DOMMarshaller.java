package com.company.parsers.marshall;

import com.company.entityJAXB.Animator;
import com.company.entityJAXB.Costume;
import com.company.entityJAXB.Order;
import com.company.entityJAXB.Orders;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMMarshaller {
    public static void marshall(Orders ordersList){
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document document = documentBuilder.newDocument();


        // Orders element
        Element orders = document.createElementNS("http://net-tech/pz","ntpz:orders");
        document.appendChild(orders);

        // Order element
        for (Order orderItem: ordersList.getOrders()) {
            Element order = document.createElement("ntpz:order");
            orders.appendChild(order);
            order.appendChild(document.createElement("ntpz:id")).setTextContent(String.valueOf(orderItem.getId()));
            order.appendChild(document.createElement("ntpz:status")).setTextContent(orderItem.getStatus().toString());
        // Details element
            Element details = document.createElement("ntpz:details");
            order.appendChild(details);
            details.appendChild(document.createElement("ntpz:address")).setTextContent(orderItem.getDetails().getAddress());
        // User element
            Element user = document.createElement("ntpz:user");
            details.appendChild(user);
            user.appendChild(document.createElement("ntpz:id")).setTextContent(String.valueOf(orderItem.getDetails().getUser().getId()));
            user.appendChild(document.createElement("ntpz:name")).setTextContent(orderItem.getDetails().getUser().getName());
            user.appendChild(document.createElement("ntpz:password")).setTextContent(orderItem.getDetails().getUser().getPassword());
            user.appendChild(document.createElement("ntpz:email")).setTextContent(orderItem.getDetails().getUser().getEmail());
            user.appendChild(document.createElement("ntpz:phone")).setTextContent(orderItem.getDetails().getUser().getPhone());
            user.appendChild(document.createElement("ntpz:role")).setTextContent(orderItem.getDetails().getUser().getRole().value());
            details.appendChild(document.createElement("ntpz:date")).setTextContent(orderItem.getDetails().getDate().toXMLFormat());
        // Category element
            Element category = document.createElement("ntpz:category");
            order.appendChild(category);
            category.appendChild(document.createElement("ntpz:id")).setTextContent(String.valueOf(orderItem.getCategory().getId()));
            category.appendChild(document.createElement("ntpz:name")).setTextContent(orderItem.getCategory().getName());
            category.appendChild(document.createElement("ntpz:price")).setTextContent(String.valueOf(orderItem.getCategory().getPrice()));
        // Animator elemants
            for (Animator animatorItem : orderItem.getCategory().getAnimators()) {
                Element animator = document.createElement("ntpz:animators");
                animator.appendChild(document.createElement("ntpz:id")).setTextContent(String.valueOf(animatorItem.getId()));
                animator.appendChild(document.createElement("ntpz:name")).setTextContent(animatorItem.getName());
                category.appendChild(animator);
            }
        // Costume elements
            for (Costume costumeItem : orderItem.getCategory().getCostumes()) {
                Element costume = document.createElement("ntpz:costumes");
                costume.appendChild(document.createElement("ntpz:id")).setTextContent(String.valueOf(costumeItem.getId()));
                costume.appendChild(document.createElement("ntpz:name")).setTextContent(costumeItem.getName());
                costume.appendChild(document.createElement("ntpz:description")).setTextContent(costumeItem.getDescription());
                category.appendChild(costume);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = null;
            try {
                transformer = transformerFactory.newTransformer();
            } catch (TransformerConfigurationException e) {
                e.printStackTrace();
            }
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("domXMLtest.xml"));

            try {
                transformer.transform(domSource, streamResult);
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        }
    }
}

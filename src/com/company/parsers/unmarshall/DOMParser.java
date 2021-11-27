package com.company.parsers.unmarshall;

import com.company.entityJAXB.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class DOMParser {

    public static Orders getOrdersFromXml(String filename) {
        Orders orders = new Orders();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(filename));

            doc.getDocumentElement().normalize();

            NodeList orderListElement = doc.getElementsByTagName("ntpz:order");

            for (int temp = 0; temp < orderListElement.getLength(); temp++) {

                Element orderElement = (Element) orderListElement.item(temp);

                if (orderElement.getNodeType() == Node.ELEMENT_NODE) {
                    orders.addOrder(getOrderFromXML(orderElement));
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return orders;
    }

    private static String getValueFromElement(Element element, String node) {
        return element.getElementsByTagName(node).item(0).getTextContent();
    }

    private static Order getOrderFromXML(Element orderElement) {
        Order order = new Order();
        order.setId(Integer.parseInt(getValueFromElement(orderElement, "ntpz:id")));
        order.setStatus(Status.valueOf(getValueFromElement(orderElement, "ntpz:status")));
        order.setDetails(getDetailsFromXML((Element) orderElement.getElementsByTagName("ntpz:details").item(0)));
        order.setCategory(getCategoryFromXML((Element) orderElement.getElementsByTagName("ntpz:category").item(0)));
        return order;
    }

    private static Details getDetailsFromXML(Element detailsElement) {
        Details details = new Details();
        details.setAddress(getValueFromElement(detailsElement, "ntpz:address"));
        try {
            details.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(getValueFromElement(detailsElement, "ntpz:date")));
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        details.setUser(getUserFromXML((Element) detailsElement.getElementsByTagName("ntpz:user").item(0)));
        return details;
    }

    private static User getUserFromXML(Element userElement) {
        User user = new User();
        user.setId(Integer.parseInt(getValueFromElement(userElement, "ntpz:id")));
        user.setName(getValueFromElement(userElement, "ntpz:name"));
        user.setEmail(getValueFromElement(userElement, "ntpz:email"));
        user.setPassword(getValueFromElement(userElement, "ntpz:password"));
        user.setPhone(getValueFromElement(userElement, "ntpz:phone"));
        user.setRole(Role.valueOf(getValueFromElement(userElement, "ntpz:role")));
        return user;
    }

    private static Category getCategoryFromXML(Element categoryElement) {
        Category category = new Category();
        category.setId(Integer.parseInt(getValueFromElement(categoryElement, "ntpz:id")));
        category.setName(getValueFromElement(categoryElement, "ntpz:name"));
        category.setPrice(BigDecimal.valueOf(Double.parseDouble(getValueFromElement(categoryElement, "ntpz:price"))));
        NodeList animatorNodeList = categoryElement.getElementsByTagName("ntpz:animators");
        NodeList costumeNodeList = categoryElement.getElementsByTagName("ntpz:costumes");
        for (int animatorIndex = 0; animatorIndex < animatorNodeList.getLength(); animatorIndex++) {
            category.addAnimator(getAnimatorFromXML((Element) animatorNodeList.item(animatorIndex)));
        }
        for (int costumeIndex = 0; costumeIndex < costumeNodeList.getLength(); costumeIndex++) {
            category.addCostume(getCostumeFromXML((Element) costumeNodeList.item(costumeIndex)));
        }
        return category;
    }

    private static Animator getAnimatorFromXML(Element animatorElement) {
        Animator animator = new Animator();
        animator.setId(Integer.parseInt(getValueFromElement(animatorElement, "ntpz:id")));
        animator.setName(getValueFromElement(animatorElement, "ntpz:name"));
        return animator;
    }

    private static Costume getCostumeFromXML(Element costumeElement) {
        Costume costume = new Costume();
        costume.setId(Integer.parseInt(getValueFromElement(costumeElement, "ntpz:id")));
        costume.setDescription(getValueFromElement(costumeElement, "ntpz:description"));
        costume.setName(getValueFromElement(costumeElement, "ntpz:name"));
        return costume;
    }
}

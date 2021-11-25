package Parsers;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Entity.*;

public class DOMParser {

    private static final String FILENAME = "src/com/company/XMLs/Orders.xml";

    public static void main(String[] args) {

        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        ArrayList<OrderHasResources> ordersList = new ArrayList<>();
        try {

            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);


            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(FILENAME));

            doc.getDocumentElement().normalize();

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");


            NodeList list = doc.getElementsByTagName("orders");

            for (int temp = 0; temp < list.getLength(); temp++) {

                Node order = list.item(temp);
                OrderHasResources newOrder = new OrderHasResources();
                if (order.getNodeType() == Node.ELEMENT_NODE) {
                    for (int orderIndex=0;orderIndex<order.getChildNodes().getLength();orderIndex++){
                        switch (order.getChildNodes().item(orderIndex).getNodeName()){
                            case "animator":
                                Node animatorNode = order.getChildNodes().item(orderIndex);
                                newOrder.setAnimator(createAnimatorFromChildNodes(animatorNode));
                                break;
                            case "order":
                                Node orderNode = order.getChildNodes().item(orderIndex);
                                newOrder.setOrder(createOrderFromChildNodes(orderNode));
                                break;
                            case "price":
                                //newOrder.setPrice(Integer.parseInt(order.getChildNodes().item(orderIndex).getTextContent()));
                        }
                    }
                }
                ordersList.add(newOrder);
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(ordersList);
    }
    private static Animator createAnimatorFromChildNodes(Node animatorNode){
        Animator newAnimator = new Animator();
        NodeList animatorElements = animatorNode.getChildNodes();
        newAnimator.setId(Integer.parseInt(animatorElements.item(3).getTextContent()));
        newAnimator.setPrice(Integer.parseInt(animatorElements.item(7).getTextContent()));
        newAnimator.setName(animatorElements.item(5).getTextContent());
        newAnimator.setCostume(createCostumeFromChildNodes(animatorElements.item(1)));
        return newAnimator;
    }
    private static Costume createCostumeFromChildNodes(Node costumeElements){
        Costume costume = new Costume();
        costume.setId(Integer.parseInt(costumeElements.getChildNodes().item(1).getTextContent()));
        costume.setName(costumeElements.getChildNodes().item(3).getTextContent());
        costume.setDescription(costumeElements.getChildNodes().item(5).getTextContent());
        return costume;
    }
    private static Order createOrderFromChildNodes(Node orderNode){
        Order order = new Order();
        NodeList orderElements = orderNode.getChildNodes();
        order.setId(Integer.parseInt(orderElements.item(1).getTextContent()));
        order.setRealisation(createRealizationFromChildNodes(orderElements.item(3)));
        order.setUser(createUserFromChildNodes(orderElements.item(5)));
        return order;
    }
    private static Realisation createRealizationFromChildNodes(Node realisationElements){
        Realisation realisation = new Realisation();
        realisation.setAddress(realisationElements.getChildNodes().item(1).getTextContent());
        realisation.setContactMail(realisationElements.getChildNodes().item(3).getTextContent());
        realisation.setContactName(realisationElements.getChildNodes().item(5).getTextContent());
        realisation.setContactPhone(Integer.parseInt(realisationElements.getChildNodes().item(7).getTextContent()));
        realisation.setId(Integer.parseInt(realisationElements.getChildNodes().item(9).getTextContent()));
        return realisation;
    }
    private static User createUserFromChildNodes(Node userElements){
        User user = new User();
        user.setId(Integer.parseInt(userElements.getChildNodes().item(1).getTextContent()));
        user.setLogin(userElements.getChildNodes().item(3).getTextContent());
        user.setName(userElements.getChildNodes().item(5).getTextContent());
        user.setPassword(userElements.getChildNodes().item(7).getTextContent());
        user.setRole(Role.valueOf(userElements.getChildNodes().item(9).getTextContent().trim()));
        return user;
    }
}

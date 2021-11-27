package com.company.parsers.unmarshall;

import com.company.entityJAXB.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomSAXParser {
    public static Orders getOrdersFromXML(String fileName){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = null;
        try {
            saxParser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        CustomSAXParser.CustomXMLhandler customXMLhandler = new CustomSAXParser.CustomXMLhandler();
        try {
            saxParser.parse(fileName, customXMLhandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customXMLhandler.orders;
    }
    private static class CustomXMLhandler extends DefaultHandler{
        private StringBuilder elementValue;
        private Orders orders;
        private Animator animator;
        private Costume costume;
        private Details details;
        private Order order;
        private User user;
        private Category category;
        String currentElement;

        @Override
        public void startDocument() throws SAXException {
            orders = new Orders();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            switch (qName){
                case "ntpz:order":
                    order = new Order();
                    currentElement = qName;
                    break;
                case "ntpz:animators":
                    animator = new Animator();
                    currentElement = qName;
                    break;
                case "ntpz:costumes":
                    costume = new Costume();
                    currentElement = qName;
                    break;
                case "ntpz:user":
                    user = new User();
                    currentElement = qName;
                    break;
                case "ntpz:category":
                    category = new Category();
                    currentElement = qName;
                    break;
                case "ntpz:details":
                    details = new Details();
                    currentElement = qName;
                    break;
                default:
                    elementValue = new StringBuilder();
                    break;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            switch (qName){
                case "ntpz:id":
                    switch (currentElement){
                        case "ntpz:order":
                            order.setId(Integer.parseInt(elementValue.toString()));
                            break;
                        case "ntpz:user":
                            user.setId(Integer.parseInt(elementValue.toString()));
                            break;
                        case "ntpz:category":
                            category.setId(Integer.parseInt(elementValue.toString()));
                            break;
                        case "ntpz:animators":
                            animator.setId(Integer.parseInt(elementValue.toString()));
                            break;
                        case "ntpz:costumes":
                            costume.setId(Integer.parseInt(elementValue.toString()));
                            break;
                    }
                    break;
                case "ntpz:status":
                    order.setStatus(Status.valueOf(elementValue.toString()));
                    break;
                case "ntpz:address":
                    details.setAddress(elementValue.toString());
                    break;
                case "ntpz:name":
                    switch (currentElement){
                        case "ntpz:user":
                            user.setName(elementValue.toString());
                            break;
                        case "ntpz:category":
                            category.setName(elementValue.toString());
                            break;
                        case "ntpz:animators":
                            animator.setName(elementValue.toString());
                            break;
                        case "ntpz:costumes":
                            costume.setName(elementValue.toString());
                            break;
                    }
                    break;
                case "ntpz:password":
                    user.setPassword(elementValue.toString());
                    break;
                case "ntpz:email":
                    user.setEmail(elementValue.toString());
                    break;
                case "ntpz:phone":
                    user.setPhone(elementValue.toString());
                    break;
                case "ntpz:role":
                    user.setRole(Role.valueOf(elementValue.toString()));
                    break;
                case "ntpz:date":
                    try {
                        details.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(elementValue.toString()));
                    } catch (DatatypeConfigurationException e) {
                        e.printStackTrace();
                    }
                    break;
                case "ntpz:price":
                    category.setPrice(BigDecimal.valueOf(Double.parseDouble(elementValue.toString())));
                    break;
                case "ntpz:description":
                    costume.setDescription(elementValue.toString());
                    break;
                case "ntpz:animators":
                    category.addAnimator(animator);
                    break;
                case "ntpz:costumes":
                    category.addCostume(costume);
                    break;
                case "ntpz:user":
                    details.setUser(user);
                    break;
                case "ntpz:details":
                    order.setDetails(details);
                    break;
                case "ntpz:category":
                    order.setCategory(category);
                    break;
                case "ntpz:order":
                    orders.addOrder(order);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (elementValue == null) {
                elementValue = new StringBuilder();
            } else {
                elementValue.append(ch, start, length);
            }
        }
    }
}

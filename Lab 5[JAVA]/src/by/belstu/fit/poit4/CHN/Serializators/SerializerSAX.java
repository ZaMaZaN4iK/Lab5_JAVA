package by.belstu.fit.poit4.CHN.Serializators;


import by.belstu.fit.poit4.CHN.FACULTY.FormStuding_ENUM;
import by.belstu.fit.poit4.CHN.FACULTY.Student;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class SerializerSAX extends DefaultHandler
{
    Student student = new Student();
    String thisElement = "";

    @Override
    public void startDocument() throws SAXException{}
    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException
    {
        thisElement = qName;

    }
    public Student getResult(){return student;}

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        if (thisElement.equals("Age"))
            student.setAge(new Byte(new String(ch, start, length)));
        if (thisElement.equals("NameStudent"))
            student.setNameStudent(new String(new String(ch, start, length)));
        if (thisElement.equals("internally"))
            student.setFormStuding(FormStuding_ENUM.internally);
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException{thisElement = "";}
    @Override
    public void endDocument(){}
}
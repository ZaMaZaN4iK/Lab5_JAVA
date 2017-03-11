package by.belstu.fit.poit4.CHN.Serializators;

import by.belstu.fit.poit4.CHN.FACULTY.FormStuding_ENUM;
import by.belstu.fit.poit4.CHN.FACULTY.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class SerializerDOM
{
    public Student student = new Student();
    public void startParser(String filepath) throws Exception
    {
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try
        {
            String buffer;
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("Thread");
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                buffer = getLanguage(nodeList.item(i),"");

            }
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }

    public Student getLanguage(Node node)
    {
        if (node.getNodeType() == Node.ELEMENT_NODE)
        {
            Element element = (Element) node;
            student.setAge(Byte.parseByte(getTagValue("Age", element)));
            student.setNameStudent(new String(getTagValue("NameStudent", element)));
            String a =(new String(getTagValue("FormStudint", element)));
            if (a=="internally")
                student.setFormStuding(FormStuding_ENUM.internally);
            else
                student.setFormStuding(FormStuding_ENUM.inabsentia);

        }
        return student;
    }
    public static String getLanguage(Node node, String aa)
    {
        String str = new String();
        if (node.getNodeType() == Node.ELEMENT_NODE)
        {
            Element element = (Element) node;
            str += getTagValue("name", element);
        }
        return str;
    }
    // получаем значение элемента по указанному тегу
    public static String getTagValue(String tag, Element element)
    {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}

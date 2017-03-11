package by.belstu.fit.poit4.CHN.Serializators;
import by.belstu.fit.poit4.CHN.FACULTY.FormStuding_ENUM;
import by.belstu.fit.poit4.CHN.FACULTY.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
public class CardDOMParser
{
    private Set<Student> students;
    private DocumentBuilder docBuilder;
    public CardDOMParser() {
        this.students = new HashSet<Student>();

        // создание DOM-анализатора
        //
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            docBuilder = factory.newDocumentBuilder();
        }
        catch (ParserConfigurationException e)
        {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public String getCards()
    {
        String buffer="";
        for (Student a: students)
        {
            buffer+=a.getNameStudent()+" "+a.getAge()+" "+a.getFormStuding();
            buffer+="\n";
        }
    return buffer;
    }

    public void buildSetCards(String fileName) throws IOException, SAXException
    {
        System.out.println("Build Set Cards");
        // parsing XML-документа и создание
        // древовидной структуры
        Document doc = docBuilder.parse(fileName);
        Element root = doc.getDocumentElement();
        System.out.println(fileName);
        // получение списка дочерних элементов <card>
        System.out.println(root.getElementsByTagName("element").getLength());
        NodeList cardsList = root.getElementsByTagName("Student");
        for (int i = 0; i < cardsList.getLength(); i++)
        {

            Element cardElement = (Element) cardsList.item(i);
            Student current = buildStudent(cardElement);
            students.add(current);
            System.out.println(current.getAge());
        }
    }
    private Student buildStudent(Element cardElement)
    {
        Student tempCard = new Student(); // заполнение объекта
        tempCard.setNameStudent(getElementTextContent(cardElement, "NameStudent"));
        tempCard.setAge(Integer.parseInt(getElementTextContent(cardElement, "Age")));
        String buffer= getElementTextContent(cardElement, "FormStuding");
        if (buffer=="internally")
            tempCard.setFormStuding(FormStuding_ENUM.internally);
        else
            tempCard.setFormStuding(FormStuding_ENUM.inabsentia);
        return tempCard;
    }
    // получение текстового содержимого тега
    private static String getElementTextContent (Element element, String elementName)
    {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

}

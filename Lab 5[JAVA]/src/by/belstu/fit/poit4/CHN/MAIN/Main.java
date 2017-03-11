package by.belstu.fit.poit4.CHN.MAIN;
import by.belstu.fit.poit4.CHN.Serializators.*;
import by.belstu.fit.poit4.CHN.Serializators.CardDOMParser;
import by.belstu.fit.poit4.CHN.Serializators.SerializerDOM;
import by.belstu.fit.poit4.CHN.Serializators.SerializerSAX;
import by.belstu.fit.poit4.CHN.Serializators.SerializerToXML;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import by.belstu.fit.poit4.CHN.THREAD.*;
import by.belstu.fit.poit4.CHN.DEKANAT.*;
import by.belstu.fit.poit4.CHN.FACULTY.*;
import java.lang.Object;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.*;
import javax.xml.XMLConstants;
import javax.xml.*;
import java.io.*;
import com.google.gson.Gson;
import org.xml.sax.SAXException;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

public  class Main
{
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
            try {
                //  Uncomment blocks one by one)
                //  Test XML with local thread    Working
/*
                by.belstu.fit.poit4.CHN.THREAD.ABS_Thread thread = new by.belstu.fit.poit4.CHN.THREAD.Thread();
                Student buffer = new Student("First", 0, FormStuding_ENUM.inabsentia);
                thread.AddStudent(buffer);
                buffer = new Student("Second", 1, FormStuding_ENUM.internally);
                thread.AddStudent(buffer);
                buffer = new Student("Third", 2, FormStuding_ENUM.inabsentia);
                thread.AddStudent(buffer);
                SerializerToXML.SerializerXML(thread, "");
                by.belstu.fit.poit4.CHN.THREAD.ABS_Thread thread2 = new by.belstu.fit.poit4.CHN.THREAD.Thread();
                thread2=SerializerToXML.DeserializerXML(thread2, "");
                SerializerToXML.SerializerXML(thread2,"2");
*/

                by.belstu.fit.poit4.CHN.THREAD.Thread thread = new by.belstu.fit.poit4.CHN.THREAD.Thread();
                thread.setName("FirstName");
                Student buffer = new Student("First",0, FormStuding_ENUM.inabsentia);
                thread.AddStudent(buffer);
                buffer = new Student("Second",1, FormStuding_ENUM.internally);
                thread.AddStudent(buffer);
                buffer = new Student("Third", 2, FormStuding_ENUM.inabsentia);
                thread.AddStudent(buffer);
                System.out.println(thread);
                System.out.println("Start working");
                thread.ShowAllInfoStudents();

/*
                // SAX
                System.out.println("\tSAX");
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser parser = factory.newSAXParser();
                SerializerSAX saxp = new SerializerSAX();
                parser.parse(new File("src/by/belstu/fit/poit4/CHN/Serializators/XML/Thread.xml"), saxp);
                Student student = saxp.getResult();
                student.WriteInfoAboutThisStudent();
*/
/*
                // DOM  NOT WORKING!) Staying on feature to work with parsers on Java for myself
                Student student2 = new Student();
                System.out.println("\tDOM");
                SerializerDOM serializerDOM = new SerializerDOM();
                serializerDOM.startParser("src/by/belstu/fit/poit4/CHN/Serializators/XML/Thread2.xml");
                student2.setNameStudent(serializerDOM.student.getNameStudent());
                student2.setAge(serializerDOM.student.getAge());
                student2.setFormStuding(serializerDOM.student.getFormStuding());
                System.out.println(student2);
                student2.WriteInfoAboutThisStudent();
*/
/*
                //  DOM from lections working
                CardDOMParser domBuilder = new CardDOMParser();
                domBuilder.buildSetCards("src/by/belstu/fit/poit4/CHN/Serializators/XML/Thread5.xml");
                System.out.println(domBuilder.getCards());
                DOMInet.DOMParser();
*/
                //

/*
                // Serialisation
                System.out.println("\tSerialization");
                FileOutputStream out = new FileOutputStream("src/by/belstu/fit/poit4/CHN/Serializators/XML/Thread3.xml");
                XMLEncoder xmlEncoder = new XMLEncoder(out);
                xmlEncoder.writeObject(thread);
                xmlEncoder.flush();
                xmlEncoder.close();


                // Deserialisation
                System.out.println("\tDeserialization");
                FileInputStream in = new FileInputStream("src/by/belstu/fit/poit4/CHN/Serializators/XML/Thread3.xml");
                XMLDecoder xmlDecoder = new XMLDecoder(in);
                by.belstu.fit.poit4.CHN.THREAD.Thread thread3 = (by.belstu.fit.poit4.CHN.THREAD.Thread) xmlDecoder.readObject();
                xmlDecoder.close();
                System.out.println(thread3);
                thread3.ShowAllInfoStudents();
*/
/*
                //  JSON from lections, Working)
                System.out.println("Json 2");
                Gson gson = new Gson();
                String jsonString2 = gson.toJson(student3);
                FileWriter out_json_stream = new FileWriter("src/by/belstu/fit/poit4/CHN/Serializators/XML/Thread5.json", true);
                out_json_stream.write(jsonString2);
                out_json_stream.close();
                Student student4 = gson.fromJson(jsonString2, Student.class);
                student4.WriteInfoAboutThisStudent();
*/
/*
                System.out.println("Start");
                TransformerFactory xstf = TransformerFactory.newInstance();
                // установка используемого XSL-преобразования
                Transformer transformer = null;
                transformer = xstf.newTransformer(new StreamSource("src/by/belstu/fit/poit4/CHN/Serializators/XML/info3.xsl"));
// установка исходного XML-документа и конечного XML-файла
                transformer.transform(new StreamSource("src/by/belstu/fit/poit4/CHN/Serializators/XML/info.xml"), new StreamResult("src/by/belstu/fit/poit4/CHN/Serializators/XML/MyHtml.html"));
                */
            }
            catch ( Exception e)
            {
                System.out.println(e.getMessage());
            }
    }
}

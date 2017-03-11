package by.belstu.fit.poit4.CHN.Serializators;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class SerializerToXML
{
    private static String StandartFile = "XMLFile.xml";
    public static void SerializerXML(by.belstu.fit.poit4.CHN.THREAD.ABS_Thread obj, String pref) throws Exception
    {
        JAXBContext context = JAXBContext.newInstance(by.belstu.fit.poit4.CHN.THREAD.ABS_Thread.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        File file = new File(pref+StandartFile);
        marshaller.marshal(obj,file);
        marshaller.marshal(obj, System.out);
    }
    public static by.belstu.fit.poit4.CHN.THREAD.ABS_Thread DeserializerXML(by.belstu.fit.poit4.CHN.THREAD.ABS_Thread obj, String pref)throws Exception
    {
        JAXBContext context = JAXBContext.newInstance(by.belstu.fit.poit4.CHN.THREAD.ABS_Thread.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        //unmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        File file = new File(pref+StandartFile);
        System.out.println("1");
        obj = (by.belstu.fit.poit4.CHN.THREAD.ABS_Thread)unmarshaller.unmarshal(file);
        return obj;
    }
}

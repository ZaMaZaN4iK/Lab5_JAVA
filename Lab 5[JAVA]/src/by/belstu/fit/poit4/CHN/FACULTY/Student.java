package by.belstu.fit.poit4.CHN.FACULTY;

import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student
{

    //private static final Logger LOG = Logger.getLogger(Student.class);
@XmlAttribute
    private int Age;
    private String NameStudent="No name student";
    private FormStuding_ENUM FormStuding= FormStuding_ENUM.inabsentia;

    public int getAge()
    {
        return Age;
    }
    public void setAge(int age)
    {
        Age = age;
    }
    public String getNameStudent()
    {
        return NameStudent;
    }
    public void setNameStudent(String nameStudent)
    {
        NameStudent = nameStudent;
    }
    public FormStuding_ENUM getFormStuding()
    {
        return FormStuding;
    }
    public void setFormStuding(FormStuding_ENUM formStuding)
    {
        FormStuding = formStuding;
    }

    public Student()
    {
        NameStudent = "";
        Age = -1;
        FormStuding = null;
    }

    public Student(String nameStudent, int age, FormStuding_ENUM formStuding)
    {
        NameStudent = nameStudent;
        Age = age;
        FormStuding = formStuding;
    }

    public void WriteInfoAboutThisStudent()
    {
        System.out.println("Name = " + this.getNameStudent());
        System.out.println("Age = " + this.getAge());
        if (this.getFormStuding() == FormStuding_ENUM.inabsentia)
            System.out.println("Form studing is inabsentia");
        else
            System.out.println("Form studing is internally");

    }
}

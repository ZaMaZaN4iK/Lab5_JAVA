package by.belstu.fit.poit4.CHN.THREAD;

import by.belstu.fit.poit4.CHN.FACULTY.Student;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
@XmlRootElement
public class ABS_Thread
{
    @XmlElement (name = "arrayStudents")
    public ArrayList<Student> ArrayStudents;
    public void AddStudent(Student student){}

}

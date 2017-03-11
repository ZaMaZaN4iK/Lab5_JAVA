package by.belstu.fit.poit4.CHN.THREAD;

import by.belstu.fit.poit4.CHN.FACULTY.Student;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Thread extends ABS_Thread
{

    public Thread()
    {
        ArrayStudents = new ArrayList<Student>();
    }
private String name;

    public ArrayList<Student> getArrayStudents()
    {
        return ArrayStudents;
    }

    public void setArrayStudents(ArrayList<Student> arrayStudents)
    {
        ArrayStudents = arrayStudents;
    }

    public void AddStudent(Student student)
    {
        this.ArrayStudents.add(student);
    }

    public void ShowAllInfoStudents()
    {
        for (Student obj : ArrayStudents)
        {
            obj.WriteInfoAboutThisStudent();
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    @Override
    public String toString()
    {
        return "Thread{" +getName()+'}';
    }
}

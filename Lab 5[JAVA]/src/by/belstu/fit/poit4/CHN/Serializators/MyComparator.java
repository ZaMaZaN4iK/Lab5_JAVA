package by.belstu.fit.poit4.CHN.Serializators;

import by.belstu.fit.poit4.CHN.FACULTY.Student;

import java.util.Comparator;

public class MyComparator implements Comparator<Student>
{
        @Override
        public int compare(Student o1, Student o2)
        {
            if (o1.getAge() > o2.getAge())
                return 1;
            else if (o1.getAge() < o2.getAge())
                return -1;
            else return 0;
        }
}

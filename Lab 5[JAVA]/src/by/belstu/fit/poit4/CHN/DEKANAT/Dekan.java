package by.belstu.fit.poit4.CHN.DEKANAT;
import by.belstu.fit.poit4.CHN.*;
import by.belstu.fit.poit4.CHN.FACULTY.Student;;
import by.belstu.fit.poit4.CHN.*;
import by.belstu.fit.poit4.CHN.FACULTY.*;

public class Dekan {

    public int GetNumberStudents(by.belstu.fit.poit4.CHN.THREAD.Thread thread) {
        return thread.getArrayStudents().size();
    }

    public static Dekan dekan_obj = null;

    protected Dekan() {
    }

    public static Dekan get_dekan() {
        if (dekan_obj == null)
            dekan_obj = new Dekan();
        return dekan_obj;
    }
    public int GetCountByAge(by.belstu.fit.poit4.CHN.THREAD.Thread a, int b) {
        int buffer_for_return = 0;
        for (Student obj : a.getArrayStudents()
                ) {
            if (obj.getAge() == b) buffer_for_return++;
        }
        return buffer_for_return;
    }

    public int GetCountByFormStudying(by.belstu.fit.poit4.CHN.THREAD.Thread a, FormStuding_ENUM b)
    {
        int buffer_for_return = 0;
        for (Student obj : a.getArrayStudents()
                ) {
            if (obj.getFormStuding() == b) buffer_for_return++;
        }
        return buffer_for_return;
    }
}

package lab4;

import java.util.Comparator;

public class TeacherDateComparator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher t1, Teacher t2){
        return t1.getBirthday().compareTo(t2.getBirthday());
    }
}

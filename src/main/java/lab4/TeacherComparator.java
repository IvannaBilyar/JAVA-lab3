package lab4;

import java.util.Comparator;

public class TeacherComparator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher t1, Teacher t2){
        if (t1.getSurname().compareTo(t2.getSurname()) == 0) {
            return t1.getName().compareTo(t2.getName());
        }
        return t1.getSurname().compareTo(t2.getSurname());
    }
}


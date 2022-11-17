package lab4;

import java.util.Comparator;

public class TeacherLanguageComparator implements Comparator<Teacher>{
        @Override
        public int compare(Teacher t1, Teacher t2){
            return t1.getLanguage().compareTo(t2.getLanguage());
        }
    }

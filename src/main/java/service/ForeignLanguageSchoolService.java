package service;

import lab4.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ForeignLanguageSchoolService {
    private ForeignLanguageSchool school;
    public ForeignLanguageSchoolService(ForeignLanguageSchool foreignLanguageSchool) {
        school = foreignLanguageSchool;

    }

    public List<Teacher> sortByNameSurname() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.addAll(school.getTeachers());
        Collections.sort(teachers);
        teachers.sort(new TeacherComparator());
        return teachers;
    }

    public List<Teacher> sortByNameSurnameStream() {
        return school.getTeachers().stream().sorted(new TeacherComparator()).collect(Collectors.toList());
    }

    public List<Teacher>sortByDateOfBirthday(){
        List<Teacher> teachers = new ArrayList<>();
        teachers.addAll(school.getTeachers());
        Collections.sort(teachers);
        teachers.sort(new TeacherDateComparator());
        return teachers;
    }

    public List<Teacher> sortByDateOfBirthdayStream() {
        return school.getTeachers().stream().sorted(new TeacherDateComparator()).collect(Collectors.toList());
    }
    public List<Teacher>sortByLanguage(){
        List<Teacher> teachers = new ArrayList<>();
        teachers.addAll(school.getTeachers());
        Collections.sort(teachers);
        teachers.sort(new TeacherLanguageComparator());
        return teachers;
    }
    public List<Teacher> sortByLanguageStream() {
        return school.getTeachers().stream().sorted(new TeacherLanguageComparator()).collect(Collectors.toList());
    }
    
     public List<Teacher> findTeacherBySurname(String teacherSurname){
        List<Teacher> teachers = new ArrayList<>();
        for(Teacher teacher: school.getTeachers()){
            if(teacher.getSurname() == teacherSurname){
                teachers.add(teacher);
            }
        }
        return teachers;
    }
    
      public List<Teacher> findTeacherBySurnameStream(String tSurname){
        return school.getTeachers().stream().filter(teacherSurname -> teacherSurname.getSurname().contains(tSurname)).collect(Collectors.toList());
    }
  

    public List<Teacher> findTeacherByLanguage(String lang){
        List<Teacher> teachers = new ArrayList<>();
        for(Teacher teacher: school.getTeachers()){
            if(teacher.getLanguage() == lang){
                teachers.add(teacher);
            }
        }
        return teachers;
    }
    
       public List<Teacher> findTeacherByLanguageStream(String tLanguage){
        return school.getTeachers().stream().filter(lang-> lang.getLanguage().contains(tLanguage)).collect(Collectors.toList());
    }
    
    

}

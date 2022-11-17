package lab4;

import service.ForeignLanguageSchoolService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Teacher t1 = new Teacher.Builder()
                .setName("Olha")
                .setSurname("Ivanko")
                .setBirthday(LocalDate.of(1994, 9, 12))
                .setDateOfEmployment(LocalDate.of(2017,12,5))
                .setLanguage("Chinese").build();
        Teacher t2 = new Teacher.Builder()
                .setName("Sergiy").setSurname("Maksymenko")
                .setBirthday(LocalDate.of(1982, 4, 23))
                .setDateOfEmployment(LocalDate.of(2012,10,16))
                .setLanguage("Italian").build();
        Teacher t3 = new Teacher.Builder()
                .setName("Maryna")
                .setSurname("Svitla")
                .setBirthday(LocalDate.of(1997, 11, 20))
                .setDateOfEmployment(LocalDate.of(1920,9,2))
                .setLanguage("Polish").build();
        Teacher t4 = new Teacher.Builder()
                .setName("Maksym")
                .setSurname("Hnatyuk")
                .setBirthday(LocalDate.of(1985, 6, 19))
                .setDateOfEmployment(LocalDate.of(2010,8,10))
                .setLanguage("Japanese").build();
        Teacher t5 = new Teacher.Builder()
                .setName("Inna")
                .setSurname("Shevchenko")
                .setBirthday(LocalDate.of(1996, 8, 18))
                .setDateOfEmployment(LocalDate.of(2018,11,25))
                .setLanguage("English").build();

        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(t1);
        teachers.add(t2);
        teachers.add(t3);
        teachers.add(t4);
        teachers.add(t5);

//        System.out.println(teachers);

        ForeignLanguageSchool s1 = new ForeignLanguageSchool.Builder()
                .setTeachersList(teachers)
                .setCapacity(50)
                .setAddress("Melnikova Ul., bld. 47").build();

        ForeignLanguageSchoolService service = new ForeignLanguageSchoolService(s1);

        System.out.println("Teachers sorted by surname and name:");
        System.out.println(service.sortByNameSurname());

        System.out.println("Teachers sorted by surname and name (Stream):");
        System.out.println(service.sortByNameSurnameStream());



        System.out.println("\nTeachers sorted by date of birthday: \\n");
        System.out.println(service.sortByDateOfBirthday());

        System.out.println("\nTeachers sorted by date of birthday (Stream): \\n");
        System.out.println(service.sortByDateOfBirthdayStream());



        System.out.println("\nTeachers sorted by foreign language: \\n");
        System.out.println(service.sortByLanguage());

        System.out.println("\nTeachers sorted by foreign language (Stream): \\n");
        System.out.println(service.sortByLanguageStream());

    }
}

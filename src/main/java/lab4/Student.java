package lab3;

import java.time.LocalDate;
import java.util.Objects;

public class Student implements Comparable<Student> {
    protected String name;
    protected String surname;
    protected  LocalDate birthday;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthday(){
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(LocalDate birthday){
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Student t) {
        if (surname.compareTo(t.surname) == 0) {
            return name.compareTo(t.name);
        }
        return surname.compareTo(t.surname);
    }

    /**
     * Class "Builder" with fields: student
     * @author User
     * @version 1.0
     */
    public static class Builder {
        private Student student;

        public Builder() {
            student = new Student();
        }

        /**
         * Setter name designation
         * @param name - name of student
         * @return returns current object
         */
        public Builder setName(String name) {
            student.name = name;
            return this;
        }

        /**
         * Setter  surname designation
         * @param surname - surname of student
         * @return returns current object
         */
        public Builder setSurname(String surname) {
            student.surname = surname;
            return this;
        }

        /**
         * Setter  age designation
         * @param birthday - age of student
         * @return returns current object
         */
        public Builder setBirthday(LocalDate birthday){
            student.birthday = birthday;
            return this;
        }

        /**
         * Setter of creating an object of class "Student"
         * @return returns new object of class "Student"
         */
        public Student build() {
            return student;
        }
    }

    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Student"
     *  @return returns the string representation
     */
    @Override
    public String toString() {
        return "Student: " +
                "Name = " + name + "; " +
                "Surname = " + surname + "; " +
                "Birthday = " + birthday + ";";
    }

    /**
     * Overridden function of comparison an instance of
     * the class "Student" and an instance of the class "Object"
     * @return returns the boolean value of the comparison
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Student a = (Student) obj;
        return name.equals(a.name) && surname.equals(a.surname) && birthday == a.birthday;
    }

    /**
     * Overridden function of obtaining the hash code
     * @return returns the numeric value of the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthday);
    }
}

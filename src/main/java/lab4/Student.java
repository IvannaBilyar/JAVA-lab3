package lab4;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Student implements Comparable<Student> {

    @Pattern(regexp = "[A-Z][a-z]{1,32}", message = "Name must consists only from letter, and first letter must be UpperCase")
    protected String name;

    @Pattern(regexp = "[A-Z][a-z]{1,32}", message = "Surname must consists only from letter, and first letter must be UpperCase")
    protected String surname;
    @PastOrPresent(message = "Date must be born")
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
            validate(student);
            return student;
        }
    }

    private static void validate(Student student) throws IllegalArgumentException {

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


        Set<ConstraintViolation<Student>> check = validator.validate(student);

        StringBuilder sb = new StringBuilder();

        for(ConstraintViolation<Student> element : check){
            sb.append("Error value "+element.getInvalidValue() + " because " + element.getMessage());
            sb.append("\n");
        }

        if(sb.length() > 0){
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static void main(String args[]){
        try{
            Student st = new Student.Builder()
                    .setName("Mariya")
                    .setSurname("Didukh")
                    .setBirthday(LocalDate.of(2022, 11, 18))
                    .build();
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
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

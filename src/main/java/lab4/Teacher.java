package lab4;

import java.time.LocalDate;
import java.util.Objects;

public class Teacher extends Student {
    private String language;
    private  LocalDate dateOfEmployment;

    public String getLanguage() {
        return language;
    }
    public LocalDate getDateOfEmployment(){
        return dateOfEmployment;
    }
    public void setDateOfEmployment(LocalDate dateOfEmployment){
        this.dateOfEmployment = dateOfEmployment;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Class "Builder" with fields: teachers
     * @author User
     * @version 1.0
     */
    public static class Builder {
        private Teacher teacher;

        public Builder() {
            teacher = new Teacher();
        }

        /**
         * Setter  name designation
         * @param name - name of teacher
         * @return returns current object
         */
        public Builder setName(String name) {
            teacher.name = name;
            return this;
        }

        /**
         * Setter surname designation
         * @param surname - surname of teacher
         * @return returns current object
         */
        public Builder setSurname(String surname) {
            teacher.surname = surname;
            return this;
        }

        /**
         * Setter  age designation
         * @param birthday - age of teacher
         * @return returns current object
         */
        public Builder setBirthday(LocalDate birthday){
            teacher.birthday = birthday;
            return this;
        }

        /**
         * Setter  languages designation
         * @param lang - languages that teachers teach
         * @return returns current object
         */
        public Builder setLanguage(String lang) {
            teacher.language = lang;
            return this;
        }

        /**
         * Setter  experience  designation
         * @param exp - teaching experience
         * @return returns current object
         */
        public Builder setDateOfEmployment(LocalDate exp){
            teacher.dateOfEmployment = exp;
            return this;
        }
        /**
         * Setter of creating an object of class "Teacher"
         * @return returns new object of class "Teacher"
         */
        public Teacher build() {
            return teacher;
        }
    }

    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Teacher"
     *  @return returns the string representation
     */
    @Override
    public String toString() {
        return "Teacher: " +
                "Name = " + name + "; " +
                "Surname = " + surname + "; " +
                "Birthday = " + birthday + "; " +
                "Language = " + language + "; " +
                "DateOfEmployment = " + dateOfEmployment + ";";
    }

    /**
     * Overridden function of comparison an instance of
     * the class "Teacher" and an instance of the class "Object"
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
        Teacher a = (Teacher) obj;
        return name.equals(a.name) && surname.equals(a.surname) && birthday == a.birthday && language.equals(a.language) && dateOfEmployment == a.dateOfEmployment;
    }

    /**
     * Overridden function of obtaining the hash code
     * @return returns the numeric value of the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthday, language, dateOfEmployment);
    }
}

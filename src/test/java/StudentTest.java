import lab4.Student;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.assertEquals;

public class StudentTest {
    @Test(dataProvider = "testNameNegativeDataProvider")
    public void testNameNegative(String name, LocalDate birthday){
        Student obj = new Student.Builder().setName(name).setBirthday(birthday).build();
        assertEquals(obj.getName(),name);
    }
    @DataProvider
    public Object[][] testNameNegativeDataProvider(){
        return new Object[][] {{"mariya",LocalDate.of(2003, 12, 27)}};
    }
}

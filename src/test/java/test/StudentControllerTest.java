import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class StudentControllerTest {

    private StudentController studentController;
    private Model model;

    @Before
    public void setUp() {
        studentController = new StudentController();
        model = new BindingAwareModelMap();
    }

    @Test
    public void testListStudents() {
        String viewName = studentController.listStudents(model);
        assertEquals("list-students", viewName);
        List<Student> students = (List<Student>) model.getAttribute("students");
        assertEquals(0, students.size());
    }
}

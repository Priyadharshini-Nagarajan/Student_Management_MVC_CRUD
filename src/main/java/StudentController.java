import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private List<Student> students = new ArrayList<>();
    private int nextId = 1;

    @GetMapping("/list")
    public String listStudents(Model model) {
        model.addAttribute("students", students);
        return "list-students"; // JSP view name
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form"; // JSP view name
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        student.setId(nextId++);
        students.add(student);
        return "redirect:/students/list";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") int id, Model model) {
        Student student = findStudentById(id);
        model.addAttribute("student", student);
        return "student-form"; // JSP view name
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute("student") Student updatedStudent) {
        Student student = findStudentById(updatedStudent.getId());
        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        return "redirect:/students/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        students.removeIf(student -> student.getId() == id);
        return "redirect:/students/list";
    }

    private Student findStudentById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

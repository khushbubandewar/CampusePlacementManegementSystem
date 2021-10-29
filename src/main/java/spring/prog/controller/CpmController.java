package spring.prog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import spring.prog.entity.Student;
import spring.prog.service.StudentService;

@Controller

public class CpmController {
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
public String home(Model m)

{
		
	List<Student>student=service.getAllStudent();
	m.addAttribute("student",student);
return"index";	
}
	@GetMapping("/addstudent")
	public String addStudentForm() 
	{
		return "add_student";
		
	}
	@PostMapping("/register")
	public String studentRegister(@ModelAttribute Student e,HttpSession session)
	{
		System.out.println(e);
		service.addStudent(e);
		session.setAttribute("msg","Student Added Successfully..");
		return"redirect:/";
}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		
		Student e=service.getStudentbyID(id);
		         m.addAttribute("student",e);
	return"edit";
	}
	@PostMapping("/update")
	public String updateStudent(@ModelAttribute Student e,HttpSession session)
	{
		service.addStudent(e);
		session.setAttribute("msg","Student data updated Successfully..");
		return"redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id,HttpSession session)
	{
		service.deleteStudent(id);
		session.setAttribute("msg","Student data deleted Successfully..");
		return "redirect:/";
	}
}


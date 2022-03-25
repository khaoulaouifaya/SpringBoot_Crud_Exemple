package com.frontApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.frontApp.models.Student;
import com.frontApp.services.IstudentService;

@Controller
@RequestMapping("/students")
public class studentController{

	@Autowired
	IstudentService service ;
	
	
	@GetMapping("/all")
	public String getStudents(Model model) {
		// TODO Auto-generated method stub
		List<Student>ls=service.getStudents();
		model.addAttribute("listStudent",ls);
		return "index";
	}
	
	
	@GetMapping("retour")
	public String redirect(){
		return "redirect:/students/all";
	}
	
	
	
	@GetMapping("/addStudentPage")
	public String formStudent(Model model) {
		Student s=new Student();
		model.addAttribute("student",s);
		return "addStudent";
	}
	
	@PostMapping("/addStudent")
	public String saveStudent(@ModelAttribute("student") Student student){
		service.saveStudent(student);
		return "redirect:/students/all"; 
	}
	
	
	@GetMapping("/deleteStudent/{id}")
    public String delete(@PathVariable("id") long id, RedirectAttributes attributes){
        service.deleteStudent(id);
        attributes.addFlashAttribute("success", "The student has deleted!");
        return "redirect:/students/all";
    }
	
	
	@GetMapping("/updatePage/{idp}")
	public String updateStudent(@PathVariable("idp")long idp,Model atrb) {
		Student s=service.getOne(idp);
		atrb.addAttribute("student",s);
		return "updateStudent";
		
	}
	

	
}

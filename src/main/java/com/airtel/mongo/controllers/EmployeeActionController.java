package com.airtel.mongo.controllers;

import java.util.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.airtel.mongo.models.Employee;
import com.airtel.mongo.models.User;
import com.airtel.mongo.service.EmployeeService;

//Controller for actions taken by Admin : Add, Update and Delete an Employee Details
@Controller
public class EmployeeActionController {

	@Autowired
	EmployeeService emplService;

	// View Details of all the Employees in the organisation
	@RequestMapping(value = "/view", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Employee>> employees() {
		HttpHeaders headers = new HttpHeaders();
		List<Employee> employees = emplService.listEmployee();
		System.out.println("This is the emp obj " + employees );
		System.out.println("Obj end");
		if (employees == null) {
			System.out.println("NOT HERE ");
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		}
		System.out.println("HERE ");
		headers.add("Number Of Records Found", String.valueOf(employees.size()));
		return new ResponseEntity<List<Employee>>(employees, headers, HttpStatus.OK);

	}
	
//	 @RequestMapping(value = "/view", method = RequestMethod.GET)
//	 public ModelAndView list(HttpSession session) {
//	
//	 if (session.getAttribute("username") != null) {
//	 ModelAndView modelAndView = new ModelAndView("empList");
//	 modelAndView.addObject("employees", emplService.listEmployee());
//	 return modelAndView;
//	 } else {
//	 ModelAndView modelAndView = new ModelAndView("login");
//	 modelAndView.addObject("userAttr", new User());
//	 return modelAndView;
//	 }
//	 }
	
	 @RequestMapping(value = "/add", method = RequestMethod.POST,produces = "application/json")
	 public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
	  
	  if (employee == null) {
	   return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
	  }
	  emplService.add(employee);
	 
	  return new ResponseEntity<Employee>(employee,  HttpStatus.CREATED);
	 }

	 
	 
	// Add Details of a new Employee
//	@RequestMapping(value = "/add", method = RequestMethod.GET)
//	public ModelAndView add(HttpSession session) {
//		if (session.getAttribute("username") != null) {
//			ModelAndView modelAndView = new ModelAndView("form");
//
//			// Map a new user to emp
//			modelAndView.addObject("empDetail", new Employee());
//
//			// Go to the form page
//			return modelAndView;
//		} else {
//			ModelAndView modelAndView = new ModelAndView("login");
//			modelAndView.addObject("userAttr", new User());
//			return modelAndView;
//		}
//
//	}
//	
	 	
	 @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String employeeId, @RequestBody Employee employee) {
	  
	  Employee isExist = emplService.findEmployeeById(employeeId);
	  if (isExist == null) {   
	   return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	  } else if (employee == null) {
	   return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
	  }
	  emplService.update(employee);
	
	  return new ResponseEntity<Employee>(employee,  HttpStatus.OK);
	 }
	 
	 
//	// Update the Existing Employee Details
//	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
//	public ModelAndView update(@PathVariable("id") String id) {
//		ModelAndView modelAndView = new ModelAndView("form");
//		modelAndView.addObject("empDetail", emplService.findEmployeeById(id));
//
//		// Go to the form page
//		return modelAndView;
//	}
//
//	// Collects details from form filled by admin for an Employee
//	// And calls the add Service for a new Employee
//	// And calls the Update Service for an existing Employee
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public ModelAndView save(@ModelAttribute("empDetail") @Valid Employee empl, BindingResult result) {
//		if (result.hasErrors()) {
//			// Go to the form page
//			return new ModelAndView("form");
//		}
//		System.out.print(empl.getId());
//		System.out.println(empl.getName());
//		if (empl.getId() != null && !empl.getId().trim().equals("")) {
//			// update
//			System.out.println("Working: " + empl.getId().trim());
//			emplService.update(empl);
//		} else {
//			emplService.add(empl);
//		}
//
//		// Redirect to the updated Employee List page
//		return new ModelAndView("redirect:/view");
//	}
//
	 @RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.DELETE)
	 public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") String employeeId) {
	  Employee employee = emplService.findEmployeeById(employeeId);
	  if (employee == null) {   
	   return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	  }
	  emplService.delete(employee);
	  
	  return new ResponseEntity<Employee>(employee, HttpStatus.NO_CONTENT);
	 }
//	// Delete Details of an Employee who has left the organisation
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//	public String delete(@PathVariable("id") String id) {
//
//		Employee empl = emplService.findEmployeeById(id);
//		emplService.delete(empl);
//
//		// Redirect to the updated Employee List page
//		return "redirect:/view";
//	}
}

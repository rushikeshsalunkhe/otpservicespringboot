package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.service.OTPService;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService courseService;

	// home
	@GetMapping("/home")
	public String home() {
		return " this is home page ";
	}

	// get the courses
	@GetMapping("/courses")
	public List<Courses> getCourses() {

		return this.courseService.getCourses();
	}

	// get courses for particular id {}
	@GetMapping("/courses/{coursesid}")

	public Courses getCourse(@PathVariable String coursesid) {

		return this.courseService.getCourse(Long.parseLong(coursesid));
	}

	// post course
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses course) {

		return this.courseService.addCourse(course);
	}

	// update course
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses course) {

		return this.courseService.updateCourse(course);
	}

	// delete course
	@DeleteMapping("/courses/{coursesid}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String coursesid) {
		try {
			this.courseService.deleteCourse(Long.parseLong(coursesid));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RestController
	@RequestMapping("/otp")
	public class OTPController {

	    @Autowired
	    private OTPService otpService;

	    @PostMapping("/otp")
	    public ResponseEntity<String> generateOTP(@RequestParam String mobileNumber) {
	        String response = otpService.generateOTP(mobileNumber);
	        return ResponseEntity.ok(response);
	    }
	}


	
	
	
	

}

package com.kk22.crudemo;

import com.kk22.crudemo.DAO.AppDAO;
import com.kk22.crudemo.entity.Course;
import com.kk22.crudemo.entity.Instructor;
import com.kk22.crudemo.entity.InstructorDetail;
import com.kk22.crudemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudemoApplication.class, args);
	}
    @Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
           //createCourseAndStudents(appDAO);
			//findCoursesAndStudents(appDAO);
			//findStudentsAndCourses(appDAO);
			//addMoreCoursesForStudentd(appDAO);
			//deleteCourse(appDAO);
            deleteStudentById(appDAO);

		};
	}

	private void deleteStudentById(AppDAO appDAO) {
		int theId = 1;
		System.out.println("deleting student id: " + theId);
		appDAO.deleteStudentById(theId);
		System.out.println("done!");
	}

	/*private void deleteCourse(AppDAO appDAO) {
		int theId=10;
		System.out.println("deleting course id: " + theId);
		appDAO.deleteInstructorById();
	}*/

	private void addMoreCoursesForStudentd(AppDAO appDAO) {
		int theId = 2;
		Student tempStudent = appDAO.findStudentsAndCoursesByStudentId(theId);
		Course tempCourse1= new Course("rubik");
		Course tempCourse2=new Course("haha");
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		System.out.println("Saving student" + tempStudent);
		System.out.println("associated courses: " + tempStudent.getCourses());
		appDAO.update(tempStudent);
	}

	private void findStudentsAndCourses(AppDAO appDAO) {
		int theId = 2;
		Student tempStudent = appDAO.findStudentsAndCoursesByStudentId(theId);
		System.out.println("Loaded student: " + tempStudent);
		System.out.println("Course: " + tempStudent.getCourses());
		System.out.println("done!");
	}

	private void findCoursesAndStudents(AppDAO appDAO) {
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentByCourseId(theId);
		System.out.println("Loaded course: " + tempCourse);
		System.out.println("Students: " + tempCourse.getStudents());
		System.out.println("done!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		//create a course
		Course tempCourse = new Course("Pacman-how to score 1 million points");
		//create the students
		Student tempStudent1 = new Student("JOhn","pas","haha@gmail.com");
		Student tempStudent3 = new Student("Jn","as","a@gmail.com");
		Student tempStudent2 = new Student("hn","ps","ha@gmail.com");
		//add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		tempCourse.addStudent(tempStudent3);
		//save the course and associated students
		System.out.println("saving the course: "+tempCourse);
		System.out.println("associated students:" + tempCourse.getStudents());
		appDAO.save(tempCourse);
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1 ;
		System.out.println("Find instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated course: " + tempInstructor.getCourses());
		System.out.println("done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor temInstructor = new Instructor("kl", "ky","kkk@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("kkkkk","hhhah@gmsil.com");
		//associate the object
		temInstructor.setInstructorDetail(tempInstructorDetail);
		//create some Courses
		Course temCourse1 = new Course("information technology");
		Course temCourse2 = new Course("SSD");
		temInstructor.add(temCourse1);
		temInstructor.add(temCourse2);
		//save this instructor
		//note: this will also save the details object
		//because of CascadeType.All
		System.out.println("Saving instructor: " + temInstructor);
		System.out.println("the course: " + temInstructor.getCourses());
		appDAO.save(temInstructor);

	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructionDetailById(theId);
		// get the instructor detail object

		//print the instructor detail
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);
		// print associated instructor
		System.out.println("the associated instructor: "+tempInstructorDetail.getInstructor());
		System.out.println("Done");
	}

	private void adeleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id:" + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("finding instructor id:" + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempIn:"+tempInstructor);
		System.out.println("the associated instructorDetail only: "+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		/*
		Instructor temInstructor = new Instructor("chad", "Darby","daily@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("hppt/kkkkk","hhhah");
		+/
		 */
		Instructor temInstructor = new Instructor("l", "y","kk@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("hppt/kkkkk","hhhah");
		//associate the object
		temInstructor.setInstructorDetail(tempInstructorDetail);
		//save this instructor
		//note: this will also save the details object
		//because of CascadeType.All
		System.out.println("Saving instructor: " + temInstructor);
		appDAO.save(temInstructor);
		System.out.println("done");

	}
}

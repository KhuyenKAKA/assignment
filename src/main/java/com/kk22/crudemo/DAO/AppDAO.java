package com.kk22.crudemo.DAO;

import com.kk22.crudemo.entity.Course;
import com.kk22.crudemo.entity.Instructor;
import com.kk22.crudemo.entity.InstructorDetail;
import com.kk22.crudemo.entity.Student;

public interface AppDAO {
    void save(Instructor theInstructor);
    void save(Course theCourse);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    InstructorDetail findInstructionDetailById(int theId);
    Course findCourseAndStudentByCourseId(int theId);
    Student findStudentsAndCoursesByStudentId(int theId);
    void update(Student tempStudent);
    void deleteStudentById(int theId);

}

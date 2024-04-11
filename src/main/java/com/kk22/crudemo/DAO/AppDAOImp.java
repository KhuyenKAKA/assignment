package com.kk22.crudemo.DAO;

import com.kk22.crudemo.entity.Course;
import com.kk22.crudemo.entity.Instructor;
import com.kk22.crudemo.entity.InstructorDetail;
import com.kk22.crudemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImp implements AppDAO{
private EntityManager entityManager;
@Autowired
public AppDAOImp(EntityManager entityManager){
    this.entityManager = entityManager;
}
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        //retrive the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class,theId);
        //delete the instructor
        entityManager.remove(tempInstructor);

    }

    @Override
    public InstructorDetail findInstructionDetailById(int theId) {
        return entityManager.find(InstructorDetail.class,theId);
    }

    @Override
    public Course findCourseAndStudentByCourseId(int theId) {

        //create query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from c "
                        + "JOINT FETCH c.student"
                        + "where c.id = : data", Course.class
        );
        //execute query
        query.setParameter("data", theId);
        return query.getSingleResult();
    }

    @Override
    public Student findStudentsAndCoursesByStudentId(int theId) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s "
                        + "JOINT FETCH s.courses"
                        + "where s.id = : data", Student.class
        );
        //execute query
        query.setParameter("data", theId);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student tempStudent) {
        entityManager.merge(tempStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int theId) {
        //retrieve the student
        Student tempaStudent = entityManager.find(Student.class,theId);
        //delete the student
        entityManager.remove(tempaStudent);
    }
}

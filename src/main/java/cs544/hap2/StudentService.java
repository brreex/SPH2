package cs544.hap2;

import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class StudentService {
	private StudentDAO studentdao;

	public StudentService() {
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void addStudent(Student student){
		studentdao.create(student);
	}
	@Transactional(readOnly=true)
	public Student getStudent(long studentid) {
		Student student = studentdao.load(studentid);
		Hibernate.initialize(student.getCourselist());
		return student;
		
	}

	public void setStudentdao(StudentDAO studentdao) {
		this.studentdao = studentdao;
	}
	
	
}

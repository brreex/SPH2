package cs544.hap2;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class StudentDAO {
	private SessionFactory sessionFactory;
	
	public StudentDAO() {
	}

	@Transactional(readOnly=true)
	public Student load(long studentid) {
		return sessionFactory.getCurrentSession().get(Student.class, studentid);
	}
	
	@Transactional(propagation=Propagation.MANDATORY)
	public void create(Student student){
		sessionFactory.getCurrentSession().persist(student);
	}
	
	@Transactional(propagation=Propagation.MANDATORY)
	public void update (Student student){
		sessionFactory.getCurrentSession().merge(student);
	}
	
	@Transactional(propagation=Propagation.MANDATORY)
	public void delete(Student student){
		sessionFactory.getCurrentSession().delete(student);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}

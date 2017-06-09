package cs544.hap2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class StudentsCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String studentIdStr = request.getParameter("studentid");

		long studentid = -1;
		Student student = null;

		if (studentIdStr != null && studentIdStr.matches("\\d+")) {
			studentid = Long.parseLong(studentIdStr);
			
			ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("C:\\\\Users\\\\awm\\\\Documents\\\\workspace-sts-3.8.3.RELEASE\\\\SPH2\\\\src\\\\main\\\\webapp\\\\WEB-INF\\\\applicationContext.xml");
			
			StudentService studentService = context.getBean("studentService",StudentService.class);
			student = studentService.getStudent(studentid);
			
			context.close();
		}

		request.setAttribute("student", student);
		request.getRequestDispatcher("student.jsp").forward(request, response);

	}

}

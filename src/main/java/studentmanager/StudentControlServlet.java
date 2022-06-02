package studentmanager;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentControlServlet
 */
@WebServlet("/StudentControlServlet")
public class StudentControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentControlServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		if (command == null) {
			command = "LIST";
		}
		switch (command) {
		case "LIST":
			listStudent(request, response);
			break;
		case "ADD":
			addStudent(request, response);
			break;
		case "LOAD":
			loadStudent(request, response);
			break;
		case "UPDATE":
			updateStudent(request, response);
			break;
		case "DELETE":
			deleteStudent(request, response);
			break;
		default:
			listStudent(request, response);
		}

	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		LogicHandler.deleteStudent(studentId);
		response.sendRedirect("StudentControlServlet");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		byte age = Byte.parseByte(request.getParameter("age"));
		float gpa = Float.parseFloat(request.getParameter("gpa"));
		LogicHandler.updateStudent(studentId, firstname, lastname, gender, email, age, gpa);
		response.sendRedirect("StudentControlServlet");
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		Student student = LogicHandler.loadStudent(studentId);
		request.setAttribute("Student", student);
		request.getRequestDispatcher("updateform.jsp").forward(request, response);
		/*
		 * response.setCharacterEncoding("utf-8");
		 * request.getRequestDispatcher("updateform.jsp").include(request, response);
		 */
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		byte age = Byte.parseByte(request.getParameter("age"));
		float gpa = Float.parseFloat(request.getParameter("gpa"));
		LogicHandler.add(firstname, lastname, gender, email, age, gpa);
		response.sendRedirect("StudentControlServlet");

	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> theList = LogicHandler.getStudent();
		request.setAttribute("list_student", theList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);

	}

}

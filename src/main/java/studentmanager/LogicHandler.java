package studentmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LogicHandler {
	public static List<Student> getStudent() {
		List<Student> listStudent = new ArrayList<Student>();
		String sql = "SELECT * FROM studentmanager.student";
		Connection conn = CreateConnectDB.createConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				byte age = rs.getByte("age");
				float gpa = rs.getFloat("gpa");
				Student student = new Student(id, firstname, lastname, gender, email, age, gpa);
				listStudent.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listStudent;
	}

	public static void add(String firstname, String lastname, String gender, String email, byte age, float gpa) {
		Connection conn = CreateConnectDB.createConnection();
		String sql = "INSERT INTO student(`firstname`, `lastname`, `gender`, `email`, `age`, `gpa`)"
				+ " VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, gender);
			ps.setString(4, email);
			ps.setByte(5, age);
			ps.setFloat(6, gpa);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static Student loadStudent(int studentId) {
		Connection conn = CreateConnectDB.createConnection();
		String sql = "SELECT * FROM studentmanager.student WHERE id=?";
		Student student=null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, studentId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String firstName=rs.getString("firstname");
				String lastNamers=rs.getString("lastname");
				String gender=rs.getString("gender");
				String email=rs.getString("email");
				byte age=rs.getByte("age");
				float gpa=rs.getFloat("gpa");
				student=new Student(id, firstName, lastNamers, gender, email, age, gpa);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
		

	}

	public static void updateStudent(int id, String firstname, String lastname, String gender, String email, byte age,
			float gpa) {
		Connection conn=CreateConnectDB.createConnection();
		String sql="UPDATE student "
				+ "SET firstname = ?, lastname = ?, gender = ?,"
				+ " email = ?, age = ?, `gpa` = ? WHERE id = ?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, gender);
			ps.setString(4, email);
			ps.setByte(5, age);
			ps.setFloat(6, gpa);
			ps.setInt(7, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

	public static void deleteStudent(int studentId) {
		Connection conn=CreateConnectDB.createConnection();
		String sql="DELETE FROM student WHERE id = ?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, studentId);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

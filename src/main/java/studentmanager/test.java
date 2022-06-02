package studentmanager;

import java.util.List;

public class test {
	public static void main(String[] args) {
		List<Student> list=LogicHandler.getStudent();
		for(Student s:list) {
			System.out.println(s);
		}
		Student st=LogicHandler.loadStudent(1);
		System.out.println(st);
	}
}

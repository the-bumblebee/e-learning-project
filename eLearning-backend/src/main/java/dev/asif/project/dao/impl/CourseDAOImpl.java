package dev.asif.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.asif.project.dao.CourseDAO;
import dev.asif.project.model.Course;
import dev.asif.project.util.DBUtil;

public class CourseDAOImpl implements CourseDAO {

	Connection conn = DBUtil.getConnection();

	@Override
	public List<Course> findAll() {

		List<Course> courses = new ArrayList<Course>();

		String sql = "select * from course";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				long courseId = rs.getLong("course_id");
				String cName = rs.getString("c_name");
				String cDesp = rs.getString("c_desp");
				String cFees = rs.getString("c_fees");
				String cResource = rs.getString("c_resource");

				Course course = new Course(courseId, cName, cDesp, cFees, cResource);

				courses.add(course);
			}
			return courses;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addCourse(Course course) {

		String sql = "insert into course values (?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, course.getCourseId());
			ps.setString(2, course.getcName());
			ps.setString(3, course.getcDesp());
			ps.setString(4, course.getcFees());
			ps.setString(5, course.getcResource());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Course getCourseById(Long courseId) {

		String sql = "select * from course where course_id = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setLong(1, courseId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String cName = rs.getString("c_name");
				String cDesp = rs.getString("c_desp");
				String cFees = rs.getString("c_fees");
				String cResource = rs.getString("c_resource");

				Course course = new Course(courseId, cName, cDesp, cFees, cResource);

				return course;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean deleteCourse(Long courseId) {

		String sql = "delete from course where course_id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, courseId);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateCourse(Course course) {

		String sql = "update course set c_name=?, c_desp=?, c_fees=?, c_resource=? where course_id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, course.getcName());
			ps.setString(2, course.getcDesp());
			ps.setString(3, course.getcFees());
			ps.setString(4, course.getcResource());
			ps.setLong(5, course.getCourseId());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
		
	}

}

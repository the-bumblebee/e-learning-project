package dev.asif.project.model;

public class Course {
	
	private Long courseId;
	private String cName;
	private String cDesp;
	private String cFees;
	private String cResource;
	
	public Course() {
		super();
	}

	public Course(Long courseId, String cName, String cDesp, String cFees, String cResource) {
		super();
		this.courseId = courseId;
		this.cName = cName;
		this.cDesp = cDesp;
		this.cFees = cFees;
		this.cResource = cResource;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcDesp() {
		return cDesp;
	}

	public void setcDesp(String cDesp) {
		this.cDesp = cDesp;
	}

	public String getcFees() {
		return cFees;
	}

	public void setcFees(String cFees) {
		this.cFees = cFees;
	}

	public String getcResource() {
		return cResource;
	}

	public void setcResource(String cResource) {
		this.cResource = cResource;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", cName=" + cName + ", cDesp=" + cDesp + ", cFees=" + cFees
				+ ", cResource=" + cResource + "]";
	}

}

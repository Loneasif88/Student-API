package com.student.api.Student.API.model;

public class Student {
		private String id;
		private String name;
		private int rollNumber;
		
		
		public Student() {
			// default constructor
		}
		
		public Student(String id, String name, int rollNumber) {
			super();
			this.id = id;
			this.name = name;
			this.rollNumber = rollNumber;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getRollNumber() {
			return rollNumber;
		}
		public void setRollNumber(int rollNumber) {
			this.rollNumber = rollNumber;
		}

		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", rollNumber=" + rollNumber + "]";
		}
		
		
}

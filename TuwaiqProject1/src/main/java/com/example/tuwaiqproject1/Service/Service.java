package com.example.tuwaiqproject1.Service;

import com.example.tuwaiqproject1.Models.Student;
import com.example.tuwaiqproject1.Models.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;


@Data
@AllArgsConstructor
@org.springframework.stereotype.Service
public class Service {

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Teacher> teachers = new ArrayList<>();


    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean updateStudent(int id, Student student) {
        for (int i = 0; i < students.size() ; i++) {
            if(students.get(i).getId() == id)
            {
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size() ; i++) {
            if(students.get(i).getId() == id)
            {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student getStudentById(int id) {
        for (int i = 0; i < students.size() ; i++) {
            if(students.get(i).getId() == id)
                return students.get(i);
        }
        return null;
    }

    public Student getStudentsByName(String name) {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getName().equals(name))
                return students.get(i);
        }
        return null;
    }

    public ArrayList<Student> getMajorStudents(String major) {
        ArrayList<Student> majorStudents = new ArrayList<>();
        for (int i = 0; i < students.size() ; i++) {
            if(students.get(i).getMajor().equals(major))
                majorStudents.add(students.get(i));
        }
        return majorStudents;
    }

    public ArrayList<Student> getAgeStudents(Integer age) {
        ArrayList<Student> ageStudents = new ArrayList<>();
        for (int i = 0; i < students.size() ; i++) {
            if(students.get(i).getAge() >= age)
                ageStudents.add(students.get(i));
        }
        return ageStudents;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public boolean updateTeacher(int id, Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if(teachers.get(i).getId() == id)
            {
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(int id) {
        for (int i = 0; i < teachers.size() ; i++) {
            if(teachers.get(i).getId() == id)
            {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public Teacher getTeacherByName(String name) {
        for (int i = 0; i < teachers.size() ; i++) {
            if(teachers.get(i).getName().equals(name))
                return teachers.get(i);
        }
        return null;
    }

    public ArrayList<Teacher> getTeachersBySalary(Integer salary) {
        ArrayList<Teacher> salaryTeachers = new ArrayList<>();
        for (int i = 0; i < teachers.size() ; i++) {
            if(teachers.get(i).getSalary() >= salary)
                salaryTeachers.add(teachers.get(i));
        }
        return salaryTeachers;
    }
}

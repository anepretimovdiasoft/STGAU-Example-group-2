package ru.example.edu.repository;

import org.springframework.stereotype.Repository;
import ru.example.edu.model.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public long save(Student st) {
        studentList.add(st);
        return st.getId();
    }

    public Student getById(long id) {
        Student findStudent = null;

        for (Student st : studentList) {
            if (st.getId() == id) {
                findStudent = st;
            }
        }
        return findStudent;
    }

    public void deleteById(long id) {
        int indexDeleteStudent = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                indexDeleteStudent = i;
            }
        }
        studentList.remove(indexDeleteStudent);
    }

}

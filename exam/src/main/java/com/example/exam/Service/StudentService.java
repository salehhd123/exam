package com.example.exam.Service;


import com.example.exam.Model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<StudentModel> studentModels = new ArrayList<>();

    public ArrayList<StudentModel> get(){
        return studentModels;
    }

    public void add(StudentModel studentModel){
        studentModels.add(studentModel);
    }

    public boolean update(Integer id, StudentModel studentModel){
        for(int i=0;i<studentModels.size();i++){
           if (studentModels.get(i).getStudentID()==id){
            studentModels.set(i,studentModel);
            return true;
           }
        }return false;
    }

    public boolean delete(Integer id){
        for(int i=0;i<studentModels.size();i++){
            if (studentModels.get(i).getStudentID()==id){
                studentModels.remove(i);
                return true;
            }
        }return false;
    }

    public StudentModel find(String name) {
        for (int i = 0; i < studentModels.size(); i++) {
            if (studentModels.get(i).getName().equalsIgnoreCase(name)) {
                return studentModels.get(i);
            }
        }return null;
    }

}

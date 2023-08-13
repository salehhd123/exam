package com.example.exam.Service;

import com.example.exam.Model.StudentModel;
import com.example.exam.Model.TeacherModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<TeacherModel> teacherModels=new ArrayList<>();

    public ArrayList<TeacherModel> get(){
        return teacherModels;
    }

    public void add(TeacherModel teacherModel){
        teacherModels.add(teacherModel);
    }

    public boolean update(Integer id, TeacherModel teacherModel){
        for(int i=0;i<teacherModels.size();i++){
            if (teacherModels.get(i).getTeacherID()==id){
                teacherModels.set(i,teacherModel);
                return true;
            }
        }return false;
    }

    public boolean delete(Integer id){
        for(int i=0;i<teacherModels.size();i++){
            if (teacherModels.get(i).getTeacherID()==id){
                teacherModels.remove(i);
                return true;
            }
        }return false;
    }

    public TeacherModel find(Integer id) {
        for (int i = 0; i < teacherModels.size(); i++) {
            if (teacherModels.get(i).getTeacherID()==id) {
                return teacherModels.get(i);
            }
        }return null;
    }

}

package com.example.exam.Controller;

import com.example.exam.ApiResponse.ApiResponse;
import com.example.exam.Model.StudentModel;
import com.example.exam.Model.TeacherModel;
import com.example.exam.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(teacherService.get());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid TeacherModel teacherModel, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.add(teacherModel);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid TeacherModel teacherModel, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (teacherService.update(id, teacherModel)){
            return ResponseEntity.status(200).body(new ApiResponse("updated"));
        }return ResponseEntity.status(400).body(new ApiResponse("wrong id"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        if (teacherService.delete(id)){
            return ResponseEntity.status(200).body(new ApiResponse("deleted"));
        }return ResponseEntity.status(400).body(new ApiResponse("wrong id"));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity find(@PathVariable Integer id){
        if (teacherService.find(id)==null){
            return ResponseEntity.status(400).body(new ApiResponse("wrong name"));
        }return ResponseEntity.status(200).body(teacherService.find(id));
    }


}

package com.example.exam.Controller;

import com.example.exam.ApiResponse.ApiResponse;
import com.example.exam.Model.StudentModel;
import com.example.exam.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(studentService.get());
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid StudentModel studentModel, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.add(studentModel);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid StudentModel studentModel, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (studentService.update(id, studentModel)){
            return ResponseEntity.status(200).body(new ApiResponse("updated"));
        }return ResponseEntity.status(400).body(new ApiResponse("wrong id "));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        if (studentService.delete(id)){
            return ResponseEntity.status(200).body(new ApiResponse("deleted"));
        }return ResponseEntity.status(400).body(new ApiResponse("wrong id"));
    }

    @GetMapping("/find/{name}")
    public ResponseEntity find(@PathVariable String name){
        if (studentService.find(name)==null){
            return ResponseEntity.status(400).body(new ApiResponse("wrong name"));
        }return ResponseEntity.status(200).body(studentService.find(name));
    }
}

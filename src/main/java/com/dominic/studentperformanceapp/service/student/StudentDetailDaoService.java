package com.dominic.studentperformanceapp.service.student;

import com.dominic.studentperformanceapp.dto.student.StudentDetails;
import com.dominic.studentperformanceapp.interfaces.Id;
import com.dominic.studentperformanceapp.model.StudentDetailsEntity;
import com.dominic.studentperformanceapp.repository.StudentDetailsRepository;
import com.dominic.studentperformanceapp.utils.CodeGeneratorUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentDetailDaoService {
    private final StudentDetailsRepository repository;
    private final ModelMapper modelMapper;

    public StudentDetails save(StudentDetails studentDetails){
        return modelMapper.map(repository.save(modelMapper.map(studentDetails, StudentDetailsEntity.class)), StudentDetails.class);
    }

    public StudentDetails createStudentDetails(StudentDetails studentDetails){
        studentDetails.setRegNo(generateRegNo());
        return save(studentDetails);
    }

    public StudentDetails updateStudentDetails(Long id, StudentDetails studentDetails){
        if(!existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No record found for studentDetails");
        studentDetails.setId(id);
        return save(studentDetails);
    }

    private boolean existsById(Long id){
        return repository.existsById(id);
    }

    public boolean existsByRegNo(String regNo){
        return repository.existsByRegNo(regNo);
    }

    private String generateRegNo(){
        Id lastestId = repository.findTopByOrderByIdDesc();
        return CodeGeneratorUtils.generateCode("REG", !ObjectUtils.isEmpty(lastestId) ? lastestId.getId() : 0);
    }
}

package com.uep.wap.dto;

import com.uep.wap.dto.StudentDTO;

import java.util.List;

public class StudentsDataDTO {

    List<StudentDTO> people;

    public List<StudentDTO> getPeople() {
        return people;
    }

    public void setPeople(List<StudentDTO> people) {
        this.people = people;
    }
}

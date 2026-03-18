package com.uep.wap.dto;

import com.uep.wap.dto.UserDTO;

import java.util.List;

public class UsersDataDTO {

    List<UserDTO> people;

    public List<UserDTO> getPeople() {
        return people;
    }

    public void setPeople(List<UserDTO> people) {
        this.people = people;
    }
}

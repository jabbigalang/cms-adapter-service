package com.chrisen.cms.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("resident")
public class Resident {

    @Id
    private String id;

    @NotBlank(message = "First name is mandatory.")
    private String firstName;

    @NotBlank(message = "Last name is mandatory.")
    private String lastName;
}

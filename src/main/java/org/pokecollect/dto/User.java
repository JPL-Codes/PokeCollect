package org.pokecollect.dto;

import lombok.Data;

import java.time.Instant;

public @Data class User {
    int UserId;
    String UserName;
    String firstName;
    String LastName;
    String email;
    Instant CreatedDate;
}

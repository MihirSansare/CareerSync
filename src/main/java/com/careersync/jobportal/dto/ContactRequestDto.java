package com.careersync.jobportal.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.careersync.jobportal.entity.Contact}
 */
public record ContactRequestDto(String email, String message, String name, String subject,
                                String userType) implements Serializable {
}
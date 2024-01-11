package com.personal.study.basicauthorizationapp.commons.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Authenticated user doesn't have access to this service")
public class ForbiddenHttpAccessException extends RuntimeException {
}

package org.msa.item.presentation.exceptionhandler;

import jakarta.servlet.http.HttpServletRequest;
import org.msa.item.common.constant.error.exception.ApiException;
import org.msa.item.presentation.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> Exception(HttpServletRequest request, Exception e) throws Exception {
		ResponseDTO.ResponseDTOBuilder responseBuilder = ResponseDTO.builder();
		responseBuilder.code("500").message(e.getMessage());
		return ResponseEntity.ok(responseBuilder.build());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		StringBuilder builder = new StringBuilder();
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			builder.append("[");
			builder.append(fieldError.getField());
			builder.append("](은)는 ");
			builder.append(fieldError.getDefaultMessage());
			builder.append(" 입력된 값: [");
			builder.append(fieldError.getRejectedValue());
			builder.append("]");
		}

		ResponseDTO.ResponseDTOBuilder responseBuilder = ResponseDTO.builder();
		responseBuilder.code("500").message(builder.toString());
		return ResponseEntity.ok(responseBuilder.build());
	}

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> handleApiExceptions(ApiException ex) {
		ResponseDTO.ResponseDTOBuilder responseBuilder = ResponseDTO.builder();
		responseBuilder.code("501").message(ex.getMessage());
		return ResponseEntity.ok(responseBuilder.build());
	}
}
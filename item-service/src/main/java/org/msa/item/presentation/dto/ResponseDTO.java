package org.msa.item.presentation.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResponseDTO {
	private String code;
	private String message;
}

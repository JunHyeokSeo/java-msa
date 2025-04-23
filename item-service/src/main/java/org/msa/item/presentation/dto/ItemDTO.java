package org.msa.item.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ItemDTO {
	@NotBlank(message = "ID는 필수 입력 값입니다.")
	@Size(max = 10, message = "ID는 크기 10이하까지 작성가능합니다.")
	private String id;

	private String name;

	private String description;

	private String itemType;

	@Positive
	private Long count;

	private String createAt;

	private String updateAt;
}

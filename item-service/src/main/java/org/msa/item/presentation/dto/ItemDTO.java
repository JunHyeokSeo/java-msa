package org.msa.item.presentation.dto;

import lombok.Data;

@Data
public class ItemDTO {
	private String id;
	private String name;
	private String description;
	private Long count;
	private String createAt;
	private String updateAt;
}

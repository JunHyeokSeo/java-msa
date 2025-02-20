package org.msa.item.domain;

import lombok.Data;

@Data
public class Item {
	private String id;
	private String name;
	private String description;
	private Long count;
	private String createAt;
	private String updateAt;
}

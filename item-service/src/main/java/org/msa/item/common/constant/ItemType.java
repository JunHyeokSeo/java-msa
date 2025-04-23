package org.msa.item.common.constant;

public enum ItemType {
	FOOD("F", "음식"),
	CLOTHES("C", "옷");

	private String code;
	private String description;

	ItemType(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public boolean hasItemCd(String code) {
		return this.code.equals(code);
	}
}

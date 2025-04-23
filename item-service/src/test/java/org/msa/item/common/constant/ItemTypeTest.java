package org.msa.item.common.constant;

import org.junit.jupiter.api.Test;

class ItemTypeTest {

	@Test
	void hasItemCd() {
		boolean f = ItemType.FOOD.hasItemCd("F");
		System.out.println(f);
	}
}
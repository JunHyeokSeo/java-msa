package org.msa.item.common.constant;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class ItemTypeTest {

	@Test
	void hasItemCd() {
		boolean f = ItemType.FOOD.hasItemCd("F");
		System.out.println(f);
	}
}
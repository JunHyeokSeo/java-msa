package org.msa.item.presentation.valid;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.msa.item.common.constant.ItemType;

import java.lang.annotation.*;
import java.util.Arrays;

@Constraint(validatedBy = ItemTypeValid.ItemTypeValidator.class)
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ItemTypeValid {
	String message() default "허용되지 않은 물품 유형입니다.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	class ItemTypeValidator implements ConstraintValidator<ItemTypeValid, String> {

		@Override
		public boolean isValid(String cd, ConstraintValidatorContext context) {
			return Arrays.stream(ItemType.values())
					       .anyMatch(i -> i.hasItemCd(cd));
		}
	}
}

package org.msa.item.presentation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.msa.item.application.ItemService;
import org.msa.item.common.constant.ItemType;
import org.msa.item.presentation.dto.ItemDTO;
import org.msa.item.presentation.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/item")
@Slf4j
@RequiredArgsConstructor
public class ItemController {
	private final ItemService itemService;

	@RequestMapping(value = "/add/{itemType}", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO> add(@Valid @RequestBody ItemDTO itemDTO, @PathVariable String itemType) {
		ResponseDTO.ResponseDTOBuilder responseBuilder = ResponseDTO.builder();

		log.debug("path.variable itemType = {}", itemType);
		boolean hasItemType = false;
		ItemType[] itemTypeList = ItemType.values();
		for (ItemType i : itemTypeList) {
			hasItemType = i.hasItemCd(itemType);
			if (hasItemType)
				break;
		}
		if (!hasItemType) {
			responseBuilder.code("500").message("invalid itemType .[" + itemType + "]");
			return ResponseEntity.ok(responseBuilder.build());
		} else {
			itemDTO.setItemType(itemDTO.getItemType());
		}

		itemService.insertItem(itemDTO);
		log.debug("request add item id = {}", itemDTO.getId());

		responseBuilder.code("200").message("success");
		return ResponseEntity.ok(responseBuilder.build());
	}
}

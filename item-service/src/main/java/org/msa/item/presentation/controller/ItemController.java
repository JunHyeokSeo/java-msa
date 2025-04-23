package org.msa.item.presentation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.msa.item.application.ItemService;
import org.msa.item.presentation.dto.ItemDTO;
import org.msa.item.presentation.dto.ResponseDTO;
import org.msa.item.presentation.valid.ItemTypeValid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/item")
@Slf4j
@RequiredArgsConstructor
@Validated
public class ItemController {
	private final ItemService itemService;

	@RequestMapping(value = "/add/{itemType}", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO> add(@Valid @RequestBody ItemDTO itemDTO, @ItemTypeValid @PathVariable String itemType) throws Exception {
		ResponseDTO.ResponseDTOBuilder responseBuilder = ResponseDTO.builder();

		itemDTO.setItemType(itemType);
		itemService.insertItem(itemDTO);
		log.debug("request add item id = {}", itemDTO.getId());

		responseBuilder.code("200").message("success");
		return ResponseEntity.ok(responseBuilder.build());
	}
}

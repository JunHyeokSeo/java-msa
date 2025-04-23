package org.msa.item.application;

import lombok.RequiredArgsConstructor;
import org.msa.item.domain.Item;
import org.msa.item.infra.persistance.ItemRepository;
import org.msa.item.presentation.dto.ItemDTO;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ItemService {
	private final ItemRepository itemRepository;

	public void insertItem(ItemDTO itemDTO) {
		SimpleDateFormat form = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = form.format(new Date());

		Item item = Item.builder()
				            .id(itemDTO.getId())
				            .name(itemDTO.getName())
				            .description(itemDTO.getDescription())
				            .itemType(itemDTO.getItemType())
				            .count(itemDTO.getCount())
				            .regDts(date)
				            .updDts(date)
				            .build();
		itemRepository.save(item);
	}
}

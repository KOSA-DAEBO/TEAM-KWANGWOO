package edu.kosa.third.dto;

import java.util.List;

public class ProductManageDto {
	private ProductDto pDto;
	private List<PIMappingDto> pimDtoList;
	private ItemDto itemDto;

	public ProductDto getpDto() {
		return pDto;
	}

	public void setpDto(ProductDto pDto) {
		this.pDto = pDto;
	}

	public List<PIMappingDto> getPimDtoList() {
		return pimDtoList;
	}

	public void setPimDtoList(List<PIMappingDto> pimDtoList) {
		this.pimDtoList = pimDtoList;
	}

	public ItemDto getItemDto() {
		return itemDto;
	}

	public void setItemDto(ItemDto itemDto) {
		this.itemDto = itemDto;
	}
}

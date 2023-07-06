package edu.kosa.third.dto;

public class ItemsDto {
	private ItemDto dto;
	private ItemClsDto cDto;

	public ItemsDto() {
	}

	public ItemsDto(ItemDto dto, ItemClsDto cDto) {
		this.dto = dto;
		this.cDto = cDto;
	}

	public ItemDto getDto() {
		return dto;
	}

	public void setDto(ItemDto dto) {
		this.dto = dto;
	}

	public ItemClsDto getcDto() {
		return cDto;
	}

	public void setcDto(ItemClsDto cDto) {
		this.cDto = cDto;
	}
}

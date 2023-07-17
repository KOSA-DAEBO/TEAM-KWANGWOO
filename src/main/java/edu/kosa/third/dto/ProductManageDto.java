package edu.kosa.third.dto;

import java.util.List;

public class ProductManageDto {
	private ProductDto pDto;
	private List<PIMappingDto> pimDtoList;
	private List<ItemsDto> itemsDtoList;

	public ProductManageDto() {
	}

	public ProductManageDto(ProductDto pDto, List<PIMappingDto> pimDtoList, List<ItemsDto> itemsDtoList) {
		this.pDto = pDto;
		this.pimDtoList = pimDtoList;
		this.itemsDtoList = itemsDtoList;
	}

	public List<ItemsDto> getItemsDtoList() {
		return itemsDtoList;
	}

	public void setItemsDtoList(List<ItemsDto> itemsDtoList) {
		this.itemsDtoList = itemsDtoList;
	}

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
}

package com.macat.dao;

import java.util.List;

import com.macat.dto.ImagesDTO;
import com.macat.dto.ProductsDTO;

public interface AdminAddProductDAO {
	
	public int insertProduct(ProductsDTO productsDTO);
	
	public int insertImage(ImagesDTO imagesDTO);
	
	public int insertImages(List<ImagesDTO> imagesDTOs);

}

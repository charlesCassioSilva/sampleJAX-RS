package com.charles.productservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.charles.productservice.dto.ImageDTO;
import com.charles.productservice.dto.mapper.ImageMapper;
import com.charles.productservice.model.Image;
import com.charles.productservice.repository.ImageRepository;
import com.charles.productservice.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	private ImageRepository imageRepository;

	@Override
	@Transactional
	public ImageDTO save(ImageDTO image) {
		Image p = imageRepository.save(ImageMapper.toEntity(image));
		return ImageMapper.toDTO(p);
	}

	@Override
	@Transactional
	public ImageDTO findById(Long id) {
		if (id == null){
			return null;
		}
		return ImageMapper.toDTO(imageRepository.findById(id));
	}

	@Override
	@Transactional
	public Boolean update(ImageDTO image) {
		return imageRepository.update(ImageMapper.toEntity(image));
	}

	@Override
	@Transactional
	public Boolean delete(ImageDTO image) {
		return imageRepository.delete(ImageMapper.toEntity(image));
	}

	@Override
	@Transactional
	public List<ImageDTO> findAll() {
		return imageRepository.findAll().stream()
				.map(o -> ImageMapper.toDTO(o)).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<ImageDTO> findByProduct(Long productId) {
		return imageRepository.findByProduct(productId).stream()
				.map(o -> ImageMapper.toDTO(o)).collect(Collectors.toList());
	}

}

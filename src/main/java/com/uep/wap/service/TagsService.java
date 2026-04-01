package com.uep.wap.service;

import com.uep.wap.dto.TagDTO;
import com.uep.wap.model.Tag;
import com.uep.wap.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagsService {

    @Autowired
    private TagRepository tagRepository;

    public void addTag(TagDTO tagDTO) {
        Tag tag = new Tag();
        tag.setId(tagDTO.getId());
        tag.setName(tagDTO.getName());
        tag.setDescription(tagDTO.getDescription());
        tagRepository.save(tag);
        System.out.println("Tag added!");
    }

    public Iterable<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}
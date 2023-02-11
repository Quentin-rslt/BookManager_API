package com.API.BookManager.controller;

import com.API.BookManager.model.BookEntity;
import com.API.BookManager.model.TagEntity;
import com.API.BookManager.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {
    @Autowired
    TagService tagService;

    /**
     * @see TagService#getTagById(Long)
     */
    @GetMapping(value = "/api/tag/{id}")
    public TagEntity getTagById(@PathVariable(value = "id") final Long id){
        return tagService.getTagById(id);
    }

    /**
     * @see TagService#getTags() 
     */
    @GetMapping(value="/api/tag/all")
    public List<TagEntity> getTags(){
        return tagService.getTags();
    }

    /**
     * @see TagService#getBooksByIdTag(Long) 
     */
    @GetMapping(value = "/api/tag/{idTag}/book/all")
    public List<BookEntity> getBooksByIdTag(@PathVariable(value = "idTag") final Long idTag){
        return tagService.getBooksByIdTag(idTag);
    }

    /**
     * @see TagService#deleteTagById(Long) 
     */
    @DeleteMapping(value = "/api/deleteTag/{id}")
    public void deleteTagById(@PathVariable(value = "id") final Long id){
        tagService.deleteTagById(id);
    }

    /**
     * @see TagService#deleteTags()
     */
    @DeleteMapping(value = "/api/deleteTag/all")
    public void deleteTags(){
        tagService.deleteTags();
    }

    /**
     * @see TagService#addTag(TagEntity) 
     */
    @PostMapping(value = "/api/addTag")
    public TagEntity addTag(@RequestBody final  TagEntity tag) {
        return tagService.addTag(tag);
    }
    
    /**
     * @see TagService#updateTag(Long, TagEntity) 
     */
    @PutMapping(value = "/api/updateTag/{idTag}")
    public TagEntity updateTag(@PathVariable(value = "idTag") final Long idTag, @RequestBody final  TagEntity newTag) {
        return tagService.updateTag(idTag, newTag);
    }
}

package com.monosun.book.springboot.web;

import com.monosun.book.springboot.service.posts.PostsService;
import com.monosun.book.springboot.web.dto.PostsResponseDto;
import com.monosun.book.springboot.web.dto.PostsSaveRequestDto;
import com.monosun.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 글을 처리하는 Controller
 */
@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    /**
     * Create a posts
     * 각 메소드 호출
     * Create --> POST
     * Read   --> GET
     * Update --> PUT
     * Delete --> DELETE
     * @param requestDto
     * @return
     */
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    /**
     * Update the posts
     * @param id
     * @param requestDto
     * @return
     */
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }

    /**
     * Read a posts
     * @param id
     * @return
     */
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    /**
     * Delete a posts
     * @param id
     * @return
     */
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

}

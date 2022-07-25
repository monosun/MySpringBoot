package com.monosun.book.springboot.web;

import com.monosun.book.springboot.config.auth.LoginUser;
import com.monosun.book.springboot.config.auth.SessionUser;
import com.monosun.book.springboot.service.posts.PostsService;
import com.monosun.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

/**
 * Controller  임
 */
@RequiredArgsConstructor  //인자로 생성자를 자동으로 생성한다. final 인 모든 인자값에 대해서 lomok에서 생성자를 만들어준다.
@Controller //Controller임을 정의
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/") // /로 GET 방식으로 요청을 들어오는 경우
    public String index(Model model, @LoginUser SessionUser user){
        //Model 에 게시글들을 모두 담아서 넘긴다.
        model.addAttribute("posts",postsService.findAllDesc());

        if(user!=null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }
}

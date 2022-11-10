package com.example.repeat_mustache.controlloer;

import com.example.repeat_mustache.domain.dto.ArticleDto;
import com.example.repeat_mustache.domain.entity.Article;
import com.example.repeat_mustache.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleRepository articleRepository;
// ArticleRepository는 interface지만 그 구현체(ArticleDao)를 SpringBoot가 넣어줍니다.
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(value = "/new")
    public String newArticleForm(){
        return "articles/new";

    }

    @GetMapping(value = "/{id}")
    public String getIdPage(@PathVariable Long id, Model model){
        Optional<Article> optArticle = articleRepository.findById(id); // null 값이 들어와도 nullPointExecption 발생 X
        if (!optArticle.isEmpty()) { // null 이 아닐때
            // Optional.get() ---> Article
            model.addAttribute("article", optArticle.get()); // view article에 값 전달.
            return "articles/show";
        } else {
            return "articles/error";
        }
    }

    @GetMapping("/list")
    public String getList(Model model){
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articles",articleList);
        return "articles/list";
    }

    @GetMapping("")
    public String main(){
        return "redirect:/articles/list";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, Model model){
        Optional<Article> optArticle = articleRepository.findById(id);
        if (!optArticle.isEmpty()) {
            // Optional.get() ---> Article
            model.addAttribute("article", optArticle.get());
            return "articles/edit";
        } else {
            model.addAttribute("message",String.format("%d가 없습니다." ,id));
            return "articles/error";
        }
    }

    @PostMapping("/{id}/update")
    public String updateArticle(@PathVariable Long id, ArticleDto form, Model model) {
        Article articleEntity = form.toEntity(id);
        Article saved = articleRepository.save(articleEntity);
        return "redirect:/articles/";
    }

    @PostMapping(value = "/posts")
    public String createArticle(ArticleDto form){
        log.info(form.toString());

        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());

        Article saved = articleRepository.save(articleEntity);
        log.info("generatedId:{}", saved.getId());
        return "redirect:/articles/" + saved.getId();
    }
}

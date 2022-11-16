package com.example.repeat_mustache.controlloer;

import com.example.repeat_mustache.domain.dto.ArticleDto;
import com.example.repeat_mustache.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/articles")
public class ArticleRestController {

    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }
//    private final  ArticleRepository articleRepository;

//    private final CommentRepository commentRepository;
//    public ArticleRestController(ArticleRepository articleRepository,ArticleService articleService, CommentRepository commentRepository) {
//        this.articleRepository = articleRepository;
//        this.articleService = articleService;
//        this.commentRepository = commentRepository;
//    }



    @GetMapping(value = "/new")
    public String newArticleForm(){
        return "articles/new";

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ArticleDto> getIdPage(@PathVariable Long id, Model model){
//        Optional<Article> optArticle = articleRepository.findById(id); // null 값이 들어와도 nullPointExecption 발생 X
//        if (!optArticle.isEmpty()) { // null 이 아닐때
//            // Optional.get() ---> Article
//            List<Comment> comments = commentRepository.findByArticleId(id);
//            model.addAttribute("article", optArticle.get()); // view article에 값 전달.
//            model.addAttribute("comments",comments);
//
//            return "articles/show";
//        } else {
//            return "articles/error";
//        }
        ArticleDto articleDto = articleService.getArticle(id);
        return ResponseEntity.ok().body(articleDto);
    }

//    @GetMapping("/list")
//    public String getList(Model model){
//        List<Article> articleList = articleRepository.findAll();
//        model.addAttribute("articles",articleList);
//        return "articles/list";
//    }
//
//    @GetMapping("")
//    public String main(){
//        return "redirect:/articles/list";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String update(@PathVariable Long id, Model model){
//        Optional<Article> optArticle = articleRepository.findById(id);
//        if (!optArticle.isEmpty()) {
//            // Optional.get() ---> Article
//            model.addAttribute("article", optArticle.get());
//            return "articles/edit";
//        } else {
//            model.addAttribute("message",String.format("%d가 없습니다." ,id));
//            return "articles/error";
//        }
//    }
//
//    @GetMapping("/{id}/delete")
//    public String delete(@PathVariable Long id){
//        articleRepository.deleteById(id);
//        return "redirect:/articles";
//    }
//
//    @PostMapping("/{id}/update")
//    public String updateArticle(@PathVariable Long id, ArticleDto form, Model model) {
//        Article articleEntity = form.toEntity(id);
//        Article saved = articleRepository.save(articleEntity);
//        return "redirect:/articles/";
//    }
//
//    @PostMapping(value = "/posts")
//    public String createArticle(ArticleDto form){
//        log.info(form.toString());
//
//        Article articleEntity = form.toEntity();
//        log.info(articleEntity.toString());
//
//        Article saved = articleRepository.save(articleEntity);
//        log.info("generatedId:{}", saved.getId());
//        return "redirect:/articles/" + saved.getId();
//    }
//
////    @GetMapping("/{id}/comments")
////    public String getComment(@PathVariable Long id,Model model){
////        Optional<Article> optArticle = articleRepository.findById(id);
////        if (!optArticle.isEmpty()) {
////            // Optional.get() ---> Article
////            model.addAttribute("article", optArticle.get());
////            return "articles/comment";
////        } else {
////            model.addAttribute("message",String.format("%d가 없습니다." ,id));
////            return "articles/error";
////        }
////    }
//
//    @PostMapping(value = "/{id}/comments")
//    public String createComment(@PathVariable Long id, CommentDto form){
//        log.info(form.toString());
//        Optional<Article> optionalArticle = articleRepository.findById(id);
//        form.setArticle(optionalArticle.get());
//        Comment commentEntity = form.toEntity();
//        log.info(commentEntity.toString());
//
//        Comment saved = commentRepository.save(commentEntity);
//        log.info("generatedId:{}",saved.getCommentId());
//        return "redirect:/articles/" + id ;
//    }
}

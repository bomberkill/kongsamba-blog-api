package com.example.kongsambablogapi.controllers;

import com.example.kongsambablogapi.models.articles.Article;
import com.example.kongsambablogapi.models.articles.ArticleInput;
import com.example.kongsambablogapi.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }
    @GetMapping("/{id}")
    public Optional<Article> getArticleById (@PathVariable String id) {
        return articleService.getArticleById(id);
    }
    @PostMapping
    public Article createArticle (@RequestBody ArticleInput articleInput) {
        return  articleService.createArticle(articleInput);
    }
    @PutMapping("/{id}")
    public Article updateArticle (@PathVariable String id,@RequestBody ArticleInput articleInput) {
        return articleService.updateArticle(id, articleInput);
    }
    @DeleteMapping("/{id}")
    public void deleteArticle (@PathVariable String id) {
        articleService.deleteArticle(id);
    }
}
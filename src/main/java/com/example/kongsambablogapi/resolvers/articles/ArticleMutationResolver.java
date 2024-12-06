package com.example.kongsambablogapi.resolvers.articles;

import com.example.kongsambablogapi.models.articles.Article;
import com.example.kongsambablogapi.models.articles.ArticleInput;
import com.example.kongsambablogapi.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ArticleMutationResolver {

    @Autowired
    private ArticleService articleService;

    @MutationMapping
    public Article createArticle (@Argument ArticleInput articleInput) {
        return articleService.createArticle(articleInput);
//        try {
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
    }

    @MutationMapping
    public Article updateArticle (@Argument String id, @Argument ArticleInput articleInput) {
        return articleService.updateArticle(id, articleInput);
//        try {
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
    }
    @MutationMapping
    public Article updateArticleStatus (@Argument String id) {
        return articleService.updateArticleStatus(id);
//        try {
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
    }
    @MutationMapping
    public void deleteArticle (@Argument String id) {
        articleService.deleteArticle(id);
//        try {
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
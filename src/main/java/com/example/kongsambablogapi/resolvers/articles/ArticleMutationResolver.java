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
        try {
            return articleService.createArticle(articleInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @MutationMapping
    public Article updateArticle (@Argument String id, @Argument ArticleInput articleInput) {
        try {
            return articleService.updateArticle(id, articleInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @MutationMapping
    public Article updateArticleStatus (@Argument String id) {
        try {
            return articleService.updateArticleStatus(id);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @MutationMapping
    public void deleteArticle (@Argument String id) {
        try {
            articleService.deleteArticle(id);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
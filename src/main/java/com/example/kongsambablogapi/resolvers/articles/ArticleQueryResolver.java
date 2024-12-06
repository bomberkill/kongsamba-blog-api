package com.example.kongsambablogapi.resolvers.articles;

import com.example.kongsambablogapi.models.articles.Article;
import com.example.kongsambablogapi.models.articles.ArticleType;
import com.example.kongsambablogapi.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public  class ArticleQueryResolver {
    @Autowired
    private ArticleService articleService;

    @QueryMapping
    public List<Article> getAllArticles (@Argument Boolean posted, @Argument ArticleType articleType,@Argument Integer number) {
        return articleService.getAllArticles(posted, articleType, number);
    };

    @QueryMapping
    public Article getArticleById (@Argument String id) {
        return articleService.getArticleById(id).orElse(null);
    }
}
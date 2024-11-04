package com.example.kongsambablogapi.repositories;

import com.example.kongsambablogapi.models.articles.Article;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {
}
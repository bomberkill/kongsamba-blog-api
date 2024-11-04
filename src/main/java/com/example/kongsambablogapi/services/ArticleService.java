package com.example.kongsambablogapi.services;

import com.example.kongsambablogapi.models.articles.Article;
import com.example.kongsambablogapi.models.articles.ArticleInput;
import com.example.kongsambablogapi.models.articles.Metadata;
import com.example.kongsambablogapi.repositories.AdminRepository;
import com.example.kongsambablogapi.repositories.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private AdminRepository adminRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
    public Optional<Article> getArticleById (String id) {
        return articleRepository.findById(id);
    }
    public Article createArticle (ArticleInput articleInput) {
        if (adminRepository.existsById(articleInput.getAuthor())) {
            Metadata metadata = new Metadata();
            metadata.setCreatedAt(LocalDateTime.now());
            Article article = new Article();
            article.setArticleInput(articleInput);
            article.setMetadata(metadata);
            article.setPosted(false);
            return articleRepository.save(article);
        }
        throw new IllegalArgumentException("Error when creating: Author not found");
    }
    public Article updateArticle (String id, ArticleInput articleInput) {
        if (articleRepository.existsById(id)) {
            Optional<Article> articleOpt = articleRepository.findById(id);
            if (articleOpt.isPresent()) {
                Article existingArticle = articleOpt.get();
                articleInput.setAuthor(existingArticle.getArticleInput().getAuthor());
                existingArticle.setArticleInput(articleInput);
                existingArticle.getMetadata().setUpdatedAt(LocalDateTime.now());
                return articleRepository.save(existingArticle);
            }
        };
        throw new IllegalArgumentException("Error when updating: Article not found");
    }
    public Article updateArticleStatus (String id) {
        if (articleRepository.existsById(id)) {
            Optional<Article> articleOpt = articleRepository.findById(id);
            if (articleOpt.isPresent()) {
                Article existingArticle = articleOpt.get();
                existingArticle.setPosted(!existingArticle.getPosted());
                return articleRepository.save(existingArticle);
            }
        };
        throw new IllegalArgumentException("Error when updating: Article not found");
    }
    public void deleteArticle (String id) {
        articleRepository.deleteById(id);
    }
}
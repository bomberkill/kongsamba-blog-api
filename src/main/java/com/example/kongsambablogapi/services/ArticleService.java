package com.example.kongsambablogapi.services;

import com.example.kongsambablogapi.exception.RequestException;
import com.example.kongsambablogapi.models.articles.Article;
import com.example.kongsambablogapi.models.articles.ArticleInput;
import com.example.kongsambablogapi.models.articles.ArticleType;
import com.example.kongsambablogapi.models.articles.Metadata;
import com.example.kongsambablogapi.repositories.AdminRepository;
import com.example.kongsambablogapi.repositories.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public List<Article> getAllArticles(Boolean posted, ArticleType articleType, Integer number) {
        if ((number != null && number > 0) && articleType != null) {
            Pageable pageable = PageRequest.of(0, number);
            if (posted != null) {
                return articleRepository.findAllByArticleInputTypeAndPostedOrderByMetadataCreatedAtDesc(posted, articleType, pageable);
            }
            return articleRepository.findAllByArticleInputTypeOrderByMetadataCreatedAtDesc(articleType, pageable);
        } else if (articleType == null && (number != null && number > 0)) {
            Pageable pageable = PageRequest.of(0, number);
            if (posted != null) {
                return articleRepository.findAllByPostedOrderByMetadataCreatedAtDesc(posted, pageable);
            }
            return articleRepository.findAllByOrderByMetadataCreatedAtDesc(pageable);
        } else if (articleType != null) {
            if (posted != null) {
                return articleRepository.findAllByArticleInputTypeAndPostedOrderByMetadataCreatedAtDesc(posted, articleType);
            }
            return articleRepository.findAllByArticleInputTypeOrderByMetadataCreatedAtDesc(articleType);
        } else if (posted != null) {
            return articleRepository.findAllByPostedOrderByMetadataCreatedAtDesc(posted);
        }
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
        System.out.println("Error when creating: Author not found" + " " + LocalDateTime.now());
        throw new RequestException("Error when creating: Author not found");
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
        System.out.println("Error when updating: Article not found" + " " + LocalDateTime.now());
        throw new RequestException("Error when updating: Article not found");
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
        System.out.println("Error when updating: Article not found" + " " + LocalDateTime.now());
        throw new RequestException("Error when updating: Article not found");
    }
    public void deleteArticle (String id) {
        articleRepository.deleteById(id);
    }
}
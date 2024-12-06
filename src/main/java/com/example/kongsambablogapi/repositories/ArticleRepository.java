package com.example.kongsambablogapi.repositories;

import com.example.kongsambablogapi.models.articles.Article;
import com.example.kongsambablogapi.models.articles.ArticleType;
import com.example.kongsambablogapi.models.playlists.Playlist;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {
    List<Article> findAllByOrderByMetadataCreatedAtDesc(Pageable pageable);
    List<Article> findAllByPostedOrderByMetadataCreatedAtDesc(Boolean posted, Pageable pageable);
    List<Article> findAllByPostedOrderByMetadataCreatedAtDesc(Boolean posted);
    List<Article> findAllByArticleInputTypeOrderByMetadataCreatedAtDesc(ArticleType articleType, Pageable pageable);
    List<Article> findAllByArticleInputTypeAndPostedOrderByMetadataCreatedAtDesc(Boolean posted, ArticleType articleType, Pageable pageable);
    List<Article> findAllByArticleInputTypeAndPostedOrderByMetadataCreatedAtDesc(Boolean posted, ArticleType articleType);
    List<Article> findAllByArticleInputTypeOrderByMetadataCreatedAtDesc(ArticleType articleType);
}
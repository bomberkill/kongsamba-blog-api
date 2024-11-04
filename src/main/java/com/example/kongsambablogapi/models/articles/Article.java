package com.example.kongsambablogapi.models.articles;
//import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Articles")
public class Article {
    @Id
    private String id;
    private boolean posted;
    private  Metadata metadata;
    private ArticleInput articleInput;

//    public Article(ArticleInput articleInput, Metadata metadata) {
//        this.articleInput = articleInput;
//        this.metadata = metadata;
//        this.posted = false;
//    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
    }


    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }


    public ArticleInput getArticleInput() {
        return articleInput;
    }

    public void setArticleInput(ArticleInput articleInput) {
        this.articleInput = articleInput;
    }
}
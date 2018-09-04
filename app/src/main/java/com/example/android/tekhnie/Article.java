package com.example.android.tekhnie;

/**
 * {@Link Article} represents a news article on the list
 */

public class Article {

    /** Article title */
    private String mArticleTitle;

    /** Article byline */
    private String mArticleByline;

    /** Article section */
    private String mArticleSection;

    /** Date article published */
    private String mArticleDate;

    /** URL for article */
    private String mUrl;

    /**
     * Constructs a new {@Link Article object}
     */
    public Article(String title, String byline, String section, String date, String url) {
        mArticleTitle = title;
        mArticleByline = byline;
        mArticleSection = section;
        mArticleDate = date;
        mUrl = url;
    }

    public String getArticleTitle() {
        return mArticleTitle;
    }

    public String getArticleByline() {
        return mArticleByline;
    }

    public String getArticleSection() {
        return mArticleSection;
    }

    public String getArticleDate() {
        return mArticleDate;
    }

    public String getArticleUrl() {
        return mUrl;
    }
}

package com.zlq;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq
 * @ClassName: MyPractise
 * @description:
 * @author: LiQun
 * @CreateDate:2021/5/30 10:35 上午
 */
public class MyPractise {
    public static void main(String[] args) {
        List<Integer> articleIdList = Arrays.asList(6, 5, 6, 5, 1);
        Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (Integer articleId : articleIdList) {
            map.put(articleId, map.getOrDefault(articleId, 0) + 1);
        }
        List<Integer> newArticleIdList = new ArrayList<>();

        for (Integer articleId : map.keySet()) {
            newArticleIdList.add(articleId);
        }


        Article article1 = new Article(1, "文章1");
        Article article2 = new Article(2, "文章2");
        Article article3 = new Article(3, "文章3");
        Article article4 = new Article(4, "文章4");
        Article article5 = new Article(5, "文章5");
        Article article6 = new Article(6, "文章6");
        List<Article> list = new ArrayList<>();
        list.add(article1);
        list.add(article2);
        list.add(article3);
        list.add(article4);
        list.add(article5);
        list.add(article6);

        List<Article> articleList = new ArrayList<>();
        for (Integer articleId : newArticleIdList) {
            articleList.add(list.get(articleId - 1));
        }
        System.out.println(articleList);
    }
}


class Article {
    private Integer articleId;
    private String articleTitle;

    public Article(Integer articleId, String articleTitle) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleId, article.articleId) && Objects.equals(articleTitle, article.articleTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, articleTitle);
    }
}

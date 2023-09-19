package Function;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BoardController {

    QueryManager queryManager;
    Board_Print board_print;

    public BoardController() {
        queryManager = new QueryManager();
        board_print = new Board_Print();
    }

    public Article detail(int num) {
        Article article = queryManager.getArticleById(num);
        board_print.board_print(article);
        return article;
    }

    public List<Article> list() {
        List<Article> articleList = queryManager.getAllArticle();
        board_print.board_print(articleList);
        return articleList;
    }

    public List<Article> search(String keyword) {
        List<Article> searchedArticleList = queryManager.getArticle(keyword);
        board_print.board_print(searchedArticleList);
        return searchedArticleList;
    }

    public Article update(Article article) {
        Article updatedArticle;
        updatedArticle = queryManager.updateArticle(article.getNumber(), article.getTitle(), article.getContents());


        return updatedArticle;
    }

    public Article delete(Article article) {
        Article deletedArticle;
        deletedArticle = queryManager.deleteArticle(article.getNumber());

        return deletedArticle;
    }
}

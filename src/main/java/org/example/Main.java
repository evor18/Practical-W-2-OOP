package org.example;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static void main(String[] args) throws IOException, InterruptedException  {
        System.out.print("Что вас интересует?  \n");
        Scanner scanner = new Scanner(System.in);
        String userStr = scanner.nextLine();
        Article articles = new Article();
        articles.readJson( WorkWithHTTP.getJson(userStr) ); // читаем json и записываем данные в titles и pageids
        if (articles.titles.toArray().length != 0){
            System.out.print("Список тем, связанных с " + userStr + ":" + '\n');
            articles.showTitles();
            System.out.print("Какая статья вас интересует? \n");
            int userStrInt = CheckEnter.check_enter(1, articles.titles.toArray().length);
            WorkWithHTTP.getHTTP(articles.pageids.get(userStrInt-1));
        }
        else System.out.print("Ничего не найдено по запросу!");
    }
}

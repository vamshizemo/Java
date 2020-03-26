package com.vamshi.solid;


class Book {

    private String name;
    private String author;
    private String text;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public String replaceWordInText(String word){
        return text.replaceAll(word, text);
    }

    public boolean isWordInText(String word){
        return text.contains(word);
    }

    public void printTextToConsole(){
        System.out.println(getText());
    }

}
class BookPrinter {

    void printTextToConsole(Book b){
        System.out.println(b.getText());
    }
}


public class SingleResponsibility {
    public static void main(String[] args) {
        Book book = new Book();
        book.setName("Science book");
        book.setAuthor("Author");
        book.setText("this is the text of the book");
        book.printTextToConsole();

        BookPrinter Bookprint = new BookPrinter();
        Bookprint.printTextToConsole(book);

    }
}

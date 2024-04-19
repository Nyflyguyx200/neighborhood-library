package com.pluralsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    //Constructor
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false; //Default is not checked out
        this.checkedOutTo = " "; //Default checked out ti nobody
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    //Method to check out a book
    public void checkOut(String name) {
        this.isCheckedOut = true;
        this.checkedOutTo = name;
    }

    //Metrhod to check in a book
    public void checkIn() {
        this.isCheckedOut = false;
        this.checkedOutTo = " ";
    }

    //toString method to provide a custom string representation of the book
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append(", ISBN: ").append(isbn).append(". Title: ").append(title);

        //If checked out, append the name it's checked out to
        if (isCheckedOut) {
            sb.append(", Checked out to: ").append(checkedOutTo);
        }

        return sb.toString();
    }
}










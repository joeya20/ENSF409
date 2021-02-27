public class MyBook {
    // public static void main(String[] args) {
    // var anne = new Author();
    // // Nonfiction, Category, Paperback
    // var history = new Nonfiction();
    // var deweyOne = new Category();
    // deweyOne.setCategory("History");
    // var deweyTwo = new Category();
    // deweyTwo.setCategory("French");
    // deweyTwo.setSuperCategory(deweyOne);
    // deweyOne.setSubCategory(deweyTwo);
    // var deweyThree = new Category();
    // deweyThree.setCategory("Revolution");
    // deweyThree.setSuperCategory(deweyTwo);
    // deweyTwo.setSubCategory(deweyThree);
    // System.out.println(deweyThree.sort());
    // history.setDeweyClassification(deweyThree);
    // System.out.println(history.topic());
    // System.out.println(history.coverArt());
  
    // // Series, Novel
    // var lestat = new Series();
    // lestat.setSeriesName("Lestat the Vampire");
    // System.out.println(lestat.theme());
    // var interviewWithVampire = new Novel();
    // interviewWithVampire.setMySeries(lestat);
    // interviewWithVampire.setTheAuthor(anne);
    // System.out.println(interviewWithVampire.coverArt());
    // System.out.println(interviewWithVampire.genre());
  
    // // Anthology, Story
    // var vampireInParis = new Story();
    // vampireInParis.setTheAuthor(anne);
    // System.out.println(vampireInParis.plot());
    // var vampiresEverywhere = new Anthology();
    // System.out.println(vampiresEverywhere.storyOrder());
    // }
}

abstract class Book {
    private String isbn;
    private int publicationYear;
    private int pages;

    public Book(){
        this(null, 0);
    }

    public Book(String isbn, int pages){
        this.isbn = isbn;
        this.pages = pages;
        this.publicationYear = 0;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPages() {
        return pages;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}

abstract class Hardcover extends Book {
    public abstract void binding();
}

class Classic extends Hardcover {
    private int origPubYear = 1860;
    private Author theAuthor = new Author();
    private Publisher[] bookPublisher = new Publisher[10]; //check

    public void binding() {
    }
    
    public String createNotes() {
        return "Method createNotes called from Classic";
    }
    
    public void setOrigPubYear(int origPubYear) {
        this.origPubYear = origPubYear;
    }

    public void setTheAuthor(Author theAuthor) {
        this.theAuthor = theAuthor;
    }

    public void setBookPublisher(Publisher[] bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public int getOrigPubYear() {
        return origPubYear;
    }

    public Author getTheAuthor() {
        return theAuthor;
    }

    public Publisher[] getBookPublisher() {
        return bookPublisher;
    }
}

class Publisher {
    private String name;
    private String address;
    private Classic[] classicCatalog = new Classic[10];

    public Publisher(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String printLetterhead(){
        return "Method printLetterhead called from Publisher";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setClassicCatalog(Classic[] classicCatalog) {
        this.classicCatalog = classicCatalog;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public Classic[] getClassicCatalog() {
        return classicCatalog;
    }

    public String getName() {
        return name;
    }
}

abstract class Paperback extends Book {

    public String coverArt(){
        return "Method coverArt called from Paperback";
    }
}

class Nonfiction extends Paperback {

    private Category deweyClassification = new Category();

    public void setDeweyClassification(Category deweyClassification) {
        this.deweyClassification = deweyClassification;
    }

    public Category getDeweyClassification() {
        return deweyClassification;
    }

    public String topic() {
        return "Method topic called from Nonfiction";
        
    }
}

abstract class Fiction extends Paperback {

    public abstract String coverArt();

    public String genre(){
        return "Method genre called from Fiction";
    }
}

class Anthology extends Fiction {

    private Story[] story = new Story[10];

    public String storyOrder() {
        return "Method storyOrder called from Anthology";
    }

    public String coverArt(){
        return "Method coverArt called from Anthology";
    }

    public Story[] getStory() {
        return story;
    }

    public void setStory(Story[] story) {
        if(story.length >= 5){
            this.story = story;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}

class Novel extends Fiction {

    private Author theAuthor = new Author();
    private Series mySeries;

    public Series getMySeries() {
        return mySeries;
    }

    public Author getTheAuthor() {
        return theAuthor;
    }

    public void setMySeries(Series mySeries) {
        this.mySeries = mySeries;
    }

    public void setTheAuthor(Author theAuthor) {
        this.theAuthor = theAuthor;
    }

    public String theme(){
        return "Method theme called from Novel";
    }

    public String coverArt(){
        return "Method coverArt called from Novel";
    }
}

class Author {
    private String name = "Unknown";
    private String address;
    private int age;

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author()
    {
        this(null, null, 0);
    }

    public Author(String name, String address, int age)
    {
        this.address = address;
        this.age = age;
        this.name = name;
    }

    public String write(){
        return "Method write called from Author";
    }
}

class Series {
    private String seriesName;

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String theme(){
        return "Method theme called from Series";
    }
}

class Story {

    private Author theAuthor = new Author();

    public void setTheAuthor(Author theAuthor) {
        this.theAuthor = theAuthor;
    }

    public Author getTheAuthor() {
        return theAuthor;
    }

    public String plot() {
        return "Method plot called from Story";
    }
}

class Contract {
    private String date;
    private Publisher publisherInfo;
    private Author authorInfo;

    public void setAuthorInfo(Author authorInfo) {
        this.authorInfo = authorInfo;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPublisherInfo(Publisher publisherInfo) {
        this.publisherInfo = publisherInfo;
    }  

    public Author getAuthorInfo() {
        return authorInfo;
    }

    public String getDate() {
        return date;
    }

    public Publisher getPublisherInfo() {
        return publisherInfo;
    }

    public Contract(String date, Publisher publisherInfo, Author authorInfo){
        this.date = date;
        this.authorInfo = authorInfo;
        this.publisherInfo = publisherInfo;
    }

    public String printContract(){
        return "Method printContract called from Contract";
    }
}

class Category {
    private Category subCategory;
    private Category superCategory;
    private String category;

    public String getCategory() {
        return category;
    }

    public Category getSubCategory() {
        return subCategory;
    }

    public Category getSuperCategory() {
        return superCategory;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSubCategory(Category subCategory) {
        this.subCategory = subCategory;
    }

    public void setSuperCategory(Category superCategory) {
        this.superCategory = superCategory;
    }

    public String sort() {
        return "Method sort called from Category";
    }

}
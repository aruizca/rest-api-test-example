package rest.sample

class Book {

    String title

    static constraints = {
        title blank: false, unique: true
    }
}

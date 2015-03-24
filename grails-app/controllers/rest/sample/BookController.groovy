package rest.sample

import grails.converters.JSON
import grails.rest.RestfulController

class BookController extends RestfulController<Book> {
    static responseFormats = ['json']

    BookController() {
        super(Book)
    }

    @Override
    def save() {
        def jsonParams = request.JSON
        render new Book(title: jsonParams.title).save() as JSON
    }
}

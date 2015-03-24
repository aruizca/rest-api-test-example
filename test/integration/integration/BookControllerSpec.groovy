package integration

import grails.test.spock.IntegrationSpec
import rest.sample.Book
import rest.sample.BookController
import spock.lang.Shared

class BookControllerSpec extends IntegrationSpec {

    @Shared BookController controller = new BookController()

    def setup() {
        // Initialize DB
        new Book(title: "title1").save()
    }

    def cleanup() {
    }

    void "test creating a book"() {
        when:
        // Set request JSON body
        controller.request.json = [
            title: "title2"
        ]
        controller.save()
        def response = controller.response.json

        then:
        response.title == "title2"
        Book.count == 2
    }
}

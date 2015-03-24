package functional

import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import grails.test.spock.IntegrationSpec
import rest.sample.Book
import spock.lang.Shared

class BookControllerFunctionalSpec extends IntegrationSpec {

    @Shared
    def grailsApplication

    def setup() {
        // Initialize DB
        new Book(title: "title1").save()
    }

    def cleanup() {
    }

    void "test creating a book"() {
        given:
        RestBuilder rest = new RestBuilder()

        when:
        RestResponse response = rest.post("http://localhost:8080/${grailsApplication.metadata.'app.name'}/books") {
            json([
                title: "title2"
            ])
        }

        then:
        response.status == 200
        response.json.title == "title2"
        Book.count == 2
    }
}

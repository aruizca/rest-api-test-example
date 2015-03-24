class UrlMappings {

	static mappings = {

        "/books/$id?"(controller: 'book') {
            action = [POST: 'save']
        }

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}

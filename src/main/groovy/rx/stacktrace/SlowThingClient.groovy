package rx.stacktrace

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Single

@Client("http://localhost:8080")
interface SlowThingClient {
    @Get("/slow-thing")
    Single<Thing> getSlowThing()
}
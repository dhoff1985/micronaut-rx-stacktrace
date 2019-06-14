package rx.stacktrace

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get


@Controller
class SlowThingController {

    @Get("/slow-thing")
    Thing getSlowThing() {
        Thread.sleep(1000)
        return new Thing(thing: "slow thing")
    }
}

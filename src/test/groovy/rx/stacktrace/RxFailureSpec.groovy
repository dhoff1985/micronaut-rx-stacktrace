package rx.stacktrace

import io.micronaut.test.annotation.MicronautTest
import io.reactivex.Single
import spock.lang.Specification

import javax.inject.Inject
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

@MicronautTest
class RxFailureSpec extends Specification {

    @Inject
    SlowThingClient slowThingClient

    def "demonstrate rx stacktrace"() {
        when:
        Single thing = slowThingClient.getSlowThing()
        Thing response = thing.timeout(25, TimeUnit.MILLISECONDS).blockingGet()

        then:
        RuntimeException e = thrown(RuntimeException)
        e.cause instanceof TimeoutException
        Thread.sleep(1000) // wait for netty read timeout
    }
}

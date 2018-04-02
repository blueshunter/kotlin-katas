package bandwidth

import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.TestScheduler
import junit.framework.TestCase
import org.junit.Test
import java.util.concurrent.TimeUnit


class BandwidthTest : TestCase() {

    private class ProfileRepositoryMock(private val profileStub: Profile) : ProfileRepositoryInterface {
        override fun get(id: String): Observable<Profile> =  Observable.just(profileStub)
    }

    @Test
    fun `test get profile`() {

        val profileStub = Profile()
        val profileRepositoryMock = ProfileRepositoryMock(profileStub)

        val profileObserver = TestObserver<Profile>()
        val profileObservable = profileRepositoryMock.get(id = "fakeId")
        val scheduler = TestScheduler()

        profileObservable
                .subscribeOn(scheduler)
                .subscribe(profileObserver)


        profileObserver.assertNoValues()
        profileObserver.assertNotComplete()

        scheduler.advanceTimeBy(1, TimeUnit.SECONDS)

        profileObserver.assertNoErrors()
        profileObserver.assertValueCount(1)
        profileObserver.assertValue(profileStub)
    }

    @Test
    fun `test to get 100 profiles`() {

        val profileStub = Profile()
        val profileRepositoryMock = ProfileRepositoryMock(profileStub)

        val profileObserver = TestObserver<Profile>()
        val profileObservable = profileRepositoryMock.get(id = "fakeId")
        val scheduler = TestScheduler()

        var profileObservables: Array<Observable<Profile>> = Array(100, init = { index ->
            profileRepositoryMock.get(id = index.toString())
        })


        val mergeObservables = Observable.mergeArray(1, 1, profileObservable, profileObservable, profileObservable, profileObservable)

        mergeObservables
                .subscribeOn(scheduler)
                .subscribe(profileObserver)

        profileObserver.assertNoValues()
        profileObserver.assertNotComplete()

        println("start subsription")
        scheduler.advanceTimeBy(1, TimeUnit.SECONDS)

        profileObserver.assertNoErrors()
        println(profileObserver.valueCount())

    }
}
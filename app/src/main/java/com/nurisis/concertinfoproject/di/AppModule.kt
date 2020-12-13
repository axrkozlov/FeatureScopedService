package com.nurisis.concertinfoproject.di

import com.nurisis.concertinfoproject.data.ConcertRepository
import com.nurisis.concertinfoproject.data.local.ConcertLocalDataSource
import com.nurisis.concertinfoproject.data.local.Database
import com.nurisis.concertinfoproject.data.remote.ConcertRemoteDataSource
import com.nurisis.concertinfoproject.domain.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    single { SaveBookMarkUseCase(get()) }
    single { DeleteBookMarkUseCase(get()) }
    single { GetBookMarkUseCase(get()) }
    single { GetConcertsUseCase(get()) }

    single { ConcertRemoteDataSource(get()) }
    single { ConcertRepository(get(),get()) }


    single { ConcertLocalDataSource(Database.getDatabase(androidContext()).concertDao()) }

//    factory { Container() }
//    scope<Container> {
//        scoped { TwoThreeService() }
//    }
//    single { TwoThreeService() }
}
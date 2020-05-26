package com.songgyubin.sizey.etc.koin

import org.koin.dsl.module

// applicationContext : Koin 모듈 생성
// factory : 매번 inject 할때마다 인스턴스 생성
// single : 싱글톤 생성
// bind : 종속시킬 class나 interface를 주입
// get : 컴포넌트내에서 알맞은 의존성을 주입함

/*
val repositoryModule = module {
    factory { AuthRepository() }

}
*/

val viewModelModule = module {
//    viewModel { AuthViewModel(get()) }
}

val adapterModule = module {
//    factory { MainAdatper(mutableListOf()) }
}

//val myDiModule = listOf(viewModelModule, repositoryModule)
val myDiModule = listOf(viewModelModule)
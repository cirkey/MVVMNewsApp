package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.models.Article
import com.androiddevs.mvvmnewsapp.ui.fragments.BreakingNewsFragment


// uloga repositorya je da uzme datu iz nase db i od retrofita(Api) ovde ima funkcija koja direktno
// queryje nas api za breaking news u newsviewmodelu imamo instance repositoryja pa cemo njega
//  zvacemo funkcije preko iz news repository i takodje ce mo se handleotavi responses
// i livedata objekte koji ce obavestiti fragmente o promenama o requestisma
class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchForNews(searchQuery: String,pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticles(article)






}
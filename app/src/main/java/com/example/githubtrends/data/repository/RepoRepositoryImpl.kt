package com.example.githubtrends.data.repository

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.githubtrends.data.local.RepoDatabase
import com.example.githubtrends.data.model.Repo
import com.example.githubtrends.data.remote.GithubApi
import com.example.githubtrends.domain.repository.RepoRepository
import com.example.githubtrends.util.DataStoreUtil
import com.example.githubtrends.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

const val CACHE_EXPIRY_MILLIS = 15 * 60 * 1000

@Singleton
class RepoRepositoryImpl @Inject constructor(
    private val api: GithubApi,
    db: RepoDatabase,
    private val dataStoreUtil: DataStoreUtil,
) : RepoRepository {

    val dao = db.dao

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getAllRepos(): Flow<Resource<List<Repo>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))

//            val cacheExpired = hasCacheExpiredOrNotAvailable()
//            if (!cacheExpired) {
//                val localRepoList = dao.getAllRepos()
//                emit(Resource.Success(data = localRepoList))
//                emit(Resource.Loading(isLoading = false))
//                return@flow
//            }

            val remoteRepoList = try {
                // Repo push date should not be older than 2 days
                val date = LocalDateTime.now().minusDays(2).format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd")
                )
                val response = api.getAllRepos(getFullUrl(date))
                response.items
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "" + e.localizedMessage))
                null
            }

            remoteRepoList?.let {
                dao.clearRepoList()
                dao.insertRepoList(remoteRepoList)
                dataStoreUtil.saveApiCallTimestamp(System.currentTimeMillis())
                Log.d("Girish", "getAllRepos: $remoteRepoList")
                emit(Resource.Success(data = remoteRepoList))
            }
            emit(Resource.Loading(isLoading = false))
        }

    }

    private fun getFullUrl(date: String): String {
        return "https://api.github.com/search/repositories?sort=stars&q=+language:kotlin&pushed:>$date"
    }

    override suspend fun getRepoInfo(id: Long): Flow<Resource<Repo>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val repo = dao.getRepoInfo(id = id)
            if (repo != null) {
                emit(Resource.Success(data = repo))
            } else {
                emit(Resource.Error(message = "Error. Repo couldn't be found"))
            }
        }
    }

    private suspend fun hasCacheExpiredOrNotAvailable(): Boolean {
        val lastCall = dataStoreUtil.getApiCallTimestamp() ?: return true
        val currTime = System.currentTimeMillis()
        val millisElapsed = currTime - lastCall
        return millisElapsed > CACHE_EXPIRY_MILLIS
    }
}
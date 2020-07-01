package com.example.learnkotlin.viewModel


import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.learnkotlin.model.database.AbstractDataBase
import com.example.learnkotlin.model.database.DataBaseRepository
import com.example.learnkotlin.model.database.PersonTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CommonViewModule(app: Application) : AndroidViewModel(app) {
    var repository: DataBaseRepository
    var mContext: Context

    init {
        mContext = app;
        repository = DataBaseRepository(AbstractDataBase.getDatabase(mContext).getIDAO())
    }

    suspend fun fetchData(): MutableList<PersonTable> {
        return repository.fetchAllData()
    }

    fun createPerson(newPerson: PersonTable) {
        CoroutineScope(Dispatchers.IO).launch { repository.insertData(newPerson) }
    }

    suspend fun queryFilter(value: String): MutableList<PersonTable> {
        return repository.queryFilter(value)
    }

    fun removePerson(newPerson: PersonTable) {
        CoroutineScope(Dispatchers.IO).launch { repository.deletePerson(newPerson) }
    }

    fun deleteAllData() {
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteAllData()
        }
    }
}
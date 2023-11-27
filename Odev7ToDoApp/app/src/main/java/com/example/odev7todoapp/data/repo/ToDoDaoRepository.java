package com.example.odev7todoapp.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.odev7todoapp.data.entity.ToDo;
import com.example.odev7todoapp.room.ToDoDao;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ToDoDaoRepository {

    public MutableLiveData<List<ToDo>> toDoList = new MutableLiveData<>();

    private ToDoDao tDao;

    public ToDoDaoRepository(ToDoDao tDao) {
        this.tDao = tDao;
    }

    private CompletableObserver getCompletableObserver() {
        return new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {}

            @Override
            public void onComplete() {
                getToDo();
            }

            @Override
            public void onError(Throwable e) {}
        };
    }

    public void add(String name) {
        ToDo newToDo = new ToDo(0, name);
        tDao.add(newToDo)
                .subscribe(getCompletableObserver());
    }

    public void update(int id, String name) {
        ToDo updatedToDo = new ToDo(id, name);
        tDao.update(updatedToDo)
                .subscribe(getCompletableObserver());
    }

    public void search(String search) {
        tDao.search(search)
                .subscribe(toDos -> toDoList.setValue(toDos));
    }

    public void deleteItem(int id) {
        ToDo deletedToDo = new ToDo(id, "");
        tDao.delete(deletedToDo)
                .subscribe(getCompletableObserver());
    }

    public void deleteAll() {
        tDao.deleteAll()
                .subscribe(getCompletableObserver());
    }

    public void getToDo() {
        tDao.getToDo()
                .subscribe(toDos -> toDoList.setValue(toDos));
    }
}


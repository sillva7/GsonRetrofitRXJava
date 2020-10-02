package com.example.gsonretrofitrxjava.screens;

import android.widget.Toast;

import com.example.gsonretrofitrxjava.API.ApiFactory;
import com.example.gsonretrofitrxjava.API.ApiService;
import com.example.gsonretrofitrxjava.classes.Response;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class EmployeeListPresenter {

    private CompositeDisposable compositeDisposable;
    private EmployeeListView view;

    public EmployeeListPresenter(EmployeeListView view) {
        this.view = view;
    }

    public void loadData(){

        compositeDisposable= new CompositeDisposable();
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        Disposable disposable = apiService.getEmployees()//получаем Observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Response>() {
                    @Override
                    public void accept(Response response) throws Throwable {
                        view.showData(response.getResponse());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        view.showError(throwable);
                    }
                });

        compositeDisposable.add(disposable);


    }
     public void disposeDisposable(){
        if(compositeDisposable!=null){
            compositeDisposable.dispose();
        }
    }





}

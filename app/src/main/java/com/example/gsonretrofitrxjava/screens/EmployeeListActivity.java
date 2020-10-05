package com.example.gsonretrofitrxjava.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.gsonretrofitrxjava.API.ApiFactory;
import com.example.gsonretrofitrxjava.API.ApiService;
import com.example.gsonretrofitrxjava.R;
import com.example.gsonretrofitrxjava.adapters.EmployeeAdapter;
import com.example.gsonretrofitrxjava.classes.Employee;
import com.example.gsonretrofitrxjava.classes.Response;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class EmployeeListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EmployeeAdapter employeeAdapter;
    EmployeeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        employeeAdapter = new EmployeeAdapter();
        employeeAdapter.setEmployees(new ArrayList<Employee>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(employeeAdapter);
        viewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);

        viewModel.getEmployees().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                employeeAdapter.setEmployees(employees);
            }
        });
        viewModel.getErrors().observe(this, new Observer<Throwable>() {
            @Override
            public void onChanged(Throwable throwable) {
                if (throwable != null) {
                    Toast.makeText(EmployeeListActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    viewModel.clearErrors();
                }
            }
        });
        viewModel.loadData();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void showData(List<Employee> employees) {
        employeeAdapter.setEmployees(employees);
    }

    public void showError(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}

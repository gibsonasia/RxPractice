package com.example.asiagibson.rxpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.observers.DisposableObserver;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.ip_bttn);
        tv = (TextView) findViewById(R.id.ip_tv);

        button.setOnClickListener(view -> {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://ifconfig.co/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            IpConfigService service = retrofit.create(IpConfigService.class);
            Call<IpConfigResponse> response = service.getCurrentIp();

            response.enqueue(new Callback<IpConfigResponse>() {
                @Override
                public void onResponse(Call<IpConfigResponse> call, Response<IpConfigResponse> response) {
                    tv.setVisibility(View.VISIBLE);
                    tv.setText(response.body().getCity() + " " + response.body().getIp());
                }

                @Override
                public void onFailure(Call<IpConfigResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());

                }
            });

        });


        Observable<String> todoObservable = Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    emitter.onNext("This is the first RxJava Message of our lives");
                    emitter.onNext("hopefully not the last");
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });

        todoObservable.subscribeWith(new  DisposableObserver<String>() {

            @Override
            public void onNext(String t) {
                Toast.makeText(getApplicationContext(), t, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }
}

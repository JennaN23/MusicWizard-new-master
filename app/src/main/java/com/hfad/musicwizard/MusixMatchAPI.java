package com.hfad.musicwizard;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.MainThreadExecutor;

public class MusixMatchAPI {

    /*public static final String BASE_URL = "https://api.musixmatch.com/ws/1.1/";
    private MusixMatchService musixMatchService;
    private String token;

    private class WebAPIAuthenticator implements RequestInterceptor {
        @Override
        public void intercept(RequestInterceptor.RequestFacade request) {
            if (token != null) {
                request.addHeader("Authorization", "Bearer " + token);
            }
        }
    }

    public MusixMatchAPI() {
        Executor httpExecutor = Executors.newSingleThreadExecutor();
        MainThreadExecutor callbackExecutor = new MainThreadExecutor();
        musixMatchService = init(httpExecutor, callbackExecutor);
    }

    private MusixMatchService init(Executor httpExecutor, Executor callbackExecutor) {
        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.BASIC)
                .setExecutors(httpExecutor, callbackExecutor)
                .setEndpoint(BASE_URL)
                .setRequestInterceptor(new WebAPIAuthenticator())
                .build();

        return restAdapter.create(MusixMatchService.class);
    }

    public MusixMatchAPI setToken(String token) {
        this.token = token;
        return this;
    }

    public MusixMatchService getService() {
        return musixMatchService;
    }**/

}

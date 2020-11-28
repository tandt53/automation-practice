package com.tandt53.automation.api.test;

import com.tandt53.automation.api.Client;
import com.tandt53.automation.api.RequestUrl;
import com.tandt53.automation.api.RestRequest;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class PostmanEcho {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Request.Builder requestBuilder = new Request.Builder();
        HttpUrl.Builder urlBuilder = new HttpUrl.Builder();

        urlBuilder.scheme("https").host("postman-echo.com");
        urlBuilder.addPathSegments("get");
        urlBuilder.addQueryParameter("foo1", "bar");
        urlBuilder.addQueryParameter("foo2", "bar");

        requestBuilder.url(urlBuilder.build());
        System.out.println(builder.build().newCall(requestBuilder.build()).execute().body().string());

        Client client = new Client();
        RequestUrl url = new RequestUrl("https", "postman-echo.com", RequestUrl.EMPTY_PORT);
        url.addPath("get", false);
        url.addQueryParameter("foo1", "bar", false);
        url.addQueryParameter("foo2", "bar2", false);

        RestRequest request = new RestRequest(url);
        System.out.println(client.send(request).body());

    }


}

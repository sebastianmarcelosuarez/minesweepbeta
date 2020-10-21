package com.firebase;

import com.google.api.core.SettableApiFuture;
import org.json.simple.JSONArray;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface MyCallback {
  void onCallback(Future<Map<String, JSONArray>> value) throws ExecutionException, InterruptedException;
}


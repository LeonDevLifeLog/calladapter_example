package com.github.leondevlifelog.calladapter;

import androidx.lifecycle.LiveData;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

public class LiveDataCallAdapterFactory extends CallAdapter.Factory {
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if (getRawType(returnType) != LiveData.class) {
            return null;
        }
        //ListData<***>

        // ResultWrapper
        Type observableType = getParameterUpperBound(0, ((ParameterizedType) returnType));
        Class<?> rawObservableType = getRawType(observableType);
        if (rawObservableType != ResultWrapper.class) {
            throw new IllegalArgumentException("type must be a ResultWrapper.class  ");
        }
        if (!(observableType instanceof ParameterizedType)) {
            throw new IllegalArgumentException("resource must be parameterized");
        }
        return new LiveDataCallAdapter<>(observableType);
    }
}

package com.github.leondevlifelog.calladapter.network.base;

public class ResultWrapper<T> extends StatusResult {
    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}

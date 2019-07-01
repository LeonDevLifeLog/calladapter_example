# retrofit call adapter example


convert `Call<ResultWrapper<SomeApiResponse>> ...` to `LiveData<ResultWrapper<SomeApiResponse>> ...`


```java
public class ResultWrapper<T> {
    private String message;
    private int code;
    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
```

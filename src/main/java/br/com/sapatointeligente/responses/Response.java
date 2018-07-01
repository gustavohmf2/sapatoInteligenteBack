package br.com.sapatointeligente.responses;

import java.util.List;

/**
 * classe para encapsular respostas das requisisções
 * @param <T> classe que será encapsulada
 */

public class Response <T> {

    private T data;
    private List<String> errors;

    public Response() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}

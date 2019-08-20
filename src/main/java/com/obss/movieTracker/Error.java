package com.obss.movieTracker;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error extends Exception {
    private static final long serialVersionUID = 1L;
    private String mes;

    public Error(String mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return "Error [mes=" + mes + "]";
    }

}
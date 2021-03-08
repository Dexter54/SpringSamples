package com.ilgun;

public class HelloWorld {

    private String message;
    private Car oto;

    public void setMessage(Car oto){
        System.out.println("Inside Hellworld setter");
        this.oto  = oto;
    }
    public void getMessage(){
        oto.vergi();
    }

    public Car getOto() {
        return oto;
    }



    public void setOto(Car oto) {
        System.out.println("Inside Hellworld setter");
        this.oto = oto;
    }
}

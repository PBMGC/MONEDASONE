package Calculos;

import RecordsConversor.Moneda;

public class CalculoConversor {

    private Double conversion;

    public Double convertido(){return (double) Math.round(this.conversion * 100) / 100;}

    public void calculo(double valor,int Cantidad){
        this.conversion=Cantidad* valor;
    }

}

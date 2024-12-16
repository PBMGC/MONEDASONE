package modelos;

public class opciones {

    private String origen;
    private String destino;

    public opciones(String origen,String destino){
        this.origen=origen;
        this.destino=destino;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }
}

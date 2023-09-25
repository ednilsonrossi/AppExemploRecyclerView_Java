package br.edu.ifsp.dmo.recyclerviewexemplo;

public class AlgoImportante {
    private static int sequencia = 0;

    private int id;

    public AlgoImportante() {
        this.id = sequencia;
        sequencia += 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

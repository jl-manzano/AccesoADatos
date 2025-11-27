package inicio;

public class Medicamento {
    private int idMedicamento;
    private String composicion;

    public Medicamento(int idMedicamento, String composicion) {
        this.idMedicamento = idMedicamento;
        this.composicion = composicion;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getComposicion() {
        return composicion;
    }

    public void setComposicion(String composicion) {
        this.composicion = composicion;
    }
}

package inicio;

import java.sql.Date;

public class Receta {
    private int idReceta;
    private int idPaciente;
    private int idMedicamento;
    private Date fechaFin;

    public Receta(int idReceta, int idPaciente, int idMedicamento, Date fechaFin) {
        this.idReceta = idReceta;
        this.idPaciente = idPaciente;
        this.idMedicamento = idMedicamento;
        this.fechaFin = fechaFin;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}

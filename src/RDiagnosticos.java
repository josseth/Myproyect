public class RDiagnosticos {
    String nplaca,propietario,diagnostico,precio,dias,estado;
    public RDiagnosticos(String nplaca,String propietario,String diagnostico,String precio,String dias,String estado){
                                    this.nplaca=nplaca;
                                    this.propietario=propietario;
                                    this.diagnostico=diagnostico;
                                    this.precio=precio;
                                    this.dias=dias;
                                    this.estado=estado;
    }
    @Override
    public String toString(){
        return nplaca+";"+propietario+";"+diagnostico+";"+precio+";"+dias+";"+estado+";";
    }
}
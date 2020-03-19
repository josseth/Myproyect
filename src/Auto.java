public abstract class Auto {
                protected String estado;
                protected String propietario;
                protected String color;
                protected String nplaca;
                protected String tipo;
                public Auto(String propietario,String color,String estado,String nplaca, String tipo){
                        this.propietario=propietario;
                        this.color=color;
                        if (estado.isEmpty()){this.estado="NO PROCESADO";}else{this.estado=estado;}
                        this.nplaca=nplaca;
                        this.tipo=tipo;
                }
                @Override
                   public String toString(){
                        return tipo+";"+propietario+";"+color+";"+nplaca+";"+estado+";";
                   }
}
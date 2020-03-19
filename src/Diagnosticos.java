public class Diagnosticos {
    String id,nomdiag,precio,tiempo;
    public Diagnosticos(String nomdiag,String precio,String tiempo,String id){
                                    this.id=id;
                                    this.nomdiag=nomdiag;
                                    this.precio=precio;
                                    this.tiempo=tiempo;
    }
    @Override
    public String toString(){
        return nomdiag+";"+precio+";"+tiempo+";"+id+";";
    }
}
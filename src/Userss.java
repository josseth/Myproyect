public class Userss {
    String nom,pass;
    public Userss(String nombre,String password){
                                    this.nom=nombre;
                                    this.pass=password;
    }
    @Override
    public String toString(){
        return nom+";"+pass+";";
    }
}
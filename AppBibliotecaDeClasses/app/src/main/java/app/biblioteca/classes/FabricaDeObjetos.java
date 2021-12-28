package app.biblioteca.classes;

public class FabricaDeObjetos {

    private  static FabricaDeObjetos FACTORY = new FabricaDeObjetos();

    private  FabricaDeObjetos(){}

    public static FabricaDeObjetos instance(){
        return FACTORY;
    }

    public Modelo modelo(String nome, String email){
        return new Modelo(nome, email);
    }
}

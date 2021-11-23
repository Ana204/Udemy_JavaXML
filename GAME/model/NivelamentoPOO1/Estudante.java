package model.NivelamentoPOO1;

public class Estudante extends Pessoa{
    
    private int RA;
    private String curso;


    @Override
    public String toString() {
        return getCurso();
    }

    public int getRA() {
        return RA;
    }

    public void setRA(int rA) {
        RA = rA;
    }



    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


    
}

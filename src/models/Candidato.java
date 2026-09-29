package models;

public class Candidato implements Comparable<Candidato> {
    private String nome;
    private Double nota;

    public Candidato(String nome, double nota){
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getNota() {
        return nota;
    }
    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override 
    public int compareTo(Candidato c1){

        if(this.nota.equals(c1.getNota())){
           return this.nome.compareToIgnoreCase(c1.getNome()); 
        }
        
        return Double.compare(this.nota, c1.getNota());
    }

    
}

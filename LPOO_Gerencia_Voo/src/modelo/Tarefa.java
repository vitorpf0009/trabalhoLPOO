/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author vito
 */
//Getters e setters da tarefa cadastrada
public class Tarefa {

    private String nome;
    private String descricao;
    private CategoriaCurso catogoriaTarefa;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaCurso getCatogoriaTarefa() {
        return catogoriaTarefa;
    }

    public void setCatogoriaTarefa(CategoriaCurso catogoriaTarefa) {
        this.catogoriaTarefa = catogoriaTarefa;
    }

    @Override
    public String toString() {
        return nome + " (" + catogoriaTarefa + ")";
    }

}

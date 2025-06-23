/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.util.List;
import modelo.Tarefa;

/**
 *
 * @author vito
 */
public class TarefaController {
    // Método para adicionar uma tarefa a lista 
    
    public List<Tarefa> addTarefa(Tarefa t, List<Tarefa> listaTarefa){
    listaTarefa.add(t);
    return listaTarefa;    
    }
}

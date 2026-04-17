/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnviaPack;

/**
 *
 * @author roman
 */
public class ColaPaquetes {
    private Nodo frente; 
    private Nodo ultimo;
    
    public void encolar(Paquete p) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(p);
        if (frente == null) {
            frente = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parroquia;
import Vista.Vista;
import Control.Control;
import Modelo.Feligres;
import Modelo.Lista;

/**
 *
 * @author Jairo Sierra
 */
public class Parroquia {
     public static void main(String[] args) {
        Vista v = new Vista();
        Feligres f = new Feligres();
        Lista l = new Lista();
         Control c = new Control(f, v, l);
         
         c.iniciar();
         c.actionPerformed(null);
    }
}

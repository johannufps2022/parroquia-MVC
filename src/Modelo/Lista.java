/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Vista;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Jairo Sierra
 */
public class Lista extends Feligres {
    // Feligres feligres = new Feligres();

    
    ArrayList<Feligres> feligreses = new ArrayList<>();

    public Lista() {
        super();
    }

    public Lista(ArrayList feligres) {
        this.feligreses = feligreses;
    }

    //Feligres cedula, Feligres nombre, Feligres direccion, Feligres telefono, Feligres estrato, Feligres estado
    public void agregarFeligres(String cedula, String nombre, String direccion, String telefono, int estrato, boolean estado, int valorDiezmo) {

        Feligres f = new Feligres(cedula, nombre, direccion, telefono, estrato, estado, valorDiezmo);

        feligreses.add(f);
        System.out.println("prueba de creacion del objeto feligres");
    }

    public String mostrarDatosFeligres(String ConsultaCC) {

        String datos = "NO EXISTE";

        for (int i = 0; i < feligreses.size(); i++) {
            if (feligreses.get(i).getCedula().equals(ConsultaCC)) 
            datos = String.valueOf(feligreses.get(i));
            
        }
        return datos;
    }

    public int ConsultarDiezmo(String ConsultaCC) {
        int Cdiezmo = 0;
        for (int i = 0; i < feligreses.size(); i++) {
            if (feligreses.get(i).getCedula().equals(ConsultaCC)) {
                if (feligreses.get(i).getEstado() == true) {
                    if (feligreses.get(i).getEstrato() == 1) {
                        Cdiezmo = 250000;
                       
                    } else if (feligreses.get(i).getEstrato() == 2 || feligreses.get(i).getEstrato() == 3) {
                        Cdiezmo = 500000;
                        
                    } else if (feligreses.get(i).getEstrato() > 3) {
                        Cdiezmo = 1000000;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Cunsultar Diezmo\n*DIEZMO PAGADO*");
                }
            }
        }
        return Cdiezmo;
    }
    
    public String actualizar(String ccACT,String actCC,String actNombre,String actDireccion, String actTelefono,int actEstrato){
        String datos = "prueba de actualizar datos fallida";
        for(int i=0;i<feligreses.size();i++){
            if(feligreses.get(i).getCedula().equals(ccACT)){
                feligreses.get(i).setCedula(actCC);
                feligreses.get(i).setNombre(actNombre);
                feligreses.get(i).setDireccion(actDireccion);
                feligreses.get(i).setTelefono(actTelefono);
                feligreses.get(i).setEstrato(actEstrato);
                datos = String.valueOf(feligreses.get(i));
            }else
                datos ="no existe";
                
        }
        return datos;
    }
    public int totalizarDiezmo(){
        int totalDiezmo=0;
        for(int i=0; i<feligreses.size();i++)
             totalDiezmo += feligreses.get(i).getValorDiezmo();
        return totalDiezmo;
    }

    public void pagar(String ConsultaCC) {

        for (int i = 0; i < feligreses.size(); i++) {
            if (feligreses.get(i).getCedula().equals(ConsultaCC)) {
                if (feligreses.get(i).getEstado() == true) {
                    if (feligreses.get(i).getEstrato() == 1) {
                        feligreses.get(i).setValorDiezmo(250000);
                        feligreses.get(i).setEstado(false);
                    } else if (feligreses.get(i).getEstrato() == 2 || feligreses.get(i).getEstrato() == 3) {
                        feligreses.get(i).setValorDiezmo(500000);
                        feligreses.get(i).setEstado(false);
                    } else if (feligreses.get(i).getEstrato() > 3) {
                        feligreses.get(i).setValorDiezmo(1000000);
                        feligreses.get(i).setEstado(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pagar\n*DIEZMO PAGADO*");
                    
                }
            }
        }
    }
                public void Eliminar(){
                 feligreses.removeAll( feligreses);
                }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Feligres;
import Vista.Vista;
import Modelo.Lista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Jairo Sierra
 */
public class Control implements ActionListener {

    private Feligres f;
    private Vista v;
    private Lista l;

    public Control() {
    }

    public Control(Feligres f, Vista v, Lista l) {
        this.f = f;
        this.v = v;
        this.l = l;
        actionListener(this);
    }

    public void iniciar() {
        v.setTitle("SISTEMA PARROQUIA POO");
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }

    private void actionListener(ActionListener Control) {
        System.out.println("recibido boton 1");
        v.btnGuardar.addActionListener(Control);
        System.out.println("recibiendo boton 2");
        v.btnActualizar.addActionListener(Control);
        System.out.println("recibiendo boton 3");
        v.btnBuscar.addActionListener(Control);
        System.out.println("recibiendo boton 4");
        v.btnEliminar.addActionListener(Control);
        System.out.println("recibiendo boton 5");
        v.btnConsultar.addActionListener(Control);
        System.out.println("recibiendo boton 6");
        v.btnPagar.addActionListener(Control);
        System.out.println("recibiendo boton 7");
        v.btnTotalizar.addActionListener(Control);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        String ConsultaCC = v.txtDCedula.getText();
        boolean estado = false;
            if (v.txtEstado.getText().equalsIgnoreCase("deudor")) {
                estado = true;
            } else if (v.txtEstado.getText().equalsIgnoreCase("pago")) {
                estado = false;
            } else {
                System.out.println("estado no valido");
            }
            
        if (evento.getActionCommand().equals("Guardar")) {
            System.out.println("se guardaron datos");
//otra forma de guardar los datos
//                f.setCedula(v.txtCedula.getText());
//                f.setNombre(v.txtNombre.getText());
//                f.setDireccion(v.txtDireccion.getText());
//                f.setEstrato(Integer.parseInt(v.txtEstrato.getText()));
//                f.setTelefono(v.txtTelefono.getText());
//                f.setEstado(v.txtEstado.getText());
            
            

            l.agregarFeligres(v.txtCedula.getText(), v.txtNombre.getText(), v.txtDireccion.getText(),
                    v.txtTelefono.getText(), Integer.parseInt(v.txtEstrato.getText()), estado, 0);

        } else if (evento.getActionCommand().equals("Buscar")) {
            System.out.println("boton Buscar");
            v.areaResultados.setText(String.valueOf(l.mostrarDatosFeligres(ConsultaCC)));
        } else if (evento.getActionCommand().equals("Eliminar")) {
            //se limpian los JTextfield
            v.txtCedula.setText("");
            v.txtNombre.setText("");
            v.txtTelefono.setText("");
            v.txtEstrato.setText("");
            v.txtEstado.setText("");
            v.txtDireccion.setText("");
        } else if (evento.getActionCommand().equals("Actualizar")) {
            JOptionPane.showMessageDialog(null, "si cancela en alguno de los campos no se actualizara con exito los datos del feligres");
            String ccACT = JOptionPane.showInputDialog("Digite la Cedula del feligres que desea actualizar");
            String actCC= JOptionPane.showInputDialog("Digite la nueva Cedula del feligres");
            String actNombre = JOptionPane.showInputDialog("Digite el nuevo nombre del feligres");
            String actDireccion = JOptionPane.showInputDialog("Digite la nueva direccion del feligres");
            String actTelefono = JOptionPane.showInputDialog("Digite el nuevo telefono del feligres");
            int actEstrato = Integer.parseInt(JOptionPane.showInputDialog("Digite el nuevo estrato del feligres"));
            v.areaResultados.setText(String.valueOf(l.actualizar(ccACT, actCC, actNombre, actDireccion, actTelefono, actEstrato)));
            JOptionPane.showMessageDialog(null, "sea actualizo con exito");
            //l.mostrarDatosFeligres(ConsultaCC);
        } else if (evento.getActionCommand().equals("Consultar")) {
            System.out.println("boton consultar");
            
            v.txtDValorDiezmo.setText(String.valueOf(l.ConsultarDiezmo(ConsultaCC)));
        } else if (evento.getActionCommand().equals("Pagar")) {
            System.out.println("boton pagar");
           
            l.pagar(ConsultaCC);
            v.areaResultados.setText(String.valueOf(l.mostrarDatosFeligres(ConsultaCC)));

        } else if (evento.getActionCommand().equals("Totalizar")) {
            System.out.println("boton totalizar");
            v.areaResultados.setText(String.valueOf(l.totalizarDiezmo()));

        }
    }

}

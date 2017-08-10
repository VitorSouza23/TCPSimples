/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import javax.swing.JOptionPane;
import model.ClienteTCP;
import model.ServidorTCP;

/**
 *
 * @author Vitor
 */
public class Main {

    public static void main(String[] args) {
        int opc, porta;
        String IPAdress;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha o número do modo TCP: \n"
                    + "1 - Servidor \n"
                    + "2 - Cliente", "Modo TCP", JOptionPane.INFORMATION_MESSAGE));
            switch (opc) {
                case 1:
                    porta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da porta de escuta do Servidor:", "Modo Servidor", JOptionPane.INFORMATION_MESSAGE));
                    ServidorTCP.run(porta);
                    break;
                case 2:
                    IPAdress = JOptionPane.showInputDialog(null, "Digite o IP do Servidor:", "Modo Cliente", JOptionPane.INFORMATION_MESSAGE);
                    porta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da porta do serviço:", "Modo Cliente", JOptionPane.INFORMATION_MESSAGE));
                    ClienteTCP.run(IPAdress, porta);
                    break;
                default:
                   JOptionPane.showMessageDialog(null, "Digite uma opção válida! (1 ou 2)", "Opção inválida!", JOptionPane.ERROR_MESSAGE);
                   break;
            }
        } while (opc == 1 || opc == 2);
    }
}

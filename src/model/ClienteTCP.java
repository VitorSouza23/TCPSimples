/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.ObjectInputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitor
 */
public class ClienteTCP {

    public static void run(String IPAdress, int porta) {
        try {
            Socket cliente = new Socket(IPAdress, porta);
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            String mensagem = (String) entrada.readObject();
            JOptionPane.showMessageDialog(null, "Mensagem recebida do servidor:\n" + mensagem);
            entrada.close();
            JOptionPane.showMessageDialog(null, "Conexão encerrada.", "Fim da conexão.", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Conexão encerrada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

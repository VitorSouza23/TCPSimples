/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitor
 */
public class ServidorTCP {

    public static void run(int porta) {
        try {
            // Instancia o ServerSocket ouvindo a porta
            ServerSocket servidor = new ServerSocket(porta);
            JOptionPane.showMessageDialog(null, "O servidor vai começar a escutar a porta " + porta + ", clique em OK para iniciar.", "Iniciando...", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Servidor ouvindo a porta: " + porta);
            while (true) {
                // o método accept() bloqueia a execução até que
                // o servidor receba um pedido de conexão
                Socket cliente = servidor.accept();
                String mensagem = JOptionPane.showInputDialog(null, "Novo cliente conectado: " + cliente.getInetAddress().getHostAddress() + "\n"
                        + "Digite sua mensagem:", "Cliente conectado", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
                saida.flush();
                saida.writeObject(mensagem);
                saida.close();
                cliente.close();
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro: " + e.getMessage());
        } finally {
            JOptionPane.showMessageDialog(null, "Servidor encerrado...", "Fim", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

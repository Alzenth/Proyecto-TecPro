package ventanas;

import javax.swing.*;

public class Vcliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public Vcliente(String nombreUsuario) {
    	
    	String mensaje = ""
    	        + "=========================================================================\n"
    	        + "            ¡BIENVENIDO(A) A LA TIENDA DE POSTRES!                      \n"
    	        + "=========================================================================\n\n"
    	        + "Holi " + nombreUsuario + ", tu cuenta ha sido validada e iniciaste sesión correctamente.\n\n"
    	        + "=========================================================================\n";

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        setContentPane(contentPane);

        JOptionPane.showMessageDialog(
                null,
                mensaje, "",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
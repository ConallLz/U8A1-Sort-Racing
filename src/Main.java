import javax.swing.SwingUtilities;

public class Main {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            View v = new View(); 
            Model m = new Model();
            new Controller(m, v);
        });
    }
}
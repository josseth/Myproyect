
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.border.*;

public class Pral extends JFrame implements ActionListener{
    String nombre;
    static Userss thisarr[];
    JButton btnIni,btndep,btnret,btnReportes;
    ImageIcon iconoEFondo;
    private JMenuBar mb;
    private JMenu menuu,menu1,menu2,menu3,menu4,menu5;
    private JMenuItem mei1,mei2,mei3,mei4,mei5,mei6;
    public boolean estado;
    public Pral(Userss arr[],String name,boolean estadoini){
        super("Formulario Principal de Seleccion");
        this.nombre=name;
        this.thisarr=arr;
        this.estado=estadoini;
        //iconoEFondo=setImag("fondo.jpg",700,400);
        
        mb=new JMenuBar();
        setJMenuBar(mb);
        
        menuu=new JMenu(nombre);
        menuu.setHorizontalTextPosition(SwingConstants.CENTER);
        menuu.setVerticalTextPosition(SwingConstants.BOTTOM);
        mb.add(menuu);
        menu1=new JMenu("INFO VEICULO");
        menu1.setHorizontalTextPosition(SwingConstants.CENTER);
        menu1.setVerticalTextPosition(SwingConstants.BOTTOM);
        mb.add(menu1);
            mei1=new JMenuItem("Llenar informacion del veiculo");
            menu1.add(mei1);
            mei1.addActionListener(this);
        menu2=new JMenu("DIAGNOSTICO");
        menu2.setHorizontalTextPosition(SwingConstants.CENTER);
        menu2.setVerticalTextPosition(SwingConstants.BOTTOM);
        mb.add(menu2);
            mei2=new JMenuItem("Hacer Diagnostico");
            menu2.add(mei2);
            mei2.addActionListener(this);
        menu3=new JMenu("REPORTES");
        menu3.setHorizontalTextPosition(SwingConstants.CENTER);
        menu3.setVerticalTextPosition(SwingConstants.BOTTOM);
        mb.add(menu3);
            mei3=new JMenuItem("Mostrar reporte");
            menu3.add(mei3);
            mei3.addActionListener(this);
        menu4=new JMenu("CONTROL USUARIO");
        menu4.setHorizontalTextPosition(SwingConstants.CENTER);
        menu4.setVerticalTextPosition(SwingConstants.BOTTOM);
        mb.add(menu4);
            mei4=new JMenuItem("Agg/Ver Usuarios");
            menu4.add(mei4);
            mei4.addActionListener(this);
        menu5=new JMenu("SALIR");
        menu5.setHorizontalTextPosition(SwingConstants.CENTER);
        menu5.setVerticalTextPosition(SwingConstants.BOTTOM);
        mb.add(menu5);
            mei5=new JMenuItem("Salir al Login");
            menu5.add(mei5);
            mei5.addActionListener(this);
            mei6=new JMenuItem("Salir Del Sistema");
            menu5.add(mei6);
            mei6.addActionListener(this);
        
        setFrame ();
        setUndecorated(true);
        setVisible(true);
        setSize(700,400);
        setLocationRelativeTo (null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    public ImageIcon setImag(String names,int ancho,int alto){
        ImageIcon im = new javax.swing.ImageIcon(getClass().getResource("/IMG/"+names));
        Image ims = im.getImage();
        ImageIcon resultado = new ImageIcon (ims.getScaledInstance(ancho,alto,Image.SCALE_SMOOTH));
        return resultado;
    }
    public void setFrame(){
        getContentPane().setLayout(null);
        getContentPane ().setBackground (new Color(102,178,255));

        JLabel fond=new JLabel("AUTOS");
        fond.setBounds (350,-310,1280,720);
        fond.setFont(new Font("Courier New", Font.BOLD, 30));
        getContentPane ().add(fond);
        
    } 
    public void actionPerformed(ActionEvent e){
                if(e.getSource()==mei6){this.dispose(); System.exit(0);}
                if(e.getSource()==mei1){new Ingreso();}
                if(e.getSource()==mei4){new Cont_user( nombre);}
                if(e.getSource()==mei2){new Diag();}
                if(e.getSource()==mei3){new ReportesV();}
 	}
}

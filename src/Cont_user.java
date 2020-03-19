
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

public class Cont_user extends JFrame implements ActionListener {
    JTextField txtnom;
    JTextField txtpassword;
    JButton btnGuardar;
    JTextArea down;
    Userss users[];
    String noms;
    public Cont_user(String nom){ 
        super("Agregar y Ver Empleados");
        users=new Userss[0];
        this.noms=nom;
        setframe();
        setSize(420,400);//tamaño de el Jframe 
        setVisible(true);//si estara visible el frame
        setLocationRelativeTo(null);//centrar la posicionde la ventana
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        this.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent evt ) {
                Pral.thisarr=users;
            }
         } );
    }
     void llenarArr(String r){
            Archivo a=new Archivo(r);//sacar archivo
            String cadena=a.toString();//convertir a string
                String encont="";
                String ar[]=cadena.split("\n");
                for(int i=0;i<ar.length;i++)
                {
                    encont=ar[i];
                    String emp1[]=encont.split(";");
                       redefinir();
                       users[users.length-1]=new Userss(emp1[0],emp1[1]);
                }
    }
     public void redefinir(){
            Userss empaux[]=new Userss[users.length+1];
            for(int i=0;i<users.length;i++)
            {
                empaux[i]=users[i];
            }
            users=empaux;
        }
    void setframe(){
        getContentPane().setLayout(null);//
        getContentPane().setBackground(new Color(212, 230, 241));
        
        JLabel label2=new JLabel("Nombre");
        label2.setBounds(50,20,120,20);//x,y,ancho,alto
        getContentPane().add(label2);

        txtnom=new JTextField();
        txtnom.setBounds(120,20,220,20);
        getContentPane().add(txtnom);

        JLabel label3=new JLabel("Contraseña");
        label3.setBounds(50,60,120,20);//x,y,ancho,alto
        getContentPane().add(label3);

        txtpassword=new JTextField();
        txtpassword.setBounds(120,60,220,20);
        getContentPane().add(txtpassword);
        txtpassword.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        btnGuardar.doClick();
                    }
                }
            });
        
        btnGuardar=new JButton("Guardar");
        btnGuardar.setBounds(50,90,290,35);//x,y,ancho,alto
        btnGuardar.setForeground(Color.white);
        btnGuardar.setBackground(new Color(30,74,114));
        getContentPane().add(btnGuardar);
        btnGuardar.addActionListener(this);
        
        JLabel lab2=new JLabel("VER TODOS");
        lab2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); 
        lab2.setBounds(160,130,150,20);
        getContentPane().add(lab2);
        
        down=new JTextArea();
        down.setBounds(20,150,365,190);
        down.setFont(new java.awt.Font("Arial", Font.BOLD, 13)); 
        down.setForeground(Color.black);
        getContentPane().add(down);
        
        JScrollPane scr2=new JScrollPane(down);
        scr2.setBounds(20,150,365,190);
        getContentPane().add(scr2);
        
        down.setText("NOMBRE "+"CONTRASEÑA\n"+ver());
    }
    
    void limpiar(){
        txtpassword.setText("");
        txtnom.setText("");
    }
    void inicializarborrarC(){
            users=new Userss[0];
    }
    void saveUser(){
        llenarArr("src/usuarios.txt");
      redefinir();//redefinir para agrandar el arreglo 
      users[users.length-1]=new Userss(txtnom.getText(),txtpassword.getText());//en el arreglo agregar un empleado de tipo sistema y guardarlo en la ultima posicion
      down.setText("");limpiar();mensaje("Usuario Guardado");//borra los txt y mostrar mensaje de guardado
      svAr(users[users.length-1].toString());
    }
    public void svAr(String emp){
        Archivo a=new Archivo("src/usuarios.txt");
            try{a.guardarstring(emp);
            }catch(Exception exp){System.out.println(exp);}
        }
    String ver(){
        llenarArr("src/usuarios.txt");
        String cadena="";
        for(int i=0;i<users.length;i++){
            cadena+=users[i].toString()+"\n";
        }
        return cadena;
    }
    void mensaje(String msj){javax.swing.JOptionPane.showMessageDialog(null,msj);}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnGuardar){ saveUser(); 
        inicializarborrarC();down.setText("NOMBRE "+"CONTRASEÑA\n"+ver());}
        }
    }




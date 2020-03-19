
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
    ImageIcon iconoEscaladof,iconoEscaladof2,iconoEscaladof3;
    JButton entrar,salir;
    JTextField user;
    JPasswordField password;
    static Userss users[];
    boolean estado;
    public Login(Userss arr[]){
        super("Inicio de Sesion");
        
        users=new Userss[0];
        
        iconoEscaladof=setImag("simple1.png",692,372);
        iconoEscaladof2=setImag("boton1.png",100,40);
        iconoEscaladof3=setImag("boton2.png",100,40);
         
        setFrame();
        setUndecorated(true);//quitar los bordes de la ventana
        setBackground(new Color(1.0f,1.0f,1.0f,0.0f));//para poner el frame transparente
        setSize(692,372);//tamaño de el Jframe 
        setVisible(true);//si estara visible el frame
        setLocationRelativeTo(null);//centrar la posicionde la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);//al dar salir cerrar
        setResizable(false);//no aumentar ventana
    }
    public ImageIcon setImag(String names,int ancho,int alto){
        ImageIcon im = new javax.swing.ImageIcon(getClass().getResource("/IMG/"+names));
        Image ims = im.getImage();
        ImageIcon resultado = new ImageIcon (ims.getScaledInstance(ancho,alto,Image.SCALE_SMOOTH));
        return resultado;
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
    void setFrame(){
        getContentPane().setLayout(null);
        
         user=new JTextField();
         user.setBounds(260,145,380,54);
         user.setForeground(Color.white);
         user.setFont(new Font("Arial", Font.BOLD, 20));
         user.setBackground(new Color(0,59,110));
         getContentPane().add(user);
        
         password=new JPasswordField();
         password.setBounds(260,230,380,54);
         password.setFont(new Font("Arial", Font.BOLD, 25));
         password.setForeground(Color.white);
         password.setBackground(new Color(0,59,110));
         getContentPane().add(password);
         password.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        comprobacion();
                    }
                }
            });
        
         entrar=new JButton();
         entrar.setBounds(260,310,100,40);
         entrar.setBackground(new Color(0,0,0,0));
         entrar.setBorder(null);
         entrar.setIcon(iconoEscaladof2);
         getContentPane().add(entrar);
         entrar.addActionListener(this);
         
         salir=new JButton();
         salir.setBounds(370,310,100,40);
         salir.setBackground(new Color(0,0,0,0));
         salir.setBorder(null);
         salir.setIcon(iconoEscaladof3);
         getContentPane().add(salir);
         salir.addActionListener(this);
         
         JLabel image=new JLabel();
        image.setBounds(0,0,692,372);
        image.setIcon(iconoEscaladof);
        getContentPane().add(image);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==entrar){comprobacion();}
        if(e.getSource()==salir){System.exit(0); this.dispose();}
    }
    void mensaje(String msj){javax.swing.JOptionPane.showMessageDialog(null,msj);}
    void comprobacion(){
        /*llenarArr("src/usuarios.txt");
            if(password.getText().isEmpty() || user.getText().isEmpty()){
                    mensaje("Error Usuario y contraseña");
                    password.requestFocus(); 
            }else{
                for(int i=0;i<users.length;i++){
                    if(users[i].nom.equals(user.getText()) && users[i].pass.equals(password.getText())){estado=true;break;}//fallo porque no, se queda el estado en true sino que sigue al else, por eso el BREAK
                    else{estado=false;} 
                } }
            if(estado){       
                     this.dispose();
                     new Pral(users,user.getText(),false);
            }else{
                     password.setText("");
                     estado=true; }*/
            new Pral(users,"beta",false);
        }
    public static  void main(String args[]){ 
        new Login(users); }
}



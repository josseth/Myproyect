
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import javax.swing.border.Border;

public class Ingreso extends JFrame implements ActionListener {
    JTextField cod,decs,cant;
    JComboBox tipo;
    JLabel lcod,ldec,lprecio,lcant;
    JTextArea txtdecs;
    Border loweredbevel;
    JButton btnnuevo,btnsave,btncancelar,btnsalir;
    Auto aut[];
    private Userss arr[];
    private String name;
    public Ingreso(){
        super("Agregar info de auto");
        aut=new Auto[0];
        loweredbevel = BorderFactory.createEmptyBorder();
        
        setFrame();
        getContentPane().setBackground(new Color(102,102,255));
        setSize(692,372);//tamaño de el Jframe 
        setVisible(true);//si estara visible el frame
        setLocationRelativeTo(null);//centrar la posicionde la ventana
        setDefaultCloseOperation(HIDE_ON_CLOSE);//al dar salir esconder
        
        if(btnnuevo.isEnabled()){//verficar al inicio si el boton nuevo esta habilitado
            btnsave.setVisible(false);
            btncancelar.setEnabled(false);
            cod.setEnabled(false);
            decs.setEnabled(false);
            tipo.setEnabled(false);
            cant.setEnabled(false);
        }
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
                       if(tipo.getSelectedIndex()==0){aut[aut.length-1]=new Camion(emp1[0],emp1[1],emp1[2],emp1[3],emp1[4]);}
                       if(tipo.getSelectedIndex()==1){aut[aut.length-1]=new Bus(emp1[0],emp1[1],emp1[2],emp1[3],emp1[4]);}
                       if(tipo.getSelectedIndex()==2){aut[aut.length-1]=new Turismo(emp1[0],emp1[1],emp1[2],emp1[3],emp1[4]);}
                       if(tipo.getSelectedIndex()==3){aut[aut.length-1]=new Motocicleta(emp1[0],emp1[1],emp1[2],emp1[3],emp1[4]);}
                       
                }
    }
     public void redefinir(){
            Auto empaux[]=new Auto[aut.length+1];
            for(int i=0;i<aut.length;i++)
            {
                empaux[i]=aut[i];
            }
            aut=empaux;
        }
     void inicializarborrarC(){
            aut=new Auto[0];
    }
    void limpiar(){
        cod.setText("");
        tipo.setSelectedIndex(0);
        cant.setText("");
        decs.setText("");
    }
    void saveAlm(){
      //llenarArr("src/autos.txt");
      redefinir();//redefinir para agrandar el arreglo 
     // JOptionPane.showMessageDialog(null," "+alm.length+" "+cod.getText()+desc.getText());
                       if(tipo.getSelectedIndex()==0){aut[aut.length-1]=new Camion(decs.getText(),cant.getText(),"",cod.getText(),tipo.getSelectedItem().toString());}
                       if(tipo.getSelectedIndex()==1){aut[aut.length-1]=new Bus(decs.getText(),cant.getText(),"",cod.getText(),tipo.getSelectedItem().toString());}
                       if(tipo.getSelectedIndex()==2){aut[aut.length-1]=new Turismo(decs.getText(),cant.getText(),"",cod.getText(),tipo.getSelectedItem().toString());}
                       if(tipo.getSelectedIndex()==3){aut[aut.length-1]=new Motocicleta(decs.getText(),cant.getText(),"",cod.getText(),tipo.getSelectedItem().toString());}
      limpiar();
      JOptionPane.showMessageDialog(null,"AUTO Guardado");//borra los txt y mostrar mensaje de guardado
      svAr(aut[aut.length-1].toString());
    }
    public void svAr(String emp){
            Archivo a=new Archivo("src/autos.txt");
            try{a.guardarstring(emp);
            }catch(Exception exp){System.out.println(exp);}
        }
    public void setFrame(){
        getContentPane().setLayout(null);
        
        lcod=new JLabel("Placa:");
        lcod.setBounds(40,13,90,25);
        lcod.setFont(new Font("Helvetica", Font.BOLD, 15));
        lcod.setForeground(Color.black);
        getContentPane().add(lcod);
                
        cod=new JTextField();
        cod.setBounds(120,13,150,25);
        cod.setForeground(Color.white);
        cod.setFont(new Font("Arial", Font.BOLD, 20));
        cod.setBackground(new Color(0,59,110));
        getContentPane().add(cod);
        cod.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char car = evt.getKeyChar();
                //if((car<'0' || car>'9')) evt.consume();//verificar qe solo se ingresen numeros
                if(cod.getText().length()==7){//verificar que solo se ingresen la cantidad de 4 numeros
                    evt.consume();
                }
            }
        });
        
        ldec=new JLabel("Dueño:");
        ldec.setBounds(30,70,100,25);
        ldec.setFont(new Font("Helvetica", Font.BOLD, 15));
        ldec.setForeground(Color.black);
        getContentPane().add(ldec);
        
        decs= new JTextField();
        decs.setBounds(90,70,200,25);
        decs.setForeground(Color.white);
        decs.setBackground(new Color(0,59,110));
        decs.setFont(new Font("Arial", Font.BOLD, 20));
        getContentPane().add(decs);
        
        lcant=new JLabel("Color:");
        lcant.setBounds(450,13,90,25);
        lcant.setFont(new Font("Helvetica", Font.BOLD, 15));
        lcant.setForeground(Color.black);
        getContentPane().add(lcant);
                
        cant=new JTextField();
        cant.setBounds(500,13,150,25);
        cant.setForeground(Color.white);
        cant.setFont(new Font("Arial", Font.BOLD, 20));
        cant.setBackground(new Color(0,59,110));
        getContentPane().add(cant);
        cant.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                if(cant.getText().length()==20){
                    evt.consume();
                }
            }
        });
        
        lprecio=new JLabel("Tipo:");
        lprecio.setBounds(450,42,90,25);
        lprecio.setFont(new Font("Helvetica", Font.BOLD, 15));
        lprecio.setForeground(Color.black);
        getContentPane().add(lprecio);
                
        tipo=new JComboBox();
        tipo.setBounds(500,42,150,25);
        tipo.setForeground(Color.white);
        tipo.setFont(new Font("Arial", Font.BOLD, 20));
        tipo.setBackground(new Color(0,59,110));
        getContentPane().add(tipo);
        tipo.addItem("Camion");
        tipo.addItem("Bus");
        tipo.addItem("Turismo");
        tipo.addItem("Motocicleta");
        
        btnnuevo=new JButton("Nuevo Producto");
        btnnuevo.setBounds(500,110,170,35);//x,y,ancho,alto
        btnnuevo.setForeground(Color.white);
        btnnuevo.setBorder(null);
        btnnuevo.setBackground(new Color(30,74,114));
        getContentPane().add(btnnuevo);
        btnnuevo.addActionListener(this);
        
        btnsave=new JButton("GUARDAR");
        btnsave.setBounds(500,110,170,35);//x,y,ancho,alto
        btnsave.setForeground(Color.white);
        btnsave.setBorder(null);//sin bordes en los botones
        btnsave.setBackground(new Color(30,74,114));
        getContentPane().add(btnsave);
        btnsave.addActionListener(this);
        
        btncancelar=new JButton("Cancelar");
        btncancelar.setBounds(500,149,170,35);//x,y,ancho,alto
        btncancelar.setForeground(Color.white);
        btncancelar.setBorder(null);
        btncancelar.setBackground(new Color(30,74,114));
        getContentPane().add(btncancelar);
        btncancelar.addActionListener(this);
        
        btnsalir=new JButton("Salir");
        btnsalir.setBounds(500,209,170,35);//x,y,ancho,alto
        btnsalir.setForeground(Color.white);
        btnsalir.setBorder(null);
        btnsalir.setBackground(new Color(30,74,114));
        getContentPane().add(btnsalir);
        btnsalir.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnsalir){this.hide(); this.dispose();}
        if(e.getSource()==btnnuevo){
            btnnuevo.setVisible(false); 
            btnsave.setVisible(true);
            cod.setEnabled(true);
            decs.setEnabled(true);
            tipo.setEnabled(true);
            cant.setEnabled(true);
            btncancelar.setEnabled(true);
        }
        if(e.getSource()==btnsave){
            saveAlm(); 
            //inicializarborrarC();
            btnnuevo.setVisible(true); 
            btnsave.setVisible(false);
            cod.setEnabled(false);
            decs.setEnabled(false);
            tipo.setEnabled(false);
            cant.setEnabled(false);
            btncancelar.setEnabled(false);
            //this.hide();
            new Pral(arr,name,true);
        }
        if(e.getSource()==btncancelar){
            cod.setText("");
            tipo.setSelectedIndex(0);
            cant.setText("");
        }
    }
    
}

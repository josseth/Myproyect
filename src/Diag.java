
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

public class Diag extends JFrame implements ActionListener {
    JTextField decs,pre,tiempo;
    JComboBox tipo,cod,cant;
    JLabel lcod,ldec,lprecio,lcant,lpre,ltie;
    JTextArea txtdecs;
    Border loweredbevel;
    JButton btnnuevo,btnsave,btncancelar,btnsalir;
    Auto aut[];
    Diagnosticos dgm[];
    RDiagnosticos rd[];
    private Userss arr[];
    private String name;
    public Diag(){
        super("Agregar info de auto");
        aut=new Auto[0];
        dgm=new Diagnosticos[0];
        rd=new RDiagnosticos[0];
        loweredbevel = BorderFactory.createEmptyBorder();
        
        setFrame();
        getContentPane().setBackground(new Color(102,102,255));
        setSize(692,372);//tamaño de el Jframe 
        setVisible(true);//si estara visible el frame
        setLocationRelativeTo(null);//centrar la posicionde la ventana
        setDefaultCloseOperation(HIDE_ON_CLOSE);//al dar salir esconder
        
        if(btnnuevo.isEnabled()){//verficar al inicio si el boton nuevo esta habilitado
            btnsave.setVisible(false);
            cod.setEnabled(false);
            decs.setEnabled(false);
            tipo.setEnabled(false);
            cant.setEnabled(false);
            tiempo.setEnabled(false);
            pre.setEnabled(false);
        }
    }
    public static void main(String args[]){
        new Diag();
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
    public void redefinirrd(){
            RDiagnosticos empaux[]=new RDiagnosticos[rd.length+1];
            for(int i=0;i<rd.length;i++)
            {
                empaux[i]=rd[i];
            }
            rd=empaux;
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
        cod.setSelectedIndex(0);
        tipo.setSelectedIndex(0);
        cant.setSelectedIndex(0);
        decs.setText("");
    }
    void saveAlm(){
      //llenarArr("src/autos.txt");
      redefinirrd();//redefinir para agrandar el arreglo 
     // JOptionPane.showMessageDialog(null," "+alm.length+" "+cod.getText()+desc.getText());
           /*if(tipo.getSelectedIndex()==0){aut[aut.length-1]=new Camion(decs.getText(),cant.getText(),"",cod.getSelectedItem().toString(),tipo.getSelectedItem().toString());}
           if(tipo.getSelectedIndex()==1){aut[aut.length-1]=new Bus(decs.getText(),cant.getText(),"",cod.getText(),tipo.getSelectedItem().toString());}
           if(tipo.getSelectedIndex()==2){aut[aut.length-1]=new Turismo(decs.getText(),cant.getText(),"",cod.getText(),tipo.getSelectedItem().toString());}*/
       rd[rd.length-1]=new RDiagnosticos(cod.getSelectedItem().toString(),decs.getText(),cant.getSelectedItem().toString(),pre.getText(),tiempo.getText(),tipo.getSelectedItem().toString());
      
       limpiar();
      JOptionPane.showMessageDialog(null,"AUTO diagnosticado Guardado");//borra los txt y mostrar mensaje de guardado
      svArD(rd[rd.length-1].toString());
    }
    public void svArD(String emp){
                Archivo a=new Archivo("src/RAuto.txt");
            try{a.guardarstring(emp);
            }catch(Exception exp){System.out.println(exp);}
        }
    public void svAr(String emp){
            Archivo a=new Archivo("src/autos.txt");
            try{a.guardarstring(emp);
            }catch(Exception exp){System.out.println(exp);}
        }
    void llenarD(String r){
            Archivo a=new Archivo(r);//sacar archivo
            String cadena=a.toString();//convertir a string
                String encont="";
                String ar[]=cadena.split("\n");
                for(int i=0;i<ar.length;i++)
                {
                    encont=ar[i];
                    String emp1[]=encont.split(";");
                       redefinir2();
                       dgm[dgm.length-1]=new Diagnosticos(emp1[0],emp1[1],emp1[2],emp1[3]);
                }
    }
    void llenarA(String r){
            Archivo a=new Archivo(r);//sacar archivo
            String cadena=a.toString();//convertir a string
                String encont="";
                String ar[]=cadena.split("\n");
                for(int i=0;i<ar.length;i++)
                {
                    encont=ar[i];
                    String emp1[]=encont.split(";");
                       redefinir();
                       if(emp1[4].contains("Camion")){aut[aut.length-1]=new Camion(emp1[0],emp1[1],emp1[2],emp1[3],emp1[4]);}
                       if(emp1[4].contains("Bus")){aut[aut.length-1]=new Bus(emp1[0],emp1[1],emp1[2],emp1[3],emp1[4]);}
                       if(emp1[4].contains("Turismo")){aut[aut.length-1]=new Turismo(emp1[0],emp1[1],emp1[2],emp1[3],emp1[4]);}
                       if(emp1[4].contains("Motocicleta")){aut[aut.length-1]=new Motocicleta(emp1[0],emp1[1],emp1[2],emp1[3],emp1[4]);}
                }
    }
    public void redefinir2(){
            Diagnosticos empaux[]=new Diagnosticos[dgm.length+1];
            for(int i=0;i<dgm.length;i++)
            {
                empaux[i]=dgm[i];
            }
            dgm=empaux;
        }
    public void setFrame(){
        getContentPane().setLayout(null);
        
        lcod=new JLabel("Auto:");
        lcod.setBounds(20,13,90,25);
        lcod.setFont(new Font("Helvetica", Font.BOLD, 15));
        lcod.setForeground(Color.black);
        getContentPane().add(lcod);
                
        
        ldec=new JLabel("Dueño:");
        ldec.setBounds(400,13,90,25);
        ldec.setFont(new Font("Helvetica", Font.BOLD, 15));
        ldec.setForeground(Color.black);
        getContentPane().add(ldec);
        
        decs= new JTextField();
        decs.setBounds(455,13,195,25);
        decs.setForeground(Color.white);
        decs.setBackground(new Color(0,59,110));
        decs.setFont(new Font("Arial", Font.BOLD, 20));
        getContentPane().add(decs);
        
        cod=new JComboBox();
        cod.setBounds(80,13,150,25);
        cod.setForeground(Color.white);
        cod.setFont(new Font("Arial", Font.BOLD, 20));
        cod.setBackground(new Color(0,59,110));
        getContentPane().add(cod);
        cod.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                llenarA("src/autos.txt");
                for(int i=0;i<aut.length;i++){
                    if(cod.getSelectedItem().equals(aut[i].nplaca)){
                        decs.setText(aut[i].propietario);
                    }
                }
            }
        });
        llenarplacas();
        
        lpre=new JLabel("Precio:");
        lpre.setBounds(400,70,100,25);
        lpre.setFont(new Font("Helvetica", Font.BOLD, 15));
        lpre.setForeground(Color.black);
        getContentPane().add(lpre);
                
        pre=new JTextField();
        pre.setBounds(455,70,200,25);
        pre.setForeground(Color.white);
        pre.setFont(new Font("Arial", Font.BOLD, 20));
        pre.setBackground(new Color(0,59,110));
        getContentPane().add(pre);
        
        lcant=new JLabel("Diagnostico:");
        lcant.setBounds(20,70,100,25);
        lcant.setFont(new Font("Helvetica", Font.BOLD, 15));
        lcant.setForeground(Color.black);
        getContentPane().add(lcant);
         
        
        ltie=new JLabel("Tiempo:");
        ltie.setBounds(20,100,100,25);
        ltie.setFont(new Font("Helvetica", Font.BOLD, 15));
        ltie.setForeground(Color.black);
        getContentPane().add(ltie);
                
        tiempo=new JTextField();
        tiempo.setBounds(120,100,200,25);
        tiempo.setForeground(Color.white);
        tiempo.setFont(new Font("Arial", Font.BOLD, 20));
        tiempo.setBackground(new Color(0,59,110));
        getContentPane().add(tiempo);
        
        lprecio=new JLabel("Estado:");
        lprecio.setBounds(440,42,90,25);
        lprecio.setFont(new Font("Helvetica", Font.BOLD, 15));
        lprecio.setForeground(Color.black);
        getContentPane().add(lprecio);
                
        tipo=new JComboBox();
        tipo.setBounds(500,42,150,25);
        tipo.setForeground(Color.white);
        tipo.setFont(new Font("Arial", Font.BOLD, 20));
        tipo.setBackground(new Color(0,59,110));
        getContentPane().add(tipo);
        tipo.addItem("Diagnostico");
        tipo.addItem("Espera");
        tipo.addItem("Entregado");
        
               
        cant=new JComboBox();
        cant.setBounds(120,70,200,25);
        cant.setForeground(Color.white);
        cant.setFont(new Font("Arial", Font.BOLD, 20));
        cant.setBackground(new Color(0,59,110));
        getContentPane().add(cant);
        cant.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                llenarD("src/diagnosticos.txt");
                for(int i=0;i<dgm.length;i++){
                    if(cant.getSelectedItem().equals(dgm[i].nomdiag)){
                        tiempo.setText(dgm[i].tiempo);
                        pre.setText(dgm[i].precio);
                    }
                }
            }
        });
        llenardiag();
        
        btnnuevo=new JButton("Efectuar Diagnostico");
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
        
        /*btncancelar=new JButton("Cancelar");
        btncancelar.setBounds(500,149,170,35);//x,y,ancho,alto
        btncancelar.setForeground(Color.white);
        btncancelar.setBorder(null);
        btncancelar.setBackground(new Color(30,74,114));
        getContentPane().add(btncancelar);
        btncancelar.addActionListener(this);*/
        
        btnsalir=new JButton("Salir");
        btnsalir.setBounds(500,209,170,35);//x,y,ancho,alto
        btnsalir.setForeground(Color.white);
        btnsalir.setBorder(null);
        btnsalir.setBackground(new Color(30,74,114));
        getContentPane().add(btnsalir);
        btnsalir.addActionListener(this);
    }
    void llenardiag(){
        Archivo a=new Archivo("src/diagnosticos.txt");//sacar archivo
        String cadena=a.toString();//convertir a string
        String encont="";
        String ar[]=cadena.split("\n");
        for(int i=0;i<ar.length;i++)
        {
            encont=ar[i];
            String emp1[]=encont.split(";");
            cant.addItem(emp1[0]);
        }
    }
    void llenarplacas(){
        Archivo a=new Archivo("src/autos.txt");//sacar archivo
        String cadena=a.toString();//convertir a string
        String encont="";
        String ar[]=cadena.split("\n");
        for(int i=0;i<ar.length;i++)
        {
            encont=ar[i];
            String emp1[]=encont.split(";");
            cod.addItem(emp1[3]);
        }
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
            tiempo.setEnabled(true);
            pre.setEnabled(true);
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
            //this.hide();
            new Pral(arr,name,true);
        }
    }
    
}

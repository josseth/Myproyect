import java.awt.*;
import javax.swing.*;

public class ReportesV extends JFrame
{
    JTextArea a0,a1,a2,a3,a4;
    RDiagnosticos rd[];
    Auto aut[];
    public ReportesV()
    {
        rd=new RDiagnosticos[0];
        aut=new Auto[0];
         //Parametros asociados a la ventana
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //setExtendedState(MAXIMIZED_BOTH);
         setSize(400,600);
         setVisible(true);
         setTitle("Ejemplo JTabbedPane");
         setLocationRelativeTo(null);//centrar la posicionde la ventana
         setDefaultCloseOperation(HIDE_ON_CLOSE);//al dar salir esconder
         //Creamos el conjunto de pestañas
         
         //getContentPane().setLayout(null);
         JTabbedPane pestanias=new JTabbedPane();

         //Creamos el panel y lo añadimos a las pestañas
         JPanel panel1=new JPanel();

         //Componentes del panel1
         panel1.setBackground(Color.CYAN);
         a0=new JTextArea("hola");
        a0.setBounds(0,30,365,300);
        a0.setFont(new java.awt.Font("Arial", Font.BOLD, 13)); 
        a0.setForeground(Color.black);
         panel1.add(a0);
         
         JScrollPane scr2=new JScrollPane(a0);
        scr2.setBounds(0,30,365,300);
        panel1.add(scr2);
        
         
         //Añadimos un nombre de la pestaña y el panel
         pestanias.addTab("Ingresos", panel1);

         //Realizamos lo mismo con el resto
         JPanel panel2=new JPanel();
         pestanias.addTab("Diagnosticos", panel2);

         //Componentes del panel2
         panel2.setBackground(Color.WHITE);
         a1=new JTextArea("hola");
        a1.setBounds(0,30,365,300);
        a1.setFont(new java.awt.Font("Arial", Font.BOLD, 13)); 
        a1.setForeground(Color.black);
         panel2.add(a1);
         
         JScrollPane scr3=new JScrollPane(a1);
        scr3.setBounds(0,30,365,300);
        panel2.add(scr3);

         JPanel panel3=new JPanel();

         //Componentes del panel3
         a2=new JTextArea("hola");
        a2.setBounds(0,30,365,300);
        a2.setFont(new java.awt.Font("Arial", Font.BOLD, 13)); 
        a2.setForeground(Color.black);
         panel3.add(a2);
         
         JScrollPane scr4=new JScrollPane(a2);
        scr4.setBounds(0,30,365,300);
        panel3.add(scr4);

         pestanias.addTab("Repacion", panel3);

         JPanel panel4=new JPanel();

         //Componentes del panel4
         a3=new JTextArea("hola");
        a3.setBounds(0,30,365,300);
        a3.setFont(new java.awt.Font("Arial", Font.BOLD, 13)); 
        a3.setForeground(Color.black);
         panel4.add(a2);
         
         JScrollPane scr5=new JScrollPane(a3);
        scr5.setBounds(0,30,365,300);
        panel4.add(scr5);

         pestanias.addTab("Entregados", panel4);
         
         getContentPane().add(pestanias);
         
        a1.setText(""+ver(0));
        a2.setText(""+ver(1));
        a3.setText(""+ver(2));
        a0.setText(""+veringreso());
    }
    void llenarArrr2(String r){
            Archivo a=new Archivo(r);//sacar archivo
            String cadena=a.toString();//convertir a string
                String encont="";
                String ar[]=cadena.split("\n");
                for(int i=0;i<ar.length;i++)
                {
                    encont=ar[i];
                    String emp1[]=encont.split(";");
                       redefinir1();
                       if(emp1[4].contains("Camion")){aut[aut.length-1]=new Camion(emp1[0],emp1[1],emp1[2],emp1[3],emp1[4]);}
                       if(emp1[4].contains("Bus")){aut[aut.length-1]=new Bus(emp1[0],emp1[1],emp1[2],emp1[3],emp1[4]);}
                       if(emp1[4].contains("Turismo")){aut[aut.length-1]=new Turismo(emp1[0],emp1[1],emp1[2],emp1[3],emp1[4]);}
                       if(emp1[4].contains("Motocicleta")){aut[aut.length-1]=new Motocicleta(emp1[0],emp1[1],emp1[2],emp1[3],emp1[4]);}
                }
    }
    void llenarArrr(String r){
            Archivo a=new Archivo(r);//sacar archivo
            String cadena=a.toString();//convertir a string
                String encont="";
                String ar[]=cadena.split("\n");
                for(int i=0;i<ar.length;i++)
                {
                    encont=ar[i];
                    String emp1[]=encont.split(";");
                       redefinir2();
                       rd[rd.length-1]=new RDiagnosticos(emp1[0],emp1[1],emp1[2],emp1[3],emp1[4],emp1[5]);
                }
                
    } public void redefinir1(){
            Auto empaux[]=new Auto[aut.length+1];
            for(int i=0;i<aut.length;i++)
            {
                empaux[i]=aut[i];
            }
            aut=empaux;
        }
    public void redefinir2(){
            RDiagnosticos empaux[]=new RDiagnosticos[rd.length+1];
            for(int i=0;i<rd.length;i++)
            {
                empaux[i]=rd[i];
            }
            rd=empaux;
        }
    String veringreso(){
        llenarArrr2("src/autos.txt");
        String cadena="";
        for(int i=0;i<aut.length;i++){
            cadena+=aut[i].toString()+"\n";
        }
        return cadena;
    }
    String ver(int estado){
        llenarArrr("src/RAuto.txt");
        String cadena="";
        for(int i=0;i<rd.length;i++){
            if(estado==0){if(rd[i].estado.equals("Diagnostico")){cadena+=rd[i].toString()+"\n";}}
            if(estado==1){if(rd[i].estado.equals("Espera")){cadena+=rd[i].toString()+"\n";}}
            if(estado==2){if(rd[i].estado.equals("Entregado")){cadena+=rd[i].toString()+"\n";}}
        }
        return cadena;
    }
}
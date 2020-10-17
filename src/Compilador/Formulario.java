package Compilador;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;

public class Formulario extends JFrame implements KeyListener,ActionListener
{
	JButton btnScan,btnPars,btnAbrir,btnGuardar,btnLimpia;
	JTextArea codigo,tok;
	JScrollPane sCod,sTok;
	
	DefaultTableModel modelo;
	String titulos[] ={"Tipo", "Valor"};
	JTable tabla;
	
	JFileChooser archivoSeleccionado;
	File archivo;
	Lexico lex;
	Sintactico sin;
	public Formulario()
	{
		Interfaz();
	}
	public void Interfaz()
	{
		setSize(500,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		
		archivoSeleccionado= new JFileChooser("Abrir");
		archivoSeleccionado.setDialogTitle("Abrir");
		archivoSeleccionado.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		modelo = new DefaultTableModel(null,titulos);//Modelo de la tabla
		tabla = new JTable(modelo);//Tabla de tokens
		sTok = new JScrollPane(tabla);//Scroll para la tabla de tokens
		
		btnAbrir = new JButton("Abrir");
		btnGuardar = new JButton("Guardar");
		btnLimpia = new JButton("Limpiar");
		btnScan = new JButton("Scan");
		btnPars = new JButton("Parser");
		codigo = new JTextArea();
		tok = new JTextArea();
		
		sCod = new JScrollPane(codigo);
		
		JLabel lblProg = new JLabel("Programa");
		JLabel lblTok = new JLabel("Tokens");
		
		
		
		//Boton.setBounds(x,y,largo,alto);
		btnAbrir.setBounds(10,10,70,20);//BotonAbrir
		btnGuardar.setBounds(90,10,80,20);//BotonGuardar
		btnLimpia.setBounds(180,10,80,20);//BotonLimpiar
		lblProg.setBounds(10,30,60,20);//Label Programa
		sCod.setBounds(10,50,260,200);//TextAreaCodigo
		btnScan.setBounds(40,260,70,30);//BotonScan
		lblTok.setBounds(10,290,60,20);//Label Tokens
		sTok.setBounds(10,310,260,240);//TextAreaTokens
		btnPars.setBounds(120,260,80,30);//BotonParser
		
		add(btnGuardar);
		add(btnAbrir);
		add(btnLimpia);
		add(lblProg);
		add(sCod);
		add(btnScan);
		add(sTok);
		add(lblTok);
		add(btnPars);
		
		Escuchadores();
		deshabilita();
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void deshabilita(){
		btnScan.setEnabled(false);
		btnPars.setEnabled(false);
		btnGuardar.setEnabled(false);
	}
	public void Escuchadores(){
		codigo.addKeyListener(this);
		
		btnAbrir.addActionListener(this);
		btnScan.addActionListener(this);
		btnPars.addActionListener(this);
		btnGuardar.addActionListener(this);
		btnLimpia.addActionListener(this);
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==btnAbrir)
		{
			if(archivoSeleccionado.showOpenDialog(this)==JFileChooser.CANCEL_OPTION)
				return;
			else
			{
				//System.out.print(archivo.getAbsolutePath());
				//new Analizador(archivo.getAbsolutePath()+"");
				//System.out.print(archivo.getName().toString());
				archivo=archivoSeleccionado.getSelectedFile();
				abrir();
				limpiarTabla();
				btnScan.setEnabled(true);
				btnGuardar.setEnabled(true);
				return;
			}
		}
		if(evt.getSource()==btnScan){
			limpiarTabla();
			lex = new Lexico(archivo.getAbsolutePath()+"");
			if(!lex.error)//Si no ocurre ningun error lexico llena la tabla
			{
				btnScan.setEnabled(false);
				llenarTabla();
				btnPars.setEnabled(true);
			}
			return;
		}
		if(evt.getSource()==btnGuardar){
			guardar();
			return;
		}
		if(evt.getSource()==btnPars){
			sin = new Sintactico(lex.PalabrasAnalizadas);
			return;
		}
		if(evt.getSource()==btnLimpia){
			btnGuardar.setEnabled(false);
			btnScan.setEnabled(false);
			btnPars.setEnabled(false);
			codigo.setText("");
			limpiarTabla();
			return;
		}
	}
	public boolean abrir() {
		String texto="",linea;
		try {
			FileReader fr = new FileReader(archivo) ; 
			BufferedReader br= new BufferedReader(fr);
			while((linea=br.readLine())!=null) 
				texto+=linea+"\n";
			codigo.setText(texto);//llena el TextArea de Codigo
			return true;
		}catch (Exception e) {
			archivo=null;
			JOptionPane.showMessageDialog(null, "El archivo no es de tipo texto", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
	public boolean guardar() {
		try {
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bf = new BufferedWriter(fw);
			bf.write(codigo.getText());
			bf.close();
			fw.close();
			JOptionPane.showMessageDialog(null, "Se ha guardado el archivo");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido modificar el archivo", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	public void llenarTabla(){
		for(int i = 0;i<lex.PalabrasAnalizadas.size();i++)
			modelo.insertRow(modelo.getRowCount(),new Object[]{lex.PalabrasAnalizadas.get(i).getTipo(),lex.PalabrasAnalizadas.get(i).getValor()});
	}
	public void limpiarTabla(){
		while (tabla.getRowCount()!=0){
			((DefaultTableModel)tabla.getModel()).removeRow(0);
		}
	}
	
	public void keyPressed(KeyEvent evt){//Presiona una tecla
	}
	public void keyReleased(KeyEvent evt){//Escrita
	}
	public void keyTyped(KeyEvent evt) {//suelta
		if(codigo.getText().length()!=0)
			btnScan.setEnabled(true);
		else
			btnScan.setEnabled(false);
		//btnPars.setEnabled(false);
	}
	
	public static void main(String[] args)
	{
		new Formulario();
	}
}
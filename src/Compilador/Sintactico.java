package Compilador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Sintactico {
	boolean ErrorS=false;
	int puntero;
	ArrayList<Token> TablaSimbolos = new ArrayList<Token>();
	public Sintactico(ArrayList<Token> PalabrasAnalizadas){
		puntero=0;
		analisisSintactico(PalabrasAnalizadas);
		if(ErrorS)
			JOptionPane.showMessageDialog(null, "Ocurrio Un Error Sintactico.", "Warning",JOptionPane.WARNING_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Exito");
	}
	public void analisisSintactico(ArrayList<Token> tokens){
		int cant=tokens.size();
		if(tokens.get(cant-1).getId()!=14)//Si el ultimo token no es } 
		{
			ErrorS=true;
			return;
		}
		while(puntero<cant){
			if(tokens.get(puntero).getId()==1){//clase
				if(puntero!=0 || tokens.get(puntero+1).getId()!=23)
				{
					ErrorS=true;
					break;
				}
				TablaSimbolos.add(new Token("Identificador",tokens.get(puntero+1).getValor(),0,23));//guarda clase
				puntero+=2;
				if(tokens.get(puntero).getId()!=13){
					ErrorS=true;
					break;
				}
				if(cuentaLlaves(tokens))
				{
					ErrorS=true;
					break;
				}
				puntero++;
				continue;
			}
			if(tokens.get(puntero).getId()==23){//Reasignar valor a una variable
				if(!verificaVariable(tokens.get(puntero).getValor())){
					ErrorS=true;
					break;
				}
				if(tokens.get(puntero+1).getId()!=10){
					ErrorS=true;
					break;
				}
				puntero++;
				//-------------------------------
				if(tokens.get(puntero+1).getId()!=23 && tokens.get(puntero+1).getId()!=18)
				{
					ErrorS=true;
					break;
				}
				puntero++;
				while(tokens.get(puntero).getId()!=9)
				{
					if(tokens.get(puntero).getId()==23){//Es identificador?
						if(!verificaVariable(tokens.get(puntero).getValor()))//No existe el identificador
						{
							ErrorS=true;
							break;
						}
					}
					if(tokens.get(puntero).getId()==19 || tokens.get(puntero).getId()==20 || tokens.get(puntero).getId()==21 || tokens.get(puntero).getId()==22)
					{
						if(tokens.get(puntero+1).getId()==19 || tokens.get(puntero+1).getId()==20 || tokens.get(puntero+1).getId()==21 || tokens.get(puntero+1).getId()==22 || tokens.get(puntero+1).getId()==9)
						{
							ErrorS=true;
							break;
						}
					}
					if(tokens.get(puntero+1).getId()!=19 && tokens.get(puntero+1).getId()!=20 && tokens.get(puntero+1).getId()!=21 && tokens.get(puntero+1).getId()!=22 && tokens.get(puntero+1).getId()!=23 && tokens.get(puntero+1).getId()!=18 && tokens.get(puntero+1).getId()!=9)
					{
						ErrorS=true;
						break;
					}
					puntero++;
				}
				if(ErrorS)
					break;
				puntero++;
				//-------------------------------
			}
			if(tokens.get(puntero).getId()==2 || tokens.get(puntero).getId()==3 || tokens.get(puntero).getId()==4){//tipo de dato
				if(tokens.get(puntero+1).getId()!=23)
				{
					ErrorS=true;
					break;
				}
				int puntAux=puntero;//guarda puntero de la variable
				puntero++;
				if(tokens.get(puntero+1).getId()!=9 && tokens.get(puntero+1).getId()!=10)
				{
					ErrorS=true;
					break;
				}
				puntero++;
				if(tokens.get(puntero).getId()==10){//variable inicializada
					if(tokens.get(puntero+1).getId()!=23 && tokens.get(puntero+1).getId()!=18)
					{
						ErrorS=true;
						break;
					}
					puntero++;
					while(tokens.get(puntero).getId()!=9)
					{
						if(tokens.get(puntero).getId()==23){//Es identificador?
							if(!verificaVariable(tokens.get(puntero).getValor()))//No existe el identificador
							{
								ErrorS=true;
								break;
							}
						}
						if(tokens.get(puntero).getId()==19 || tokens.get(puntero).getId()==20 || tokens.get(puntero).getId()==21 || tokens.get(puntero).getId()==22)
						{
							if(tokens.get(puntero+1).getId()==19 || tokens.get(puntero+1).getId()==20 || tokens.get(puntero+1).getId()==21 || tokens.get(puntero+1).getId()==22 || tokens.get(puntero+1).getId()==9)
							{
								ErrorS=true;
								break;
							}
						}
						if(tokens.get(puntero+1).getId()!=19 && tokens.get(puntero+1).getId()!=20 && tokens.get(puntero+1).getId()!=21 && tokens.get(puntero+1).getId()!=22 && tokens.get(puntero+1).getId()!=23 && tokens.get(puntero+1).getId()!=18 && tokens.get(puntero+1).getId()!=9)
						{
							ErrorS=true;
							break;
						}
						puntero++;
					}
					if(ErrorS)
						break;
				}
				
				if(verificaVariable(tokens.get(puntAux+1).getValor())){
					ErrorS=true;
					break;
				}
				TablaSimbolos.add(new Token("Identificador",tokens.get(puntAux+1).getValor(),0,tokens.get(puntAux).getId()));//Agrega variable
				puntero++;
				continue;
			}
			if(tokens.get(puntero).getId()==5){//if
				if(tokens.get(puntero+1).getId()!=11)
				{
					ErrorS=true;
					break;
				}
				if(cuentaParentesis(tokens)){
					ErrorS=true;
					break;
				}
				puntero++;
				if(tokens.get(puntero+1).getId()!=18 && tokens.get(puntero+1).getId()!=23){
					ErrorS=true;
					break;
				}
				if(tokens.get(puntero+1).getId()==23){
					if(!verificaVariable(tokens.get(puntero+1).getValor())){
						ErrorS=true;
						break;
					}
				}
				puntero++;
				if(tokens.get(puntero+1).getId()!=15 && tokens.get(puntero+1).getId()!=16 && tokens.get(puntero+1).getId()!=17){
					ErrorS=true;
					break;
				}
				puntero++;
				if(tokens.get(puntero+1).getId()!=18 && tokens.get(puntero+1).getId()!=23){
					ErrorS=true;
					break;
				}
				if(tokens.get(puntero+1).getId()==23){
					if(!verificaVariable(tokens.get(puntero+1).getValor())){
						ErrorS=true;
						break;
					}
				}
				puntero++;
				if(tokens.get(puntero+1).getId()!=12){
					ErrorS=true;
					break;
				}
				puntero+=2;
				if(tokens.get(puntero).getId()!=13){
					ErrorS=true;
					break;
				}
				if(cuentaLlaves(tokens)){
					ErrorS=true;
					break;
				}
				puntero++;
				continue;
			}
			if(tokens.get(puntero).getId()==6){//else
				if(verificaElse(tokens)){
					ErrorS=true;
					break;
				}
				if(tokens.get(puntero-1).getId()!=14){
					ErrorS=true;
					break;
				}
				puntero++;
				if(tokens.get(puntero).getId()!=13){
					ErrorS=true;
					break;
				}
				if(cuentaLlaves(tokens)){
					ErrorS=true;
					break;
				}
				puntero++;
				continue;
			}
			if(tokens.get(puntero).getId()==7){//while
				if(tokens.get(puntero+1).getId()!=11){
					ErrorS=true;
					break;
				}
				puntero+=2;
				if(tokens.get(puntero).getId()!=18 && tokens.get(puntero).getId()!=23){
					ErrorS=true;
					break;
				}
				if(tokens.get(puntero).getId()==23){
					if(!verificaVariable(tokens.get(puntero).getValor())){
						ErrorS=true;
						break;
					}
				}
				if(tokens.get(puntero+1).getId()!=15 && tokens.get(puntero+1).getId()!=16 && tokens.get(puntero+1).getId()!=17){
					ErrorS=true;
					break;
				}
				puntero+=2;
				if(tokens.get(puntero).getId()!=18 && tokens.get(puntero).getId()!=23){
					ErrorS=true;
					break;
				}
				if(tokens.get(puntero).getId()==23){
					if(!verificaVariable(tokens.get(puntero).getValor())){
						ErrorS=true;
						break;
					}
				}
				puntero++;
				if(tokens.get(puntero).getId()!=12){
					ErrorS=true;
					break;
				}
				if(tokens.get(puntero+1).getId()!=13){
					ErrorS=true;
					break;
				}
				if(cuentaLlaves(tokens)){
					ErrorS=true;
					break;
				}
				puntero+=2;
				continue;
			}
			if(tokens.get(puntero).getId()==8){//imprime
				if(tokens.get(puntero+1).getId()!=11){
					ErrorS=true;
					break;
				}
				puntero+=2;
				if(tokens.get(puntero).getId()!=18 && tokens.get(puntero).getId()!=23){
					ErrorS=true;
					break;
				}
				if(tokens.get(puntero).getId()==23){
					if(!verificaVariable(tokens.get(puntero).getValor())){
						ErrorS=true;
						break;
					}
				}
				if(tokens.get(puntero+1).getId()!=12){
					ErrorS=true;
					break;
				}
				if(tokens.get(puntero+2).getId()!=9){
					ErrorS=true;
					break;
				}
				puntero+=3;
				continue;
			}
			if(tokens.get(puntero).getId()==14)//llave de cierre
				puntero++;
		}
		return;
	}
	public boolean verificaElse(ArrayList<Token> tokens){
		int cantIf=0,cantElse=1;
		for(int i = 0;i<puntero;i++)
		{
			if(tokens.get(i).getId()==5)
				cantIf++;
			if(tokens.get(i).getId()==6)
				cantElse++;
		}
		if(cantIf==cantElse)
			return false;
		return true;
	}
	public boolean cuentaLlaves(ArrayList<Token> tokens){
		int cant1=0,cant2=0;
		for(int i = 0;i<tokens.size();i++)
		{
			if(tokens.get(i).getId()==13)
				cant1++;
			if(tokens.get(i).getId()==14)
				cant2++;
		}
		if(cant1==cant2)
			return false;
		return true;
	}
	public boolean cuentaParentesis(ArrayList<Token> tokens){
		int cant1=0,cant2=0;
		for(int i = 0;i<tokens.size();i++)
		{
			if(tokens.get(i).getId()==11)
				cant1++;
			if(tokens.get(i).getId()==12)
				cant2++;
		}
		if(cant1==cant2)
			return false;
		return true;
	}
	public boolean verificaVariable(String valor){
		if(TablaSimbolos.isEmpty())
			return false;
		for(int i=0;i<TablaSimbolos.size();i++){
			if(TablaSimbolos.get(i).getValor().equals(valor))
					return true;
		}
		return false;
	}
}
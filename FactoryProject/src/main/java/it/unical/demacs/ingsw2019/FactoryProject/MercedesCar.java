package it.unical.demacs.ingsw2019.FactoryProject;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class MercedesCar implements Car{

	String Nome;
	Image img;
	
	public MercedesCar(String Nome, Image I) {this.Nome = Nome; this.img = I;}

	public String getNome() {
		return Nome;
	}

	public Image getImage() {
		return img;
	}
	

	
}

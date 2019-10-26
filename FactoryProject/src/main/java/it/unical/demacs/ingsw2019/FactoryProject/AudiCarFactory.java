package it.unical.demacs.ingsw2019.FactoryProject;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class AudiCarFactory extends CarFactory{

	@Override
	public Car CreateBerlina() {
		return new AudiCar("Audi A5", getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\Audi\\AudiA5.png").getImage(), 400, 300));
	}

	@Override
	public Car CreateSuv() {
		return new AudiCar("Audi Q8", getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\Audi\\AudiQ8.png").getImage(), 400, 300));
	}

	@Override
	public Car CreateSport() {
		return new AudiCar("Audi R8", getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\Audi\\AudiR8.png").getImage(), 400, 300));
	}
	
	public Image getLogo() {
		return getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\Audi\\AudiLogo.png").getImage(), 150, 150);
	}
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
}

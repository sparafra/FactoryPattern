package it.unical.demacs.ingsw2019.FactoryProject;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class MercedesCarFactory extends CarFactory{

	@Override
	public Car CreateBerlina() {
		return new MercedesCar("Mercedes Benz C", getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MercedesBenz\\MercedesC.png").getImage(), 400, 230));
	}

	@Override
	public Car CreateSuv() {
		return new MercedesCar("Mercedes Benz GLE", getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MercedesBenz\\MercedesGLE.png").getImage(), 400, 220));
	}

	@Override
	public Car CreateSport() {
		return new MercedesCar("Mercedes Benz SLS", getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MercedesBenz\\MercedesSLS.png").getImage(), 400, 240));
	}
	
	@Override
	public Image getLogo() {
		return getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MercedesBenz\\MercedesLogo.png").getImage(), 150, 150);
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

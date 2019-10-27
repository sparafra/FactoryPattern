package it.unical.demacs.ingsw2019.FactoryMethodProject;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import it.unical.demacs.ingsw2019.FactoryMethodProject.AudiCar;
import it.unical.demacs.ingsw2019.FactoryMethodProject.MercedesCar;

public class CarFactoryMethod {

	public CarFactoryMethod() {}
	
	public Car CreateBerlina(CarBrand Brand)
	{
		
		if(Brand == CarBrand.AUDI)
		{
			return new AudiCar("Audi A5", getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\Audi\\AudiA5.png").getImage(), 400, 300));

		}
		else if(Brand == CarBrand.MERCEDESBENZ)
		{
			return new MercedesCar("Mercedes Benz C", getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MercedesBenz\\MercedesC.png").getImage(), 400, 230));
		}
		return null;
		
	}
	
	
	public Car CreateSuv(CarBrand Brand)
	{
		
		if(Brand == CarBrand.AUDI)
		{
			return new AudiCar("Audi Q8", getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\Audi\\AudiQ8.png").getImage(), 400, 300));

		}
		else if(Brand == CarBrand.MERCEDESBENZ)
		{
			return new MercedesCar("Mercedes Benz GLE", getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MercedesBenz\\MercedesGLE.png").getImage(), 400, 220));

		}
		return null;
	}
	
	
	public Car CreateSport(CarBrand Brand)
	{
		
		if(Brand == CarBrand.AUDI)
		{
			return new AudiCar("Audi R8", getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\Audi\\AudiR8.png").getImage(), 400, 300));
		}
		else if(Brand == CarBrand.MERCEDESBENZ)
		{
			return new MercedesCar("Mercedes Benz SLS", getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MercedesBenz\\MercedesSLS.png").getImage(), 400, 240));
		}
		return null;
	}
	
	public Image getLogo(CarBrand Brand)
	{
		if(Brand == CarBrand.AUDI)
		{
			return getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\Audi\\AudiLogo.png").getImage(), 150, 150);
		}
		else if(Brand == CarBrand.MERCEDESBENZ)
		{
			return getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\MercedesBenz\\MercedesLogo.png").getImage(), 150, 150);
		}
		return null;
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

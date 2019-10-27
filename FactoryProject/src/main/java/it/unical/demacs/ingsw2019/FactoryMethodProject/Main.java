package it.unical.demacs.ingsw2019.FactoryMethodProject;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Main {

	private JFrame frame;
	CarFactoryMethod Factory;
	int posModel; // 0 --> Suv, 1 --> Berlina, 2 --> Sport
	int posBrand; // 0 --> Audi, 1 --> Mercedes
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
        Image background = getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\background.jpg").getImage(), 1100, 700);
        ImageIcon backgroundResized = new ImageIcon(background);
		
		frame.getContentPane().setLayout(new BorderLayout());
		JLabel label = new JLabel(backgroundResized);
		frame.setContentPane(label);
		frame.getContentPane().setLayout(null);
		
		
		//Factory = new MercedesCarFactory();
		Factory = new CarFactoryMethod();
		
		posModel = 1;
		posBrand = 1;
        draw(Factory.CreateBerlina(CarBrand.MERCEDESBENZ));
        
		
	}
	
	private void draw(Car C)
	{
		
		
		ImageIcon i = new ImageIcon(C.getImage());
        JLabel Preview = new JLabel(i);
        Preview.setHorizontalAlignment(SwingConstants.LEFT);
        Preview.setBounds(350, 250, 400, 300);
        Preview.setName("Preview");
        
        ImageIcon logo = null;
        if(posBrand == 0)
        	logo = new ImageIcon(Factory.getLogo(CarBrand.AUDI));
        else if(posBrand == 1)
        	logo = new ImageIcon(Factory.getLogo(CarBrand.MERCEDESBENZ));

        JLabel Logo = new JLabel(logo);
        Logo.setHorizontalAlignment(SwingConstants.LEFT);
        Logo.setBounds(475, 20, 200, 150);
        Logo.setName("Logo");
        
        
        
        Image backImage = getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\back.png").getImage(), 200, 200);
        ImageIcon back = new ImageIcon(backImage);
        JLabel Back = new JLabel(back);
        Back.setHorizontalAlignment(SwingConstants.LEFT);
        Back.setBounds(150, 350, 200, 100);
        
        Image forwardImage = getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\forward.png").getImage(), 200, 200);
        ImageIcon forward = new ImageIcon(forwardImage);
        JLabel Forward = new JLabel(forward);
        Forward.setHorizontalAlignment(SwingConstants.LEFT);
        Forward.setBounds(750, 350, 200, 100);
        
        Image backLogoImage = getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\back.png").getImage(), 100, 100);
        ImageIcon backLogo = new ImageIcon(backLogoImage);
        JLabel BackLogo = new JLabel(backLogo);
        BackLogo.setHorizontalAlignment(SwingConstants.LEFT);
        BackLogo.setBounds(350, 50, 100, 100);
        
        Image forwardLogoImage = getScaledImage(new ImageIcon(System.getProperty("user.dir")+"\\Images\\forward.png").getImage(), 100, 100);
        ImageIcon forwardLogo = new ImageIcon(forwardLogoImage);
        JLabel ForwardLogo = new JLabel(forwardLogo);
        ForwardLogo.setHorizontalAlignment(SwingConstants.LEFT);
        ForwardLogo.setBounds(650, 50, 200, 100);
        
        frame.getContentPane().add(Preview);
        frame.getContentPane().add(Logo);
        frame.getContentPane().add(Back);
        frame.getContentPane().add(Forward);
        frame.getContentPane().add(BackLogo);
        frame.getContentPane().add(ForwardLogo);
        
        
        BackLogo.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {       	
            	if(posBrand == 1)
        		{
        			posBrand--;
        		}
            	for (Component jc : frame.getContentPane().getComponents()) {
		            if (jc instanceof JLabel) {
		                JLabel label = (JLabel) jc;
		                System.out.println(label.getName());
		                if(label.getName() != null )
		                {
		                	if(label.getName().equals("Preview"))
		                	{
		                		if(posBrand == 0)
		                		{
			                		if(posModel == 0)
			                		{
			                			ImageIcon imgI = new ImageIcon(Factory.CreateSuv(CarBrand.AUDI).getImage());
			    						label.setIcon(imgI);
			                		}
			                		if(posModel == 1)
			                		{
			                			ImageIcon imgI = new ImageIcon(Factory.CreateBerlina(CarBrand.AUDI).getImage());
			    						label.setIcon(imgI);
			                		}
			                		if(posModel == 2)
			                		{
			                			ImageIcon imgI = new ImageIcon(Factory.CreateSport(CarBrand.AUDI).getImage());
			    						label.setIcon(imgI);
			                		}
		                		}
		                		else if(posBrand == 1)
		                		{
		                			if(posModel == 0)
			                		{
			                			ImageIcon imgI = new ImageIcon(Factory.CreateSuv(CarBrand.MERCEDESBENZ).getImage());
			    						label.setIcon(imgI);
			                		}
			                		if(posModel == 1)
			                		{
			                			ImageIcon imgI = new ImageIcon(Factory.CreateBerlina(CarBrand.MERCEDESBENZ).getImage());
			    						label.setIcon(imgI);
			                		}
			                		if(posModel == 2)
			                		{
			                			ImageIcon imgI = new ImageIcon(Factory.CreateSport(CarBrand.MERCEDESBENZ).getImage());
			    						label.setIcon(imgI);
			                		}
		                		}
		                	}
		                	else if(label.getName().equals("Logo"))
		                	{
		                		if(posBrand == 0)
		                		{
			                		ImageIcon imgI = new ImageIcon(Factory.getLogo(CarBrand.AUDI));
			    					label.setIcon(imgI);
		                		}
		                		else if(posBrand == 1)
		                		{
		                			ImageIcon imgI = new ImageIcon(Factory.getLogo(CarBrand.MERCEDESBENZ));
			    					label.setIcon(imgI);
		                		}
		                	}
		                }
		            }
    			}
            	
            	

            }  
        }); 
        
        ForwardLogo.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
            	if(posBrand == 0)
        		{
        			posBrand++;
        		}
            	
            	
            	for (Component jc : frame.getContentPane().getComponents()) {
		            if (jc instanceof JLabel) {
		                JLabel label = (JLabel) jc;
		                System.out.println(label.getName());
		                if(label.getName() != null )
		                {
		                	if(label.getName().equals("Preview"))
		                	{
		                		if(posBrand == 0)
		                		{
			                		if(posModel == 0)
			                		{
			                			ImageIcon imgI = new ImageIcon(Factory.CreateSuv(CarBrand.AUDI).getImage());
			    						label.setIcon(imgI);
			                		}
			                		if(posModel == 1)
			                		{
			                			ImageIcon imgI = new ImageIcon(Factory.CreateBerlina(CarBrand.AUDI).getImage());
			    						label.setIcon(imgI);
			                		}
			                		if(posModel == 2)
			                		{
			                			ImageIcon imgI = new ImageIcon(Factory.CreateSport(CarBrand.AUDI).getImage());
			    						label.setIcon(imgI);
			                		}
		                		}
		                		else if(posBrand == 1)
		                		{
		                			if(posModel == 0)
			                		{
			                			ImageIcon imgI = new ImageIcon(Factory.CreateSuv(CarBrand.MERCEDESBENZ).getImage());
			    						label.setIcon(imgI);
			                		}
			                		if(posModel == 1)
			                		{
			                			ImageIcon imgI = new ImageIcon(Factory.CreateBerlina(CarBrand.MERCEDESBENZ).getImage());
			    						label.setIcon(imgI);
			                		}
			                		if(posModel == 2)
			                		{
			                			ImageIcon imgI = new ImageIcon(Factory.CreateSport(CarBrand.MERCEDESBENZ).getImage());
			    						label.setIcon(imgI);
			                		}
		                		}
		                	}
		                	else if(label.getName().equals("Logo"))
		                	{
		                		if(posBrand == 0)
		                		{
			                		ImageIcon imgI = new ImageIcon(Factory.getLogo(CarBrand.AUDI));
			    					label.setIcon(imgI);
		                		}
		                		else if(posBrand == 1)
		                		{
		                			ImageIcon imgI = new ImageIcon(Factory.getLogo(CarBrand.MERCEDESBENZ));
			    					label.setIcon(imgI);
		                		}
		                	}
		                }
		            }
    			}
            	

            }  
        }); 
        
        Back.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
            	System.out.println("Back Car");

            	for (Component jc : frame.getContentPane().getComponents()) {
		            if (jc instanceof JLabel) {
		                JLabel label = (JLabel) jc;
		                System.out.println(label.getName());
		                if(label.getName() != null )
		                {
		                	if(label.getName().equals("Preview"))
		                	{
		                		if(posModel == 1)
		                		{
		                			ImageIcon imgI = null;
		                			if(posBrand == 0)
		                				imgI = new ImageIcon(Factory.CreateSuv(CarBrand.AUDI).getImage());
		                			else if(posBrand == 1)
		                				imgI = new ImageIcon(Factory.CreateSuv(CarBrand.MERCEDESBENZ).getImage());

		    						label.setIcon(imgI);
		    						posModel--;
		                		}
		                		if(posModel == 2)
		                		{
		                			ImageIcon imgI = null;
		                			if(posBrand == 0)
		                				imgI = new ImageIcon(Factory.CreateBerlina(CarBrand.AUDI).getImage());
		                			else if(posBrand == 1)
		                				imgI = new ImageIcon(Factory.CreateBerlina(CarBrand.MERCEDESBENZ).getImage());

		    						label.setIcon(imgI);
		    						posModel--;
		                		}
		                	}
		                }
		            }
    			}

            	
            	
            	//draw(Factory.CreateSuv());

            }  
        }); 
        
        Forward.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
            	System.out.println("Forward Car");
            	for (Component jc : frame.getContentPane().getComponents()) {
		            if (jc instanceof JLabel) {
		                JLabel label = (JLabel) jc;
		                System.out.println(label.getName());
		                if(label.getName() != null )
		                {
		                	if(label.getName().equals("Preview"))
		                	{
		                		if(posModel == 1)
		                		{
		                			ImageIcon imgI = null;
		                			if(posBrand == 0)
		                				imgI = new ImageIcon(Factory.CreateSport(CarBrand.AUDI).getImage());
		                			else if(posBrand == 1)
		                				imgI = new ImageIcon(Factory.CreateSport(CarBrand.MERCEDESBENZ).getImage());

		    						label.setIcon(imgI);
		    						posModel++;
		                		}
		                		if(posModel == 0)
		                		{
		                			ImageIcon imgI = null;
		                			if(posBrand == 0)
		                				imgI = new ImageIcon(Factory.CreateBerlina(CarBrand.AUDI).getImage());
		                			else if(posBrand == 1)
		                				imgI = new ImageIcon(Factory.CreateBerlina(CarBrand.MERCEDESBENZ).getImage());
		                			
		                			label.setIcon(imgI);
		    						posModel++;
		                		}
		                		
		                	}
		                }
		            }
    			}
            }  
        }); 
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

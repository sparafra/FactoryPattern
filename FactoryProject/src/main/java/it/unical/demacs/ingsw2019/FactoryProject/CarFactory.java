package it.unical.demacs.ingsw2019.FactoryProject;

import java.awt.Image;

public abstract class CarFactory {

	public abstract Car CreateBerlina();
	public abstract Car CreateSuv();
	public abstract Car CreateSport();
	public abstract Image getLogo();
}

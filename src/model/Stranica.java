package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ObserverPackage.Observable;
import ObserverPackage.Observer;

public class Stranica extends Node implements Observable,Serializable {
	
	
	private Dokument parent;
	
	private static final long serialVersionUID = 574965780051886408L;

	transient private List<Observer> observers = new ArrayList<Observer>();
	
	private String id;
	
	public Stranica()
	{
		
	}
	
	public Stranica(String naziv,Dokument parent,String id)
	{
		this.name = naziv;
		this.parent = parent;
		this.id = id;
	}

	@Override
	public void notifyObservers(Object arg) {
		// TODO Auto-generated method stub
		
		for (Observer o : observers) {
			o.update(this,arg);
		}
		
	}

	@Override
	public void addObserver(Observer observer) {
		// TODO Auto-generated method stub
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		this.observers.remove(observer);
	
	}

	public Dokument getParent() {
		return parent;
	}

	public void setParent(Dokument parent) {
		this.parent = parent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Observer> getObservers() {
		return observers;
	}

	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}

		
	
	
}

package ObserverPackage;

import java.io.Serializable;


public interface Observable extends Serializable {

	public abstract void notifyObservers(Object arg);
	
	public abstract void addObserver(Observer observer);
	
	public abstract void removeObserver(Observer observer);
}

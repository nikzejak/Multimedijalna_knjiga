package ObserverPackage;

import java.io.Serializable;

public interface Observer extends Serializable {
	
	public void update(Observable arg0,Object arg1);

}

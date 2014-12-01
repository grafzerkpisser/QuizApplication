package persistentie;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;

abstract class AbstractCSVReader<T> {
	
	public Set<T> getAll(File file) throws IOException, ClassNotFoundException{
		Set<T> returnSet = new HashSet<>();
		try(
				InputStream f = new FileInputStream(file);
				InputStream buffer = new BufferedInputStream(f);
				ObjectInput input = new ObjectInputStream(buffer);
				
				){
			returnSet = unmarshall(input);
			return returnSet;
		}
		catch(IOException ex){
			throw new IOException("File kan niet gelezen worden " + ex);
		}
	}

	
	abstract Set<T> unmarshall(ObjectInput input) throws ClassNotFoundException, IOException;
}

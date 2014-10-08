import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;



public class Client {

	public static void main(String[] args) {
		
		try {
			
			String serverURL = "stockholm.vitalab.tuwien.ac.at";
			SocketAddress server = new InetSocketAddress(serverURL, 9000);
			Socket client = new Socket();
			
			System.out.println("trying to connect to " + serverURL + " ....");
			client.connect(server, 100);
			System.out.println("connection established");
			
			BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter output = new PrintWriter(client.getOutputStream(), true);
			
			output.println("!login 0304463 10530");
			String readString;
			
			while((readString = input.readLine()) != null) {
				
				System.out.println("## " + readString);
			}
			
			input.close();
			output.close();
			client.close();
			
		} catch (IOException e) {
			System.out.println("somethings wrong: " + e);
		}
	}
}

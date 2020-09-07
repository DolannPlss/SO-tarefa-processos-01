package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class RedesController {
	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void ipConfig(String os) {
		if (os.contains("Windows")) {
			StringBuffer buffer2= new StringBuffer();
				try {
					boolean ipv4 = false;
					Process p = Runtime.getRuntime().exec("ipconfig");
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					buffer2.append(linha);
					buffer2.append("\n");
					while (linha != null) {
						if (linha.contains("IPv4")) {
							ipv4 = true;
						}
							if (linha.contains("Gateway")) {
								if (ipv4 == true) {
										System.out.println(buffer2);
									ipv4 = false;
									buffer2.delete(0, buffer2.length());
								}
							}					
						linha = buffer.readLine();
						buffer2.append(linha);
						buffer2.append("\n");
					}
					buffer.close();
					leitor.close();
					fluxo.close();
					
				} catch (IOException e) {
					e.printStackTrace();
			}
		}else{if (os.contains("Linux")) {
			StringBuffer buffer2= new StringBuffer();
			try {
				boolean ipv4 = false;
				Process p = Runtime.getRuntime().exec("ifconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				buffer2.append(linha);
				buffer2.append("\n");
				while (linha != null) {
					if (linha.contains("inet")) {
						ipv4 = true;
					}
						if (linha.contains("TX errors")) {
							if (ipv4 == true) {
									System.out.println(buffer2);
								ipv4 = false;
								buffer2.delete(0, buffer2.length());
							}
						}					
					linha = buffer.readLine();
					buffer2.append(linha);
					buffer2.append("\n");
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				e.printStackTrace();
		}
		}
	}
	}
	public void pingTest ( String os){
		if(os.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("ping -n 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("M‚dia")) {
						
						System.out.println("média do ping= "+linha.substring(40,45));
						}
						linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{if (os.contains("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec("ping -c 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("avg")) {
						System.out.println("média= "+linha.substring(30,36)+"ms");
						}
						linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
}
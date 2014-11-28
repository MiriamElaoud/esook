package tn.esprit.jsf.esook.managedBean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;









public class FileUpload {
	private String destination;
	@PostConstruct
	public void init (){
		
	destination= System.getProperty ("jboss.home.dir")+"\\welcome-content\\tmp\\";
	
	
	}
	
	

	public void upload(FileUploadEvent event) {
		System.out.println(event.getFile().getFileName());
		FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_INFO,"Success! ", event.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		// Do what you want with the file
		try {
			copyFile(event.getFile().getFileName(), event.getFile()
					.getInputstream());
		
		} catch (IOException e) {
			e.printStackTrace();}}
		
		public void copyFile(String fileName, InputStream in) {
			System.out.println(destination);
			try {
				// write the inputStream to a FileOutputStream
				OutputStream out = new FileOutputStream(new File(destination
						+ fileName));
				int read = 0;
				byte[] bytes = new byte[1024];
				while ((read = in.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
				in.close();
				out.flush();
				out.close();
				System.out.println("New file created!");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}



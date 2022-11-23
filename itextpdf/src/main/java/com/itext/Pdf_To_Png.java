package com.itext;

import java.io.IOException;

import com.aspose.pdf.Document;
import com.aspose.pdf.devices.PngDevice;
import com.aspose.pdf.devices.Resolution;

class Pdf_To_Png{

	public Pdf_To_Png() throws IOException {
		try {
			
			System.out.println("Generating PNG file...");
			String currentWorkingDir = System.getProperty("user.dir");
			Document pdfDocument = new Document(currentWorkingDir+"\\media\\outputpng\\label.pdf");
			java.io.OutputStream imageStream = new java.io.FileOutputStream(currentWorkingDir+"\\media\\outputpng\\label.png");
			Resolution resolution = new Resolution(300);
			PngDevice pngDevice = new PngDevice(resolution);
			
			// Convert a particular page and save the image to stream
			pngDevice.process(pdfDocument.getPages().get_Item(1), imageStream);
			imageStream.close();
			pdfDocument.close();

			System.out.println("PNG file Generated...");
			
		} catch (Exception e) {
			System.out.println("Error In Pdf_To_Png class");
		}
	}
}
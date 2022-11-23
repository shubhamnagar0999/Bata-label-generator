package com.itext;

import java.io.IOException;
import com.aspose.barcode.EncodeTypes;
import com.aspose.barcode.generation.BarcodeGenerator;

class BarCode {
    public BarCode(){

        try {
            //Barcode CODE_128
            System.out.println("Creating first barcode...");
            String currentWorkingDir = System.getProperty("user.dir");
            

            BarcodeGenerator code128 = new BarcodeGenerator(EncodeTypes.CODE_128);
            code128.setCodeText("82462410601121F50200053");
            code128.save(currentWorkingDir +"\\media\\outputpng\\CODE_128.png");
    
            System.out.println("First barcode is Created...");
            
            //Brcode EAN_13
            System.out.println("Creating 2nd barcode...");
    
            BarcodeGenerator ean13 = new BarcodeGenerator(EncodeTypes.EAN_13);
            ean13.setCodeText("8905106169700");
            ean13.save(currentWorkingDir+"\\media\\outputpng\\EAN_13.png");
    
            System.out.println("2nd barcode is Created...");
    
    
        } catch (IOException e) {
            System.out.println( "Error in BarCode class." );
        } 
    }
}

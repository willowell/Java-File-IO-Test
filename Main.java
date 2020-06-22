package com.whowell;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var contents = new ArrayList<String>();
        File inFile  = new File("src/MyNumbers.txt");
        
        
        try (Scanner scanner = new Scanner( new FileReader( ( inFile ) ) ); )  {
            while (scanner.hasNext()) {
                contents.add(scanner.nextLine());
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }

        System.out.println( contents );

        for ( var s : contents ) {
            System.out.println( "Number: " + Integer.parseInt( s ) );
        }

        Path outFile = Paths.get( "src/out.txt" );

        try {
            Files.write( outFile, contents, StandardCharsets.UTF_8 );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}

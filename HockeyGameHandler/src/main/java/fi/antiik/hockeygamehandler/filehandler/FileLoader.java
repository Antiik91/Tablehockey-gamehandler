///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fi.antiik.hockeygamehandler.filehandler;
//
//import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
//import static com.sun.org.apache.xalan.internal.utils.SecuritySupport.getContextClassLoader;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author janantik
// */
//public class FileLoader {
//    
//    private String name;
//
//    public FileLoader(String name) {
//        this.name = name;
//    }
//    
//    
//
//    
//    public List<String>  getResourceFiles( String path) throws IOException {
//        List<String> filenames = new ArrayList<>();
//        try( 
//            InputStream in = getResourceAsStream(path );
//            BufferedReader br = new BufferedReader( new InputStreamReader(in))) {
//                String resource;
//                
//                while((resource = br.readLine()) != null) {
//                    filenames.add(resource);
//            }
//        }
//        return filenames;
//    }
//    private InputStream getResourceAsStream(String resource) {
//        final InputStream in
//                = getContextClassLoader().getResourceAsStream( resource);
//        return in == null ? getClass().getResourceAsStream(resource) : in;
//    }
//    
//    private ClassLoader getContextClassLoader() {
//        return Thread.currentThread().getContextClassLoader();
//    }
//}

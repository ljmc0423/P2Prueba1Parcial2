/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivos;
import java.io.File;
import java.io.IOException;
import java.util.Date;
/**
 *
 * @author ljmc2
 */
public class MyFile {
    private File file=null;
    
    public void setFile(String dir){
        file=new File(dir);
    }
    
    public void info(){
        if(file.exists()){
            System.out.println("Nombre: "+file.getName());
            System.out.println("Path: "+file.getPath());
            System.out.println("Absoluto: "+file.getAbsolutePath());            //getName()[buscar la diferencia]
            System.out.println("Padre: "+file.getAbsoluteFile().getParentFile().getParent());
            System.out.println("Bytes: "+file.length());
            if(file.isFile()){
                System.out.println("Es un archivo");
            }else if(file.isDirectory()){
                System.out.println("Es un folder");
            }
            System.out.println("Ultima modif: "+file.lastModified());
            
        }else{
            System.out.println("Archivo no existe");
        }
    }
    
    void crearArchivo()throws IOException{
        if(file.createNewFile()){
            System.out.println("Creado con exito!");
        }else{
            System.out.println("No se pudo crear!");
        }
    }
    
    void crearFolder(){
        if(file.mkdir()){
            System.out.println("Creado con exito!");
        }else{
            System.out.println("No se pudo crear!");
        }
    }
    
    void borrar(){
        if(borrarR(file)){
            System.out.println("Borrado");
        }else{
            System.out.println("No se logro");
        }
    }
    
    private boolean borrarR(File f){
        if(f.isDirectory()){
            for(File child:f.listFiles()){
                borrarR(child);
            }
        }
        return f.delete();
    }
    
    void borrarArchivo(File file) throws IOException {
        if (file.isDirectory()) {
            File[] archivos = file.listFiles();
            if (archivos != null) {
                for (File f : archivos) {
                    borrarArchivo(f);
                }
            }
        }

        if (file.delete()) {
            System.out.println("| Se eliminó: " + file.getAbsolutePath());
        } else {
            System.out.println("| No se pudo eliminar: " + file.getAbsolutePath());
        }
    }
    
    public File getFile(){
        return file;
    }
    
    private void tree(File dir, String tab){
        if(dir.isDirectory()){
            System.out.println(tab+dir.getName());
            for(File child:dir.listFiles())
                if(!child.isHidden())
                    tree(child,tab+"--");
        }
    }
    
    void tree(){
        tree(file,"-");
    }
    
    
}

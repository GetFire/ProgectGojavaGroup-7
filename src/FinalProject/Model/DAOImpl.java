package FinalProject.Model;

import FinalProject.Model.DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 */

public class DAOImpl<T> implements DAO<T>, Serializable{

    private List<T> dataBaseList = new ArrayList<>();
    private String nameFile = this.getClass().getSimpleName();
    private File DBFile = new File("src/EscortFiles/"+nameFile+".dat");

    public DAOImpl(){
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(DBFile))){
            Object o = reader.readObject();
            if(o != null){
                dataBaseList = (ArrayList<T>) o;
            }
        } catch (IOException e){
            try{
                DBFile.createNewFile();
            }catch (IOException i){
                System.err.println("Cannot create new file");
            }
        } catch (ClassNotFoundException e){
            System.err.println("ArrayList not found in "+nameFile+" file");
        }
    }

    @Override
    public T save(T object) {
        this.dataBaseList.add(object);
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(DBFile))){
            writer.writeObject(dataBaseList);
            writer.flush();
        }catch (IOException e){
            System.err.println("Cannot save this file");
        }
        return object;

    }

    @Override
    public T remove(T object) {
        this.dataBaseList.remove(object);
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(DBFile))){
            writer.writeObject(dataBaseList);
            writer.flush();
        }catch (IOException e){
            System.err.println("Cannot remove this file");
        }
        return object;
    }

    @Override
    public T update(T object) {
        int i = this.dataBaseList.indexOf(object);
        this.dataBaseList.remove(object);
        this.dataBaseList.add(i, object);
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(DBFile))){
            writer.writeObject(dataBaseList);
            writer.flush();
        }catch (IOException e){
            System.err.println("Cannot update this file");
        }
        return object;
    }

    public List<T> getDataBaseList() {
        return dataBaseList;
    }

    public void setDataBaseList(List<T> dataBaseList) {
        this.dataBaseList = dataBaseList;
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(DBFile))){
            writer.writeObject(dataBaseList);
            writer.flush();
        }catch (IOException e){
            System.err.println("Cannot update this file");
        }
    }
}

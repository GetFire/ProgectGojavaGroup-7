package FinalProject;

/**
 * Created by tvv89 on 24.01.2017 for ProgectGojavaGroup-7.
 */
public interface DAO <T> {
     T save( T object);
     T remove(T object);
     T update (T object);

}

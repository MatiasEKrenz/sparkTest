import java.util.Collection;

public interface IntegranteService {
    // declarar los metodos que deberia implemmentar en un servicio
    // listo los metodos que usaria en un servicio que implementa esta interface

    public void addIntegrante(Integrante integrante);
    public Collection<Integrante> getIntegrantes();
    public Integrante getIntegrante(String id);
    public Integrante editIntegrante(Integrante integrante) throws IntegranteException;
    public void deleteIntegrante(String id);
    public boolean integranteExist(String id);
}

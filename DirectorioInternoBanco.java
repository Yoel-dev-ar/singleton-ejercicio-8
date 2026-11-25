import java.util.HashMap;
import java.util.Map;

public class DirectorioInternoBanco {
    private static DirectorioInternoBanco instancia;
    private Map<String, String> serviciosBanco;

    private DirectorioInternoBanco() {
        this.serviciosBanco = new HashMap<>();
    }

    public static DirectorioInternoBanco getInstancia() {
        if (instancia == null) {
            instancia = new DirectorioInternoBanco();
        }
        return instancia;
    }

    public void registrarServicio(String nombreArea, String estado) {
        serviciosBanco.put(nombreArea, estado);
        System.out.println("[DIRECTORIO] Área '" + nombreArea + "' registrada como: " + estado);
    }

    public boolean estaDisponible(String nombreArea) {
        String estado = serviciosBanco.getOrDefault(nombreArea, "NO EXISTE");
        return estado.equals("ACTIVO");
    }
}
public class Main {
    public static void main(String[] args) {
        DirectorioInternoBanco dirSistemas = DirectorioInternoBanco.getInstancia();
        DirectorioInternoBanco dirAtencion = DirectorioInternoBanco.getInstancia();

        // Sistemas registra las áreas del banco
        dirSistemas.registrarServicio("CUENTAS", "ACTIVO");
        dirSistemas.registrarServicio("PRESTAMOS", "EN MANTENIMIENTO");

        // Atención al cliente consulta antes de ofrecer un servicio
        System.out.println("¿Cuentas funcionando?: " + dirAtencion.estaDisponible("CUENTAS"));
        System.out.println("¿Préstamos funcionando?: " + dirAtencion.estaDisponible("PRESTAMOS"));
        System.out.println("¿Mismo directorio?: " + (dirSistemas == dirAtencion));
    }
}
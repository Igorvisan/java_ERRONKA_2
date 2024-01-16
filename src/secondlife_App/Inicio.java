package secondlife_App;

import java.sql.Connection;
import java.util.Scanner;

public class Inicio {
	
	public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int aukera;

        System.out.println("Bienvenido Usuario. Seleccione el método de inicio de sesión");
        System.out.println("COMO DESEA INICIAR SESION?\n OPCIONES:\n1 = Cliente\n2 = Proveedor\n3 = Empleado");
        aukera = sc.nextInt();
        
        Langileak empleados = new Langileak();// Para usar los metodos de Langileak necesito crear una estancia de la clase Langileak

        switch (aukera) {
            case 1:
                System.out.println("Entrará a la sección de clientes");
                break;
            case 2:
                System.out.println("Entrará a la sección de proveedores");
                break;
            case 3:
                System.out.println("Entrará a la sección de Empleado");
                System.out.println("Seleccione el tipo de empleado:\n1 = Empleado Normal\n2 = Administrador\n3 = Encargado");
                int tipoEmpleado = sc.nextInt();
                int contraseña = empleadoIniciarSesion();

                switch (tipoEmpleado) {
                    case 1:
                    	empleados.confirmarEmpleadoNormal(contraseña);
                        break;
                    case 2:
                    	empleadoIniciarSesion();
                    	empleados.confirmarAdmistrador(contraseña);
                        break;
                    case 3:
                        empleadoIniciarSesion();
                        empleados.confirmarLangileArduraduna(contraseña);
                        break;                        
                }
                break;
        }
    }

    public static int empleadoIniciarSesion() {
        // Lógica para el inicio de sesión del empleado normal
        System.out.println("Iniciar sesion");
        // Puedes agregar más lógica según sea necesario
        int contraseña = 0;
        try{
        	System.out.println("Introduzca contraseña");
            contraseña = sc.nextInt();        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
		return contraseña;
        
    }
}

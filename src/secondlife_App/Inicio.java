package secondlife_App;

import java.sql.Connection;
import java.util.Scanner;

import javax.swing.JTextField;

public class Inicio {
	
	public static final Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args) {

        int aukera;

        System.out.println("Bienvenido Usuario. Seleccione el método de inicio de sesión");
        System.out.println("COMO DESEA INICIAR SESION?\n OPCIONES:\n1 = Cliente\n2 = Proveedor\n3 = Empleado");
        aukera = sc.nextInt();
        
        Langileak empleados1 = new Langileak();// Para usar los metodos de Langileak necesito crear una estancia de la clase Langileak

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

                switch (tipoEmpleado) {
                    case 1:
                    	empleados1.confirmarEmpleadoNormal(user, password);
                        break;
                    case 2:
                    	if(empleados1.confirmarAdmistrador(user, password)) {
                    		System.out.println("Aqui tienes la funciones posible como administrador:\n1 = Añadir nuevo empleado\n2 = Quitar empleado");
                    		int seleccionarAccion = sc.nextInt();
                    		
                    		switch(seleccionarAccion) {
                    		case 1:
                    			empleados1.añadirNuevoTrabajador();
                    			break;
                    		}
                    	};
                        break;
                    case 3:
                        empleados1.confirmarLangileArduraduna(user, password);
                        break;                        
                }
                break;
        }
    }
        
}

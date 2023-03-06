package dominio;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Gestion {
    public static void main(String[]args){

        ArrayList<Cliente> lista = new ArrayList<>();
        Cliente c1 = new Cliente("Juan","Perez","12345678");
        Cliente c2 = new Cliente("Maria","Gomez","87654321");
        Cliente c3 = new Cliente("Pedro","Gonzalez","12345678");
        Cliente c4 = new Cliente("Jose","Perez","12345678");
        Cliente c5 = new Cliente("Ana","Gomez","87654321");
    }
    public static ArrayList listarClientes(ArrayList<Cliente> lista){
        return Stream.iterate(0,x->x+1).limit(lista.size()).map(x->lista.get(x)).collect(Collectors.toCollection(ArrayList::new));
    }
    public static Cliente devolverClientes(ArrayList<Cliente> lista,String dni){
        return Stream.iterate(0,x->x+1).limit(lista.size()).filter(x->lista.get(x).getDni().equals(dni)).map(x->lista.get(x)).findFirst().get();
    }
    public static Cliente modificarCliente(String dni,ArrayList<Cliente> lista,String nombre,String apellido){
        return Stream.iterate(0,x->x+1).limit(lista.size()).map(x->lista.get(x)).filter(x->x.getDni().equals(dni)).map(x->{
            x.setNombre(nombre);
            x.setApellido(apellido);
            return x;
        }).findFirst().get();
    }
    public static void eliminarClientes(ArrayList<Cliente> lista,String dni){
         Stream.iterate(0,x->x+1).limit(lista.size()).map(x->lista.get(x)).filter(x->x.getDni().equals(dni)).map(x-> lista.remove(x));

         }
    public static void annadirCliente(ArrayList<Cliente> lista,Cliente c){
        lista.add(c);
    }

    }


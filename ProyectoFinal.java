import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class ProyectoFinal {
    static String[] idCurso = new String[100];
    static String[] nombreCurso = new String[100];
    static int[] numCreditos = new int[100];
    static int[] ciclo = new int[100];
    static String[] idPreRequisito = new String[100];
    static int NT = 0;
    static int[] idAlumno = new int[100];
    static String[] nombreAlumno = new String[100];
    static String[][] idCursoMatriculado = new String[100][10];
    static String[][] nombreCursoMatriculado = new String[100][10];
    static int[][] creditosCursoMatriculado = new int[100][10];
    static int[][] cicloCursoMatriculado = new int[100][10];
    static int NA = 0;
    private static Random scanner;
    int opc;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, opc;
        N = Leenum();
        do {
            opc = Menu();
            switch (opc) {
                case 1:
                    reportarCursos();
                    break;
                case 2:
                    agregarCurso(N,scanner);
                    break;
                case 3:
                    modificarCurso(scanner);
                    break;
                case 4:
                    eliminarCurso(scanner);
                    break;
                case 5:
                    consultarPorNombre(scanner);
                    break;
                case 6:
                    consultarPorCiclo(scanner);
                    break;
                case 7:
                    ordenarPorNombre();
                    break;
                case 8:
                    ordenarPorCiclo();
                    break;
                case 9:
                    matricularAlumno(scanner);
                    break;
                case 10:
                    reportarMatriculas();
                    break;
                case 11:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opc != 11);
    }
    public static int Leenum(){
        Scanner scanner = new Scanner(System.in);
        int N;
        do {
            System.out.println("Ingrese las veces que desees registrarte: ");
            N = scanner.nextInt();
        } while (N < 0 || N > 100);
        return N;
        
    }
    static int Menu() {
        Scanner scanner = new Scanner(System.in);
        int opc;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Reportar todos los datos de los cursos");
            System.out.
                    println("2. Agregar datos de cursos");
            System.out.
                    println("3. Modificar datos de los cursos");
            System.out.
                    println("4. Eliminar datos de los cursos");
            System.out.
                    println("5. Consultar por nombre de curso");
            System.out.
                    println("6. Consultar por ciclo");
            System.out.
                    println("7. Ordenar alfabéticamente por nombre de curso");
            System.out.
                    println("8. Ordenar en forma descendente por ciclo");
            System.out.
                    println("9. Realizar la matrícula de un alumno");
            System.out.
                    println("10. Reportar todos los datos de las matrículas");
            System.out.
                    println("11. Terminar");
            System.out.
                    print("Selecciona una opción: ");
            

            opc = scanner.nextInt();
        } while (opc < 1 || opc > 11);
        return opc;
    }
    static void reportarCursos() {
        if (NT == 0) { // NT = NUMERO TOTAL DE CURSOS
            System.out.println("No hay cursos registrados.");
            return;
        }
        System.out.println("\nDatos de los cursos:");
        for (int i = 0; i < NT; i++) {
            System.out.println("Curso " + (i + 1) + ":");
            System.out.println("IdCurso: " + idCurso[i]);
            System.out.println("Nombre: " + nombreCurso[i]);
            System.out.println("Créditos: " + numCreditos[i]);
            System.out.println("Ciclo: " + ciclo[i]);
            System.out.println("Pre-requisito: " + idPreRequisito[i]);
            System.out.println();
        }
    }

    static void agregarCurso(int N,Scanner scanner) {
        for (int i = 0; i < N; i++) {
            System.out.print("IdCurso (7 caracteres): ");
            String id = scanner.nextLine();
            if (id.length() != 7) {
                System.out.println("Error: El ID del curso debe tener 7 caracteres. Intenta de nuevo.");
                return;
            }
            System.out.print("Nombre del curso: ");
            String nombre = scanner.nextLine();
            System.out.print("Número de créditos: ");
            int creditos = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Ciclo: ");
            int cicloCurso = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Id Pre-requisito (o vacío si no tiene): ");
            String preRequisito = scanner.nextLine();
            idCurso[NT] = id;
            nombreCurso[NT] = nombre;
            numCreditos[NT] = creditos;
            ciclo[NT] = cicloCurso;
            idPreRequisito[NT] = preRequisito;
            NT++;
            System.out.println("Curso agregado correctamente.");
        }
    }

    static void modificarCurso(Scanner scanner) {
        if (NT == 0) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        System.out.print("Ingresa el IdCurso del curso a modificar: ");
        String idModificar = scanner.nextLine();
        int posicion = -1;
        for (int i = 0; i < NT; i++) {
            if (idCurso[i].equalsIgnoreCase(idModificar)) {
                posicion = i;
                break;
            }
        }
        if (posicion == -1) {
            System.out.println("No se encontró el curso con ese IdCurso.");
            return;
        }
        System.out.print("Nuevo nombre del curso: ");
        nombreCurso[posicion] = scanner.nextLine();
        System.out.print("Nuevo número de créditos: ");
        numCreditos[posicion] = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo ciclo: ");
        ciclo[posicion] = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo Id Pre-requisito (o vacío si no tiene): ");
        idPreRequisito[posicion] = scanner.nextLine();
        System.out.println("Curso modificado correctamente.");
    }

    static void eliminarCurso(Scanner scanner) {
        if (NT == 0) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        System.out.print("Ingresa el IdCurso del curso a eliminar: ");
        String idEliminar = scanner.nextLine();
        int posicion = -1;
        for (int i = 0; i < NT; i++) {
            if (idCurso[i].equalsIgnoreCase(idEliminar)) {
                posicion = i;
                break;
            }
        }
        if (posicion == -1) {
            System.out.println("No se encontró el curso con ese IdCurso.");
            return;
        }
        for (int i = posicion; i < NT - 1; i++) {
            idCurso[i] = idCurso[i + 1];
            nombreCurso[i] = nombreCurso[i + 1];
            numCreditos[i] = numCreditos[i + 1];
            ciclo[i] = ciclo[i + 1];
            idPreRequisito[i] = idPreRequisito[i + 1];
        }
        idCurso[NT - 1] = null;
        nombreCurso[NT - 1] = null;
        numCreditos[NT - 1] = 0;
        ciclo[NT - 1] = 0;
        idPreRequisito[NT - 1] = null;
        NT--;
        System.out.println("Curso eliminado correctamente.");
    }

    static void consultarPorNombre(Scanner scanner) {
        if (NT == 0) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        System.out.print("Ingresa el nombre del curso a consultar: ");
        String nombreCursoConsulta = scanner.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < NT; i++) {
            if (nombreCurso[i].equalsIgnoreCase(nombreCursoConsulta)) {
                System.out.println("Curso encontrado:");
                System.out.println("IdCurso: " + idCurso[i]);
                System.out.println("Nombre: " + nombreCurso[i]);
                System.out.println("Créditos: " + numCreditos[i]);
                System.out.println("Ciclo: " + ciclo[i]);
                System.out.println("Pre-requisito: " + idPreRequisito[i]);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró el curso con ese nombre.");
        }
    }

    static void consultarPorCiclo(Scanner scanner) {
        if (NT == 0) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        System.out.print("Ingresa el ciclo a consultar: ");
        int cicloConsulta = scanner.nextInt();
        boolean encontrado = false;
        for (int i = 0; i < NT; i++) {
            if (ciclo[i] == cicloConsulta) {
                System.out.println("Curso encontrado:");
                System.out.println("IdCurso: " + idCurso[i]);
                System.out.println("Nombre: " + nombreCurso[i]);
                System.out.println("Créditos: " + numCreditos[i]);
                System.out.println("Ciclo: " + ciclo[i]);
                System.out.println("Pre-requisito: " + idPreRequisito[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron cursos en este ciclo.");
        }
    }

    static void ordenarPorNombre() {
        if (NT == 0) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        CursoData[] cursos = new CursoData[NT];
        for (int i = 0; i < NT; i++) {
            cursos[i] = new CursoData(idCurso[i], nombreCurso[i], numCreditos[i], ciclo[i], idPreRequisito[i]);
        }
        Arrays.sort(cursos);
        for (int i = 0; i < NT; i++) {
            idCurso[i] = cursos[i].idCurso;
            nombreCurso[i] = cursos[i].nombreCurso;
            numCreditos[i] = cursos[i].numCreditos;
            ciclo[i] = cursos[i].ciclo;
            idPreRequisito[i] = cursos[i].idPreRequisito;
        }
        System.out.println("Cursos ordenados alfabéticamente por nombre:");
        reportarCursos();
    }

    static void ordenarPorCiclo() {
        if (NT == 0) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        CursoData[] cursos = new CursoData[NT];
        for (int i = 0; i < NT; i++) {
            cursos[i] = new CursoData(idCurso[i], nombreCurso[i], numCreditos[i], ciclo[i], idPreRequisito[i]);
        }
        Arrays.sort(cursos, (c1, c2) -> Integer.compare(c2.ciclo, c1.ciclo));
        for (int i = 0; i < NT; i++) {
            idCurso[i] = cursos[i].idCurso;
            nombreCurso[i] = cursos[i].nombreCurso;
            numCreditos[i] = cursos[i].numCreditos;
            ciclo[i] = cursos[i].ciclo;
            idPreRequisito[i] = cursos[i].idPreRequisito;
        }
        System.out.println("Cursos ordenados en forma descendente por ciclo:");
        reportarCursos();
    }
    static void matricularAlumno(Scanner scanner) {
        if (NT == 0) {
            System.out.println("No hay cursos disponibles para matricular.");
            return;
        }
        System.out.print("Ingrese el IdAlumno (9 dígitos): ");
        int idAlumnoInput = scanner.nextInt();
        scanner.nextLine();
        if (String.valueOf(idAlumnoInput).length() != 9) {
            System.out.println("Error: El IdAlumno debe tener 9 dígitos.");
            return;
        }
        System.out.print("Ingrese el nombre del alumno: ");
        String nombreAlumnoInput = scanner.nextLine();
        int alumnoIndex = -1;
        for (int i = 0; i < NA; i++) { //NUMERO ALUMNOS
            if (idAlumno[i] == idAlumnoInput) {
                alumnoIndex = i;
                break;
            }
        }
        if (alumnoIndex == -1) {
            alumnoIndex = NA;
            idAlumno[NA] = idAlumnoInput;
            nombreAlumno[NA] = nombreAlumnoInput;
            NA++;
        }
        int totalCreditos = 0;
        int cursosMatriculados = 0;

        while (true) {
            System.out.print("\nIngrese el Id del curso a matricular (7 caracteres): ");
            String idCursoInput = scanner.nextLine();
            int cursoIndex = -1;
            for (int i = 0; i < NT; i++) {
                if (idCurso[i].equalsIgnoreCase(idCursoInput)) {
                    cursoIndex = i;
                    break;
                }
            }
            if (cursoIndex == -1) {
                System.out.println("El curso con Id " + idCursoInput + " no existe.");
                continue;
            }
            if (!idPreRequisito[cursoIndex].isEmpty()) {
                boolean requisitoCumplido = false;
                for (int j = 0; j < cursosMatriculados; j++) {
                    if (idCursoMatriculado[alumnoIndex][j].equalsIgnoreCase(idPreRequisito[cursoIndex])) {
                        requisitoCumplido = true;
                        break;
                    }
                }
                if (!requisitoCumplido) {
                    System.out.println("No puede matricularse en este curso porque no cumple con los requisitos.");
                    continue;
                }
            }
            int creditosCurso = numCreditos[cursoIndex];
            if (totalCreditos + creditosCurso > 21) {
                System.out.println("No puede matricularse en este curso porque excede el límite de 21 créditos.");
                continue;
            }
            System.out.print("Ingrese el número de matrícula del curso (1 = Primera, 2 = Segunda, 3 = Tercera, 4 = Cuarta): ");
            int numMatricula = scanner.nextInt();
            scanner.nextLine();
            if (numMatricula == 3 && totalCreditos + creditosCurso > 12) {
                System.out.println("No puede matricularse en este curso porque excede el límite de 12 créditos para tercera matrícula.");
                continue;
            }
            if (numMatricula == 4 && cursosMatriculados >= 1) {
                System.out.println("Solo puede matricularse en un curso en cuarta matrícula.");
                continue;
            }
            idCursoMatriculado[alumnoIndex][cursosMatriculados] = idCurso[cursoIndex];
            nombreCursoMatriculado[alumnoIndex][cursosMatriculados] = nombreCurso[cursoIndex]; 
            creditosCursoMatriculado[alumnoIndex][cursosMatriculados] = creditosCurso;
            cicloCursoMatriculado[alumnoIndex][cursosMatriculados] = ciclo[cursoIndex];
            totalCreditos += creditosCurso;
            cursosMatriculados++;
            System.out.println("Curso " + nombreCurso[cursoIndex] + " matriculado exitosamente.");
            System.out.println("Total de créditos matriculados: " + totalCreditos);
            System.out.print("¿Desea matricularse en otro curso? (s/n): ");
            String continuar = scanner.nextLine();
            if (continuar.equalsIgnoreCase("n")) {
                break;
            }
        }
        System.out.println("\nMatrícula completa. Resumen:");
        for (int i = 0; i < cursosMatriculados; i++) {
            System.out.println("- " + nombreCursoMatriculado[alumnoIndex][i] + " (" + creditosCursoMatriculado[alumnoIndex][i] + " créditos)");
        }
        System.out.println("Total de créditos: " + totalCreditos);
    }

    static void reportarMatriculas() {
        if (NA == 0) {
            System.out.println("No hay alumnos matriculados.");
            return;
        }
        for (int i = 0; i < NA; i++) {
            System.out.println("\nAlumno " + (i + 1) + ":");
            System.out.println("IdAlumno: " + idAlumno[i]);
            System.out.println("Nombre: " + nombreAlumno[i]);
            System.out.println("Cursos matriculados:");
            for (int j = 0; j < idCursoMatriculado[i].length; j++) {
                if (idCursoMatriculado[i][j] != null) {
                    System.out.println("- " + nombreCursoMatriculado[i][j] + " (" + creditosCursoMatriculado[i][j] + " créditos)");
                }
            }
        }
    }
    static class CursoData implements Comparable<CursoData> {
        String idCurso;
        String nombreCurso;
        int numCreditos;
        int ciclo;
        String idPreRequisito;

        public CursoData(String idCurso, String nombreCurso, int numCreditos, int ciclo, String idPreRequisito) {
            this.idCurso = idCurso;
            this.nombreCurso = nombreCurso;
            this.numCreditos = numCreditos;
            this.ciclo = ciclo;
            this.idPreRequisito = idPreRequisito;
        }
        public int compareTo(CursoData other) {
            return this.nombreCurso.compareToIgnoreCase(other.nombreCurso);
        }
    }
}
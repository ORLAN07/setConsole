import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        System.out.println("Operaciones con conjuntos, Selecciona el tipo de operación \n Ingresa numero 1 para intersección. \n Ingresa numero 2 para union. \n Ingresa numero 3 para Diferencia");
        int setsType = scanner.nextInt();

        switch (setsType) {
            case (1):
                System.out.println("Selecciono la operación de intersección, Esta operación requiere de 2 o mas conjuntos");
                System.out.println("Ingrese la cantidad de conjuntos");
                int setsNumber = scanner.nextInt();
                List<Map<Integer, String>> mapListSets = new ArrayList<>();
                Set<String> valuesSet = new TreeSet<>();
                Set<String> intersectionValuesSet = new TreeSet<>();
                if (setsNumber >= 2) {
                    for (int i = 0; i < setsNumber; i++) {
                        mapListSets.add(main.generateSets(scanner, i));
                    }
                    mapListSets.forEach(mapSets ->
                        mapSets.entrySet().forEach(valueSets -> {
                            if(!valuesSet.add(valueSets.getValue())){
                                intersectionValuesSet.add(valueSets.getValue());
                            }
                        })
                    );
                    System.out.println("interseccion de elementos: " + intersectionValuesSet);
                } else {
                    System.out.println("Error, Esta operación requiere de 2 o mas conjuntos");
                }

            case (2):
                System.out.println("Selecciono la operación de unió, Esta operación requiere de 2 o mas conjuntos");
                System.out.println("Ingrese la cantidad de conjuntos");
                int setsNumberUnion = scanner.nextInt();
                List<Map<Integer, String>> mapListSetsUnion = new ArrayList<>();
                List<String> listSetsUnion = new ArrayList<>();
                if (setsNumberUnion >= 2) {
                    for (int i = 0; i < setsNumberUnion; i++) {
                        mapListSetsUnion.add(main.generateSets(scanner, i));
                    }
                    mapListSetsUnion.forEach(mapSetUnion-> {
                        mapSetUnion.entrySet().forEach(mapSetValue -> {
                            listSetsUnion.add(mapSetValue.getValue());
                        });
                    });
                    System.out.println("Union de elementos: " + listSetsUnion);
                } else {
                    System.out.println("Error, Esta operación requiere de 2 o mas conjuntos");
                }
            case (3):

                System.out.println("Selecciono la operación de Diferencia, Esta operación requiere de 2 o mas conjuntos");
                System.out.println("Ingrese la cantidad de conjuntos");
                int setsNumberDiff = scanner.nextInt();
                List<Map<Integer, String>> mapListSetsDiff = new ArrayList<>();
                List<String> listSetsValuesDiff= new ArrayList<>();
                Set<String> setDiff = new TreeSet<>();
                if (setsNumberDiff >= 2) {
                    for (int i = 0; i < setsNumberDiff; i++) {
                        mapListSetsDiff.add(main.generateSets(scanner, i));
                    }
                    mapListSetsDiff.forEach(mapSetDiff -> {
                        mapSetDiff.forEach((key , value) -> {
                            listSetsValuesDiff.add(value);
                        });
                    });
                    listSetsValuesDiff.forEach(value -> {
                        if(!setDiff.add(value)){
                            System.out.println("remove:: " + value);
                            setDiff.remove(value);
                        }
                    });
                    System.out.println("Los elementos diferentes son: " + setDiff);
                } else {
                    System.out.println("Error, Esta operación requiere de 2 o mas conjuntos");
                }
        }
    }


    public Map<Integer, String> generateSets(Scanner scanner, int position) {
        scanner = new Scanner(System.in);
        Map<Integer, String> sets = new HashMap<>();
        System.out.println("Ingrese la cantidad de elementos para el conjunto: " + position);
        int setsElementNumber = scanner.nextInt();
        for (int j = 0; j < setsElementNumber; j++) {
            scanner = new Scanner(System.in);
            System.out.println("Ingrese el valor para el elemento: " + j);
            String valueElement = scanner.nextLine();
            sets.put(j, valueElement);
        }
        System.out.println("Termino...");
        return sets;
    }
}
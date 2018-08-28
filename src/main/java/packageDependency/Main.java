package packageDependency;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * The entry point for the Test program
 */
public class Main {

    public static void main(String[] args) {

        //read input from stdin
        Scanner scan = new Scanner(System.in);
        PackageDependencyService service = new PackageDependencyService();

        while (true) {
            String line = scan.nextLine();

            //no action for empty input
            if (line == null || line.length() == 0) {
                continue;
            }

            //the END command to stop the program
            if ("END".equals(line)) {
                System.out.println("END");
                break;
            }

            List<String> splits = splitAfterOperation(line);
            String operation = splits.get(0);


            if (operation.equalsIgnoreCase("DEPEND")){
                System.out.println(line);
                if (splits.size()<=2){
                    throw new IllegalArgumentException("DEPEND needs alteast two packages. usage: DEPEND A B");
                }
                List<String> packages = splits.subList(2, splits.size());
                service.depend(splits.get(1), packages);
            }

            else if (operation.equalsIgnoreCase("INSTALL")){
                System.out.println(line);
                List<String> packages = splits.subList(1, splits.size());
                service.install(packages.get(0));
            }

            else if (operation.equalsIgnoreCase("LIST")){
                System.out.println(line);
                service.list();
            }

            else if (operation.equalsIgnoreCase("REMOVE")){
                System.out.println(line);
                if (splits.size()==1){
                    throw new IllegalArgumentException("package not supplied; usage: REMOVE A");
                }
                if (splits.size()>2){
                    System.out.println("REMOVE supports only one package at a time. ignoring the rest");
                }
                List<String> packages = splits.subList(1, splits.size());
                service.remove(packages.get(0));
            }

            else {
                throw new IllegalArgumentException(operation + " - unsupported operation. allowed ones are LIST, DEPEND, INSTALL, REMOVE");
            }

        }

    }

    public static List<String> splitAfterOperation(String line){
        String[] splits = line.split("\\s+");
        return Arrays.asList(splits);
    }
}